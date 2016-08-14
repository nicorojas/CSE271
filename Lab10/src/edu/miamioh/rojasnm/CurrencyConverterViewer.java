// Nico Rojas
// CSE 271, Lab 10
// 4.12.16

package edu.miamioh.rojasnm;

import javax.swing.JFrame;

/**
 * CurrencyConverterFrame runner. Creates and displays JFrame for CurrencyConverterFrame.java.
 * 
 * @author rojasnm
 */
public class CurrencyConverterViewer {
	
	public static void main(String[] args) {
		
		JFrame frame = new CurrencyConverterFrame();
		frame.setTitle("Currency Converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}