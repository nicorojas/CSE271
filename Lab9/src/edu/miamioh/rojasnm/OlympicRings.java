// Nico Rojas
// CSE 271, Lab 9
// 4.5.16

package edu.miamioh.rojasnm;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * RingComponent runner. Creates a JFrame in which a JComponent exists.
 * 
 * @author rojasnm
 */
public class OlympicRings {
	
	private static JComponent component;
	
	/**
	 * Initializes JFrame and JComponent. 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setSize(250, 200);
		frame.setTitle("Olympic Rings");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		component = new RingComponent();
		frame.add(component);
		frame.setVisible(true);	
	}
}