package model;

public class kip {
	private int x;
	private int y;
	private int speed;
	private int hit;
	private int straal;
	
	public kip(int x, int y, int speed)
	{
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.straal = 30;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getSpeed(){
		return this.speed;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public int getHit(){
		return this.hit;
	}
	
	public void setHit(int hit)
	{
		this.hit = hit;
	}
	
	public int getStraal(){
		return this.straal;
	}

	public void reduseHit() {
		this.hit--;
	}
}
