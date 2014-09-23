import java.util.ArrayList;

public abstract class Node {
	private Node parent;

	public Node(Node ouder) {
		this.parent = ouder;
	}

	public void setParent(Node node) {
		this.parent = node;

	}

	public abstract String toString();

	public abstract double lowerBound(int index);

	public abstract double upperBound(int index);

	public abstract void setBounds();

	public abstract void zoek(ArrayList objecten);
}
