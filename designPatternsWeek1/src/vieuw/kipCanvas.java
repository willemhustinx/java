package vieuw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class kipCanvas extends JComponent {

	public JFrame frame;
	private model.world world;
	
	private model.kip kip;

	public kipCanvas(model.world world) {
		this.world = world;
		frame = new JFrame("Schiet de kip");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(world.getweight(), this.world.getHeight());
		frame.setLocationRelativeTo(null);
		
		frame.add(this);

		frame.setVisible(true);
	}

	public void paintComponent(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		
		model.kip kip = this.world.getKip();

		if (kip.getHit() > 0) {
			gg.setColor(Color.RED);
		} else {
			gg.setColor(Color.BLACK);
		}
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		gg.fillOval(kip.getX() - kip.getStraal(), kip.getY() - kip.getStraal(), 2 * kip.getStraal(), 2 * kip.getStraal());
	}

}