import java.util.LinkedList;
import java.util.ListIterator;

public class DerivationTree {
	
	private LinkedList<SubDerivationTree> data;
	
	public DerivationTree() {
		data = new LinkedList<SubDerivationTree>();
	}
	
	public DerivationTree(Node node) {
		data = new LinkedList<SubDerivationTree>();
		SubDerivationTree sdt = new SubDerivationTree(node);
		data.add(sdt);
	}
	
	public void add(SubDerivationTree sdt) {
		data.add(sdt);
	}
	
	public void addFirst(SubDerivationTree sdt) {
		data.addFirst(sdt);
	}
	
	public SubDerivationTree peek() {
		return data.peek();
	}
	
	public void remove() {
		data.remove();
	}
	
	@Override public DerivationTree clone() {
		DerivationTree res = new DerivationTree();
		for (SubDerivationTree each : data) {
			res.add(each.clone());
		}
		return res;
	}
	
	@Override public String toString() {
		StringBuilder res = new StringBuilder();
		int i = 1;
		for (ListIterator<SubDerivationTree> it = data.listIterator(data.size()); it.hasPrevious();) {
			res.append(i++ + ". ");
			res.append(it.previous().toString());
			res.append("\n");
		}
		return res.toString().trim();
	}

}