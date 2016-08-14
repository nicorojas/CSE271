// Nico Rojas
// CSE 271, Lab 10
// 04.12.16

package edu.miamioh.rojasnm;

import javax.swing.JFrame;

/**
 * Viewer for ColorMenu.java. Creates a JFrame for the ColorMenu to be displayed in.
 * 
 * @author rojasnm
 */
public class ColorMenuViewer {
	
	public static void main(String[] args) {
		
		JFrame frame = new ColorMenuFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Color Menu");
		frame.setVisible(true);
	}
}