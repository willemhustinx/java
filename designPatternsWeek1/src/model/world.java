package model;

public class world {
	
	private kip kip;
	private int height;
	private int width;
	
	public world(int height, int width)
	{
		this.kip = new kip(0, 100, 1);
		this.height = height;
		this.width = width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public int getweight()
	{
		return this.width;
	}
	
	public kip getKip()
	{
		return this.kip;
	}

}
