import java.util.ArrayList;

public class EndNode extends Node {
	private SpelObject spelObject;
	private double[] lowBounds, highBounds;

	public EndNode(Node ouder, SpelObject spelObject) {
		super(ouder);
		this.spelObject = spelObject;
	}

	public String toString() {
		String r = "( ";

		r += this.spelObject.toString();

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
			lowBounds[i] = spelObject.getPos(i);
			highBounds[i] = spelObject.getPos(i);
		}

	}

	@Override
	public void zoek(double x, double y, ArrayList<SpelObject> objecten) {

		if (this.spelObject.getPos(0) == x && this.spelObject.getPos(1) == y) {
			objecten.add(this.spelObject);
		}

	}
}
