import java.awt.List;
import java.util.ArrayList;

public class SplitNode extends Node {
	private Node leftChild, rightChild;
	private double[] lowBounds, highBounds;

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

		if (this.leftChild == null)
			r += "null";
		else
			r += this.leftChild.toString();

		r += " , ";

		if (this.rightChild == null)
			r += "null";
		else
			r += this.rightChild.toString();

		r += " )";

		return r;
	}

	public double lowerBound(int index) {
		if (lowBounds == null) {
			this.setBounds();
		}

		return this.lowBounds[index];
	}

	public double upperBound(int index) {
		if (highBounds == null) {
			this.setBounds();
		}

		return this.highBounds[index];
	}

	public void setBounds() {
		lowBounds = new double[SpelObject.DIMENSION];
		highBounds = new double[SpelObject.DIMENSION];

		for (int i = 0; i < SpelObject.DIMENSION; i++) {
			double leftlow, rightlow, lefthigh, righthigh;

			leftlow = this.leftChild.lowerBound(i);
			rightlow = this.rightChild.lowerBound(i);

			if (leftlow < rightlow)
				lowBounds[i] = leftlow;
			else
				lowBounds[i] = rightlow;

			lefthigh = this.leftChild.upperBound(i);
			righthigh = this.rightChild.upperBound(i);

			if (lefthigh > righthigh)
				highBounds[i] = lefthigh;
			else
				highBounds[i] = righthigh;
		}

	}



	@Override
	public void zoek(double x, double y, ArrayList<SpelObject> objecten) {
		if(lowBounds[0] <= x && highBounds[0] >= x && lowBounds[1] <= y && highBounds[1] >=y)
		{
			this.leftChild.zoek(x, y, objecten);
			this.rightChild.zoek(x, y, objecten);
		}
		
	}
}
