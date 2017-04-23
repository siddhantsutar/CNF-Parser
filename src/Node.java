import java.util.ArrayList;
import java.util.List;

public class Node {

	private String name;
	private List<Rule> rules;
	
	public Node(String name) {
		this.name = name;
		rules = new ArrayList<Rule>();
	}
	
	public void addRule(Node left, Node right) {
		rules.add(new Rule(name, left, right));
	}
	
	public String getName() {
		return name;
	}
	
	public List<Rule> getRules() {
		return rules;
	}
	
	public boolean isAlpha() {
		return (rules.size() == 0);
	}
	
}