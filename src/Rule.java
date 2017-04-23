public class Rule {

	private String name;
	private Node left;
	private Node right;
	
	public Rule(String name, Node left, Node right) {
		this.name = name;
		this.left = left;
		this.right = right;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public Node getRight() {
		return right;
	}
	
}