public class SpelObject {
	public static final int DIMENSION = 2;
	private double[] position = new double[DIMENSION];
	
	public SpelObject(double x, double y)
	{
		position[0] = x;
		position[1] = y;
	}
	
	public double getPos(int index) {
		
		int i = index % this.DIMENSION;
		
		return position[i];
	}
	
	public String toString()
	{
		return "(" + position[0] + ", " + position[1] + ")";
		
	}
}