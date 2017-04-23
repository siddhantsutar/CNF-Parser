import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Queue;

public class DefaultCNFParserModel extends Observable implements CNFParserModel {

	private Map<String, Node> dict;
	private Node start;
	private static final String LAMBDA = ".";
	private String parseTree;
	
	private void buildGrammar(String filename) {
		BufferedReader infile = null;
		try {
			infile = new BufferedReader(new FileReader(filename));
			String buffer;
			createVars(infile.readLine());
			createVars(infile.readLine());
			start = dict.get(infile.readLine());
			infile.readLine(); //skip empty line
			while ((buffer = infile.readLine()) != null) createRule(buffer);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createRule(String input) {
		String[] array = input.split(" ", -1);
		Node left = dict.get(array[0]);
		Node right1 = dict.get(array[1]);
		Node right2 = array.length == 3 ? dict.get(array[2]) : null;
		left.addRule(right1, right2);
	}
	
	private void createVars(String input) {
		String[] array = input.split(" ", -1);
		for (String each : array) dict.put(each, new Node(each));
	}
	
	public String getParseTree() {
		return parseTree;
	}
	
	public String serialize(String input) {
		return input.replace(" ", "").replace("", " ").trim();
	}
	
	public void setFilename(String filename) {
		dict = new HashMap<String, Node>();
		start = null;
		dict.put(LAMBDA, new Node(LAMBDA));
		buildGrammar(filename);
	}
	
	public void setParseTree(String word) {
		DerivationTree dt;
		SubDerivationTree sdt;
		Queue<DerivationTree> buffer = new LinkedList<DerivationTree>();
		buffer.add(new DerivationTree(start));
		word = serialize(word);
		while (!buffer.isEmpty()) {
			dt = buffer.poll();
			sdt = dt.peek();
			if (sdt.getAlphaCount() > word.length()+1) break;
			if (sdt.toString().equals(word)) {
				updateParseTree(dt.toString());
				return;
			}
			for (Node each : sdt.getData()) {
				if (!each.isAlpha()) {
					for (Rule rule : each.getRules()) {
						dt.addFirst(substitute(sdt, each, rule));
						buffer.add(dt.clone());
						dt.remove();
					}
				}
			}
		}
		updateParseTree("Word does not exist in the grammar!");
	}
	
	private SubDerivationTree substitute(SubDerivationTree tree, Node from, Rule to) {
		SubDerivationTree res = new SubDerivationTree();
		for (Node each : tree.getData()) {
			if (each == from) {
				if (to.getLeft() != null && !to.getLeft().getName().equals(LAMBDA)) res.add(to.getLeft());
				if (to.getRight() != null) res.add(to.getRight());
			}
			else res.add(each);
		}
		return res;
	}
	
	private void updateParseTree(String input) {
		parseTree = input;
		setChanged();
		notifyObservers(parseTree);
	}

}