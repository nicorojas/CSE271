// Nico Rojas
// CSE 271, Lab 10
// 4.12.16

package edu.miamioh.rojasnm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * GUI for a currency converter. User can select from USD, EUR, or GBP to convert an inputed amount.
 * 
 * @author rojasnm
 */
public class CurrencyConverterFrame extends JFrame {

	private static final int FRAME_WIDTH = 250;
	private static final int FRAME_HEIGHT = 350;

	private JLabel error, sameCurrencies, convertedAmount, convertedAmountText, amountText, titleText, addLine1,
			addLine2, addLine3, addLine4, addLine5, addLine6, fromTo;
	private JTextField amountEntered;
	private JPanel panel;
	private JComboBox<String> currencyFromCombo, currencyToCombo;
	private JButton convertButton;

	private int countConversions, countErrors, countSameCurrency;
	private boolean sameCurrencyType = false;

	/**
	 * Initializes panel, labels, and calls a method to create the text field.
	 */
	public CurrencyConverterFrame() {

		panel = new JPanel();
		amountText = new JLabel();
		titleText = new JLabel("Currency Converter");
		sameCurrencies = new JLabel("Error, currencies must be different.");
		error = new JLabel("Invalid input type, must be number.");
		fromTo = new JLabel("        FROM              TO");

		// Since "\n" doesn't worth with JLabel, I created custom empty lines
		// for formatting purposes
		addLine1 = new JLabel("                                                                ");
		addLine2 = new JLabel("           ");
		addLine3 = new JLabel("                                                                ");
		addLine4 = new JLabel("                                                                ");
		addLine5 = new JLabel("                                                                ");
		addLine6 = new JLabel("                                                                ");

		createTextFields();
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	/**
	 * Adds labels, combo boxes, and a "Convert" button to the panel.
	 */
	private void createPanel() {

		panel.add(titleText); // "Currency Converter"
		panel.add(addLine1);
		panel.add(addLine5);
		panel.add(fromTo); // "FROM   TO"
		panel.add(addLine2);

		createComboBox();

		panel.add(addLine3);
		panel.add(amountText); // "AMOUNT"
		panel.add(amountEntered);
		panel.add(addLine4);
		
		createButtons(panel, convertButton, "Convert");

		panel.setBackground(Color.LIGHT_GRAY);
	
		add(panel);
	}

	/**
	 * Inner-class used to create action events. Determines if the text field is of proper type (double)
	 * and calls on other methods to calculate and display the converted amount.
	 * 
	 * @author rojasnm
	 */
	class ChoiceListener implements ActionListener {
		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
		 * ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {

			String fromCurrency = (String) currencyFromCombo.getSelectedItem();
			String toCurrency = (String) currencyToCombo.getSelectedItem();

			String amountString = amountEntered.getText();
			double amount = 0;

			try { // Tests to see if input is double.
				amount = Double.parseDouble(amountString);
				double newAmount = convertCurrency(fromCurrency, toCurrency, amount);
				outputConversion(newAmount);
			} catch (IllegalArgumentException notNum) {
				erasePanels();
				countErrors++;
				error.setForeground(Color.RED);
				panel.add(error); // Output error message.
				panel.updateUI();
			}
		}
	}

	/**
	 * Creates a button using its parameters then adds the button to the panel.
	 * 
	 * @param panel
	 * @param button
	 * @param buttonText
	 */
	private void createButtons(JPanel panel, JButton button, String buttonText) {

		button = new JButton(buttonText);

		ActionListener listener = new ChoiceListener();
		button.addActionListener(listener);

		panel.add(button);
	}

	/**
	 * Outputs the new amount if two different currencies are selected.
	 * 
	 * @param newAmount
	 */
	private void outputConversion(double newAmount) {

		if (sameCurrencyType == false) { // Only outputs if currencies are not the same.

			DecimalFormat df = new DecimalFormat("#.00"); // Used to format bill.

			erasePanels();
			countConversions++;

			newAmount = Double.parseDouble(df.format(newAmount)); // Format number.

			convertedAmountText = new JLabel("CONVERTED AMOUNT ($, €, £):");
			convertedAmount = new JLabel("" + newAmount);
			panel.add(addLine6);
			panel.add(convertedAmountText);
			panel.add(convertedAmount);
			panel.updateUI();
		}
	}

	/**
	 * Creates user-input fields for amount to convert.
	 */
	private void createTextFields() {

		amountText = new JLabel("AMOUNT ($, €, £):");
		amountEntered = new JTextField(10);
	}

	/**
	 * Creates combo boxes to select currency types.
	 * 
	 * @return panel
	 */
	private JPanel createComboBox() {

		// From
		currencyFromCombo = new JComboBox();
		currencyFromCombo.addItem("USD");
		currencyFromCombo.addItem("EUR");
		currencyFromCombo.addItem("GBP");

		// To
		currencyToCombo = new JComboBox();
		currencyToCombo.addItem("USD");
		currencyToCombo.addItem("EUR");
		currencyToCombo.addItem("GBP");

		panel.add(currencyFromCombo);
		panel.add(currencyToCombo);

		return panel;
	}

	/**
	 * Converts the original currency value to the new value.
	 * 
	 * @param fromCurrency
	 * @param toCurrency
	 * @param amount
	 * @return convertedAmount
	 */
	private double convertCurrency(String fromCurrency, String toCurrency, double amount) {

		double convertedAmount = 0;

		// USD to EUR
		if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
			convertedAmount = amount / 1.42;
			sameCurrencyType = false;
		}

		// USD to GBP
		else if (fromCurrency.equals("USD") && toCurrency.equals("GBP")) {
			convertedAmount = amount / 1.64;
			sameCurrencyType = false;
		}

		// EUR to USD
		else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
			convertedAmount = amount * 1.42;
			sameCurrencyType = false;
		}

		// EUR to GBP
		else if (fromCurrency.equals("EUR") && toCurrency.equals("GBP")) {
			convertedAmount = amount / 1.13;
			sameCurrencyType = false;
		}

		// GBP to USD
		else if (fromCurrency.equals("GBP") && toCurrency.equals("USD")) {
			convertedAmount = amount * 1.64;
			sameCurrencyType = false;
		}

		// GBP to EUR
		else if (fromCurrency.equals("GBP") && toCurrency.equals("EUR")) {
			convertedAmount = amount * 1.13;
			sameCurrencyType = false;
		}

		else { // USD to USD, EUR to EUR, GBP to GBP

			erasePanels();

			sameCurrencies.setForeground(Color.RED);
			panel.add(sameCurrencies);
			panel.updateUI();
			sameCurrencyType = true;
			countSameCurrency++;
		}

		return convertedAmount;
	}

	/**
	 * Resets all messages (error messages and new conversion amount messages).
	 */
	private void erasePanels() {

		if (countSameCurrency > 0) {
			panel.remove(sameCurrencies);
		}
		if (countConversions > 0) {
			panel.remove(convertedAmountText);
			panel.remove(convertedAmount);
		}
		if (countErrors > 0) {
			panel.remove(error);
		}
	}
}