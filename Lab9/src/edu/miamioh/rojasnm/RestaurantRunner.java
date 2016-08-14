// Nico Rojas
// CSE 271, Lab 9
// 4.5.16

package edu.miamioh.rojasnm;
import javax.swing.JFrame;

/**
 * RestaurantBill runner. Creates JFrame for RestaurantBill.java.
 * 
 * @author rojasnm
 */
public class RestaurantRunner {
	public static void main(String[] args) {
		JFrame frame = new RestaurantBill();
		frame.setTitle("Restaurant Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}