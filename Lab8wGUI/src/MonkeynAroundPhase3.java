/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
* Filename: MonkeynAroundPhase3.java
* Created: 6/10/2010 by Adam Crum
*
* Purpose: To allow creation of a login if a new customer and to simply
* login if existing customer to allow and give them a customized greeting
* after introducing them to the Pizzas-R-Us online ordering system.
*/
//package monkeynaroundphase3;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class MonkeynAroundPhase3 {
public static void main(String[] args)throws FileNotFoundException, IOException

{
// declare and initialize variables
    
String openingMsg1, openingMsg2, openingMsg3, openingMsg4, openingMsg5, 
productMsg1, productMsg2,productMsg3, productMsg4, productMsg, openingMsg, nameInputMsg,
userNameInputMsg, customerName, nameOutputMsg, returnOutputMsg, invalidExit,
greetingOutputMsg, outputMsg, userid, password, loginMsg, pwMsg, invalidEntry, addressMsg,
addressOutput, streetAddress1, streetAddress2, cityAddress, stateAddress, zipAddress,
phoneNumber;
        
// display opening message and system introduction

openingMsg1 = "*** Welcome to Monkey'n Around's Online Ordering System *** \n\n";
openingMsg2 = "You are now able to order your products through our online ";
openingMsg3 = "order system. \n\n";
openingMsg4 = "The baby items you can order here are: ";
openingMsg5 = "Onesies, T-Shirts, Bibs, and Burp clothes. \n\n";
openingMsg = openingMsg1 + openingMsg2 + openingMsg3 + openingMsg4 + openingMsg5;

// display product informatin with size and colors

productMsg1 = "The Onsie and Shirt sizes you can order are: ";
productMsg2 = "Premie, NB, 0-3, 3-6, 6-9, and 9-12 mo. \n\n";
productMsg3 = "Currently the only color available for online order is white. \n\n";
productMsg4 = "Burp Clothes and Bibs come in one size and only white at this time.";
productMsg = productMsg1 + productMsg2 + productMsg3 + productMsg4;
  
// display for any invalid entry

invalidEntry = "We're sorry, but you have made an invalid entry into our system.";
invalidExit = "You have failed three atempts at entering user information.\n\n"
        + "Goodbye!";
        
// Windows for opening message and product information

JOptionPane.showMessageDialog(null, openingMsg);

JOptionPane.showMessageDialog(null, productMsg);


//Boolean variables

Boolean validCustomerName, validUserName, validPwd;

// determine if they are a new or returning customer

int n = JOptionPane.showConfirmDialog(
    null,
    "Are you a returning customer?",
    "Customer",
    JOptionPane.YES_NO_OPTION);

// initalize return flag

int returnFlag = 0;
  if (n == JOptionPane.YES_OPTION){
    returnFlag = 1;
}
  if (n == JOptionPane.NO_OPTION){
      returnFlag = 2;
  }

// switch cases if new customer or returning customer

switch(returnFlag)
{
    
    // Case 1 is used for a current user
case 1:
loginMsg = "You have selected that you are a current user.\n\n "
        + "Please enter your Current username:";
userid = JOptionPane.showInputDialog(null, loginMsg);
for (int i = 1; i <= 3; i++) {
	validUserName = userid.isEmpty();
	if (validUserName) {
		JOptionPane.showMessageDialog(null, invalidEntry);
		if (i == 3) {
                    JOptionPane.showMessageDialog(null, invalidExit);
			System.exit(0);
		}
		else {
			userNameInputMsg = "You have not entered a user name.\n "
                                + "Enter your user name: ";
			userid = JOptionPane.showInputDialog(userNameInputMsg);
		}
	} 
    }

pwMsg = "Please enter your Current password: ";
password = JOptionPane.showInputDialog(null, pwMsg);
break;
    
    // Case 2 is for a new user
case 2:
loginMsg = "You have indicated that you are not a current user. \n\n "
        + "Please choose a username:";
userid = JOptionPane.showInputDialog(null, loginMsg);
   
for (int i = 1; i <= 3; i++) 
        {
	validUserName = userid.isEmpty();
	if (validUserName) 
            {
		JOptionPane.showMessageDialog(null, invalidEntry);
		if (i == 3) {
                    JOptionPane.showMessageDialog(null, invalidExit);
			System.exit(0);
		}
		else {
			userNameInputMsg = "You have not entered a user name.\n "
                                + "Enter your user name: ";
			userid = JOptionPane.showInputDialog(userNameInputMsg);
                    }
            } 
        }   
pwMsg = "Please enter your New password: ";
password = JOptionPane.showInputDialog(null, pwMsg);
break;
    
    //default case
default:
JOptionPane.showMessageDialog(null, invalidEntry);
loginMsg = "Please enter your New username:";
userid = JOptionPane.showInputDialog(null, loginMsg);
pwMsg = "Please enter your New password: ";
password = JOptionPane.showInputDialog(null, pwMsg);
    
} //end switch

// get required customer name using dialog boxes
nameInputMsg = "Please verify your first and last name.\n"
        + "Enter your name: ";
customerName = JOptionPane.showInputDialog( nameInputMsg );

// repeat until a name is entered or exit after 3 tries

  for (int i = 1; i <= 3; i++) {
	validCustomerName = customerName.isEmpty();
	if (validCustomerName) {
		JOptionPane.showMessageDialog(null, invalidEntry);
		if (i == 3) {
                    JOptionPane.showMessageDialog(null, invalidExit);
			System.exit(0);
		}
		else {
			nameInputMsg = "You have not entered a name.\n "
                                + "Enter your name: ";
			customerName = JOptionPane.showInputDialog(nameInputMsg);
		}
	}
	else {
	

	// build output strings
	nameOutputMsg = "Welcome " + customerName + ".\n";
	returnOutputMsg = "Your login is: " + userid + "/" + password + ".\n";
	greetingOutputMsg = "Thank you for visiting Monkey'n Around!" + "\n";
	// create output string
	outputMsg = nameOutputMsg + returnOutputMsg + greetingOutputMsg;
	// display output message
	JOptionPane.showMessageDialog(null, outputMsg);
	break;
        }
}
// Message to prompt user for address
  addressMsg = customerName + ", your address is not on file in our online system. \n"
          + "Please Enter your address in the following dialogs.";
  JOptionPane.showMessageDialog(null, addressMsg);
  
  //User enters address, line by line
  
  streetAddress1 = JOptionPane.showInputDialog ("Street Address:");
  streetAddress2 = JOptionPane.showInputDialog ("Street Address 2 (if applicable):");
  cityAddress = JOptionPane.showInputDialog ("Your City:");
  stateAddress = JOptionPane.showInputDialog ("Your State:");
  zipAddress = JOptionPane.showInputDialog ("Your Zip Code");
  
  //Output of address input
  addressOutput = customerName + " ,you have entered: \n"
          + streetAddress1 +"\n"
          + streetAddress2 +"\n"
          + cityAddress +","
          + stateAddress +"  "
          + zipAddress +"\n";
  JOptionPane.showMessageDialog(null, addressOutput );
  
  //enter phone number
  phoneNumber = JOptionPane.showInputDialog ("What is your main phone number?");
  JOptionPane.showMessageDialog(null, "You have entered " + phoneNumber);
  
  //product purchase
  JOptionPane.showMessageDialog(null, "Please choose the product(s) that you "
          + "would like to order in the following dialog box.");
  
 
 
 
  // output purchase info to file
  
  String writeAddress = "\n\n" + customerName + "\n"
          + streetAddress1 +"\n"
          + streetAddress2 +"\n"
          + cityAddress +","
          + stateAddress + "  "
          + zipAddress +"\n"
          + phoneNumber +"\n\n";
  
  File ordersFile = new File ("/users/adamcrum/Desktop/UserOrders.txt");
  FileWriter var1 = new FileWriter(ordersFile,true);
  PrintWriter var2 = new PrintWriter(var1);
  var2.println(writeAddress);
  var2.close();
  
} // end main

} // end class

