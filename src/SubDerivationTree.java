import java.util.LinkedList;

public class SubDerivationTree {

	private LinkedList<Node> data;
	
	public SubDerivationTree() {
		data = new LinkedList<Node>();
	}
	
	public SubDerivationTree(Node node) {
		data = new LinkedList<Node>();
		data.add(node);
	}
	
	public void add(Node node) {
		data.add(node);
	}
	
	public int getAlphaCount() {
		int res = 0;
		for (Node each : data) {
			if (each.isAlpha()) res++;
		}
		return res;
	}
	
	public LinkedList<Node> getData() {
		return data;
	}
	
	@Override public SubDerivationTree clone() {
		SubDerivationTree res = new SubDerivationTree();
		for (Node each : data) {
			res.add(each);
		}
		return res;
	}
	
	@Override public String toString() {
		StringBuilder res = new StringBuilder();
		for (Node each : data) {
			res.append(each.getName() + " ");
		}
		return res.toString().trim();
	}

}