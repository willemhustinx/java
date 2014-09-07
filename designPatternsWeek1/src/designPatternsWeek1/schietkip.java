package designPatternsWeek1;

import javax.swing.*;

import vieuw.kipCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class schietkip {

	private model.world world;
	private vieuw.kipCanvas kipcanvas;
	
	public int topheight;
	public int leftweight;
	
	public static void main(String[] args) 
	{
		new schietkip();
	}
	
	public schietkip()
	{
		this.world = new model.world(400, 800);
		kipcanvas = new vieuw.kipCanvas(this.world);
		
		topheight = kipcanvas.frame.getInsets().top;
		leftweight = kipcanvas.frame.getInsets().left;
		
		
		kipcanvas.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				schiet(me.getPoint().x, me.getPoint().y);
			}
		});

		
		Thread animationThread = new Thread(new Runnable() {
			public void run() {
				while (true) {
					move();
					kipcanvas.repaint();
					try {
						Thread.sleep(10);
					} catch (Exception ex) {
					}
				}
			}
		});

		animationThread.start();
	}
	
	public void move() {
		
		if (this.world.getKip().getX() == this.world.getweight() + 2 * this.world.getKip().getStraal()) {
			this.world.getKip().setX(0 - (2 * this.world.getKip().getStraal()));
		} else {
			this.world.getKip().setX(this.world.getKip().getX() + this.world.getKip().getSpeed());
		}
		
		if(this.world.getKip().getHit() > 0)
		{
			this.world.getKip().reduseHit();
		}
	}

	public void schiet(int x, int y) {
		
		System.out.println(x + ", " + y);

		int deltax = x - this.world.getKip().getX();
		int deltay = y - this.world.getKip().getY();

		int distance2 = deltax * deltax + deltay * deltay;

		boolean raak = distance2 < this.world.getKip().getStraal() * this.world.getKip().getStraal();

		if (raak) {
			this.world.getKip().setHit(50);
			System.out.println("raak. kip dood");
		} else {
			System.out.println("mis");
		}
	}

}

