// Nico Rojas
// CSE 271, Lab 9
// 4.5.16

package edu.miamioh.rojasnm;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * GUI for a restaurant bill. User can add from available items or input their own. When ready, a 
 * final price can be calculated and displayed along with a complete bill.
 * 
 * @author rojasnm
 */
@SuppressWarnings("serial")
public class RestaurantBill extends JFrame {

	private static final int FRAME_WIDTH = 350;
	private static final int FRAME_HEIGHT = 650;
	private static final int AREA_ROWS = 13;
	private static final int AREA_COLUMNS = 28;

	// Keep track of all items added to bill
	ArrayList<String> list = new ArrayList<String>(); 

	private JLabel popularItems, customName, customPrice, customOrderText, addLine1, addLine2, addLine3;
	private JTextField itemName, itemPrice;
	private JPanel panel;

	private JButton sPizza, mPizza, lPizza, xlPizza, breadSticks, lasagne, ravioli, gelato, calzone, drink,
			finishOrder, addCustom;
	private JTextArea resultArea;
	
	private double total = 0; // Total bill cost

	/**
	 * Initializes panel, text area, and labels.
	 */
	public RestaurantBill() {

		panel = new JPanel();
		resultArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		resultArea.setEditable(false);
		customOrderText = new JLabel("Custom Item:");
		popularItems = new JLabel("Popular Items:");

		// Since "\n" doesn't worth with JLabel, I created custom empty lines for formatting purposes
		addLine1 = new JLabel("                                                                ");
		addLine2 = new JLabel("                                                                ");
		addLine3 = new JLabel("                                                                ");

		createTextFields();
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	/**
	 * Adds buttons and text area to create a JPanel.
	 */
	private void createPanel() {
		
		panel.add(popularItems);
		panel.add(addLine1);
		createButtons(panel, sPizza, "[S] Pizza", 8.99);
		createButtons(panel, mPizza, "[M] Pizza", 10.99);
		createButtons(panel, lPizza, "[L] Pizza", 12.99);
		createButtons(panel, xlPizza, "[XL] Pizza", 14.99);
		createButtons(panel, breadSticks, "Breadsticks", 4.99);
		createButtons(panel, lasagne, "Lasagne", 6.99);
		createButtons(panel, ravioli, "Ravioli", 6.99);
		createButtons(panel, gelato, "Gelato", 3.99);
		createButtons(panel, calzone, "Calzone", 3.99);
		createButtons(panel, drink, "Soft Drink", 1.99);
		panel.add(addLine2);
		panel.add(customOrderText);
		panel.add(addLine3);
		panel.add(customName); // Custom entry item
		panel.add(itemName);
		panel.add(customPrice); // Custom entry price
		panel.add(itemPrice);
		createButtons(panel, addCustom, "Add Custom Order", 0);
		
		JScrollPane scrollPane = new JScrollPane(resultArea);
		
		panel.add(scrollPane);
		createButtons(panel, finishOrder, "Finish Order", 0);
		panel.setBackground(Color.LIGHT_GRAY);
		add(panel);
	}

	/**
	 * Inner-class used to create action events for each JButton in RestaurantBill.
	 * The actionPerformed(ActionEvent e) method determines which button is pressed and 
	 * responds by performing a determined action.
	 * 
	 * @author rojasnm
	 */
	class AddBillListener implements ActionListener {
		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
		 * ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {

			JButton button = (JButton) e.getSource();
			String name = button.getText(); // Name of button

			if (name == "Finish Order") { // Calculate and display bill

				button.setForeground(Color.RED);
				displayBill();
			}

			else if (name == "Add Custom Order") { // Add custom item to bill

				addCustomOrder();
			}

			else { // Add popular item to bill
				resultArea.append(name + "\n");
				list.add(name);
				total += getPrice(name);
			}
		}
	}

	/**
	 * Creates a button using its parameters then adds the button to the panel.
	 * 
	 * @param panel
	 * @param button
	 * @param buttonText
	 * @param price
	 */
	private void createButtons(JPanel panel, JButton button, String buttonText, double price) {

		if (price > 0) // Add price
			button = new JButton(buttonText + " $" + price);

		else // Button doesn't need price
			button = new JButton(buttonText);

		ActionListener listener = new AddBillListener();
		button.addActionListener(listener);

		panel.add(button);
	}

	/**
	 * Creates user-input fields for custom items/prices.
	 */
	private void createTextFields() {

		// Input custom item name
		customName = new JLabel("Enter Item name: ");
		itemName = new JTextField(10);
		itemName.setText("");

		// Input custom item price
		customPrice = new JLabel("Enter Custom Order Price: $");
		itemPrice = new JTextField(5);
		itemPrice.setText("");
	}

	/**
	 * Gets the price of a popular food dish or drink.
	 * 
	 * @param buttonName
	 * @return the price
	 */
	private double getPrice(String buttonName) {

		double price = 0;

		if (buttonName.equals("[S] Pizza $8.99"))
			price = 8.99;

		else if (buttonName.equals("[M] Pizza $10.99"))
			price = 10.99;

		else if (buttonName.equals("[L] Pizza $12.99"))
			price = 12.99;

		else if (buttonName.equals("[XL] Pizza $14.99"))
			price = 14.99;

		else if (buttonName.equals("Breadsticks $4.99"))
			price = 4.99;

		else if ((buttonName.equals("Lasagne $6.99")) || (buttonName.equals("Ravioli $6.99")))
			price = 6.99;

		else if ((buttonName.equals("Gelato $3.99")) || (buttonName.equals("Calzone $3.99")))
			price = 3.99;

		else
			price = 1.99; // soft drink

		return price;
	}

	/**
	 * Calculate and display the customer's final bill.
	 */
	private void displayBill(){
		
		DecimalFormat df = new DecimalFormat("#.00"); // Used to format bill
		
		resultArea.setText("FINAL RESTAURANT BILL\n\n");

		for (int i = 0; i < list.size(); i++)
			resultArea.append(list.get(i) + "\n"); // Output all items on bill, one per line
		
		total = Double.parseDouble(df.format(total));
		resultArea.append("\nTOTAL:		$" + total);
		double tip = Double.parseDouble(df.format(total * 0.2));
		resultArea.append("\nSUGGESTED TIP (20%):	$" + tip);
		double tax = Double.parseDouble(df.format(total * 0.05));
		resultArea.append("\nTAX (5%):		$" + tax);
		resultArea.append("\n______________________________________");
		total = Double.parseDouble(df.format(total + tip + tax));
		resultArea.append("\nTOTAL (w/ TAX & SUG. TIP):	$" + (total));
	}

	/**
	 * Read user input and record item/price in arraylist. Uses try/catch to check that input
	 * is of valid type. Finally, the method resets the text fields back to blank.
	 */
	private void addCustomOrder(){
		
		if ((itemName.getText().equals("")) || (itemPrice.getText().equals(""))) {
			resultArea.append("Empty text fields, item not added.\n"); // If field is empty
		}
		else {
			try { // Check if price is number
				double customPrice = Double.parseDouble(itemPrice.getText());
				resultArea.append(itemName.getText() + " $" + itemPrice.getText() + "\n");
				list.add(itemName.getText() + " $" + itemPrice.getText());
				total += customPrice;
			} catch (IllegalArgumentException empty) {
				resultArea.append("Invalid price input, item not added.\n");
			}
		}
		
		// Reset text fields
		itemName.setText("");
		itemPrice.setText("");
	}
}