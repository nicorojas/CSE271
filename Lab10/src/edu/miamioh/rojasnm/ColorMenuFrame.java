// Nico Rojas
// CSE 271, Lab 10
// 04.12.16

package edu.miamioh.rojasnm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The ColorMenu application changes the panel color depending on either the user clicking on the background
 * or selecting a color from the drop-down menu. The colors rotate from red to green to blue to red, etc.
 * 
 * @author rojasnm
 */
public class ColorMenuFrame extends JFrame {

	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 300;
	private JComboBox<String> colorCombo;
	private ActionListener listener;
	private MouseListener mouseListener;
	private JPanel panel;

	/**
	 * Initializes the panel, mouse listener, and combo box choice listener. Sets the default
	 * background color and calls on a method to create the combo boxes.
	 */
	public ColorMenuFrame() {

		panel = new JPanel();
		mouseListener = new MousePressListener();
		listener = new ChoiceListener();
		
		panel.addMouseListener(mouseListener);
		panel.setBackground(Color.RED); // Default color, red.
		
		createComboBox();
		
		add(panel);
		
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	/**
	 * ChoiceListener finds the color choice selected by the user, then calls on a method which changes the color
	 * to the selected color.
	 * 
	 * @author rojasnm
	 */
	class ChoiceListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String color = (String) colorCombo.getSelectedItem();
			setColor(color);
		}
	}

	/**
	 * Calls on a method which rotates the background colors whenever the user clicks anywhere in the panel.
	 * 
	 * @author rojasnm
	 */
	class MousePressListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			rotateColor();
		}

		@Override
		public void mouseReleased(MouseEvent e) {}
	}

	/**
	 * Creates the combo box with options for each color.
	 * 
	 * @return panel
	 */
	private JPanel createComboBox() {

		colorCombo = new JComboBox<String>();
		colorCombo.addItem("Red");
		colorCombo.addItem("Green");
		colorCombo.addItem("Blue");
		colorCombo.addActionListener(listener);
		panel.add(colorCombo);
		
		return panel;
	}

	/**
	 * Takes in the desired color as a parameter and then switches the background to that color.
	 * 
	 * @param color
	 */
	private void setColor(String color) {

		if (color == "Red")
			panel.setBackground(Color.RED);

		else if (color == "Green")
			panel.setBackground(Color.GREEN);

		else
			panel.setBackground(Color.BLUE);
	}

	/**
	 * Rotates the colors from red to green to blue to red and so on.
	 */
	private void rotateColor(){
		
		Color currentColor = panel.getBackground();
		
		if(currentColor == Color.RED)
			panel.setBackground(Color.GREEN);
		
		else if(currentColor == Color.GREEN)
			panel.setBackground(Color.BLUE);
		
		else
			panel.setBackground(Color.RED);
	}
}