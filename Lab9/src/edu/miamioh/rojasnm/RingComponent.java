// Nico Rojas
// CSE 271, Lab 9
// 4.5.16

package edu.miamioh.rojasnm;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * Overrides paintComponent to draw five Olympic rings in different positions and colors.
 * 
 * @author rojasnm
 */
public class RingComponent extends JComponent {

	/*
	 * (non-Javadoc) * @see
	 * javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */ @Override
	protected void paintComponent(Graphics g) {

		drawRing(g, Color.BLUE, 50, 50);   // Blue
		drawRing(g, Color.YELLOW, 75, 75); // Yellow
		drawRing(g, Color.BLACK, 100, 50); // Black
		drawRing(g, Color.GREEN, 125, 75); // Green
		drawRing(g, Color.RED, 150, 50);   // Red
	}

	/**
	 * Sets the color for an oval to be drawn at coordinates (x,y).
	 * 
	 * @param g
	 * @param color
	 * @param x
	 * @param y
	 */
	public static void drawRing(Graphics g, Color color, int x, int y) {

		// Draw colored circle
		g.setColor(color);
		g.drawOval(x, y, 50, 50);
	}
}