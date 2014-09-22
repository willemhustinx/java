public class SplitNode extends Node {
	private Node leftChild, rightChild;

	public SplitNode(Node ouder) {
		super(ouder);
		// TODO Auto-generated constructor stub
	}

	public void setLeftChild(Node child) {
		leftChild = child;
		
		if (child != null) {
			child.setParent(this);
		}
	}
	
	public void setRightChild(Node child) {
		rightChild = child;
		
		if (child != null) {
			child.setParent(this);
		}
	}
	
	public String toString() {
		String r = "( ";
		
		if(this.leftChild == null)
			r += "null";
		else
			r += this.leftChild.toString();
		
		r += " , ";
		
		if(this.rightChild == null)
			r += "null";
		else
			r += this.rightChild.toString();
		
		r += " )";
		
		return r;
	}
}
