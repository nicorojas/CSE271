// Nico Rojas
// CSE 271, Lab 11
// 4.26.16

package edu.miamioh.rojasnm;

/**
 * Reverser.java calls on a String reverse method that recursively reverses a String.
 * 
 * @author rojasnm
 */
public class Reverser {

	private static String nextChar, reversedText, newText = "";
	
	/**
	 * Outputs reverse of a String using the reverse method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("hello! : " + reverse("hello!"));
		System.out.println("CSE271 : " + reverse("CSE271"));
		System.out.println("university : " + reverse("university"));
		System.out.println("racecar : " + reverse("racecar"));
	}

	/**
	 * Takes in a String and recursively reverses the String. Returns the
	 * reversed String.
	 * 
	 * @param text
	 * @return reversedText
	 */
	private static String reverse(String text) {

		int textLength = text.length();

		// Base Case
		if (textLength == 1){
			
			// Reversed String
			newText = text + newText;
			reversedText = newText;
		
			// Reset values
			nextChar = "";
			newText = "";
		}
		
		// Simplifier
		else {
			nextChar = text.substring(0,1);
			
			// Temporary String, remove first character
			String tempText = text.substring(1, textLength);
			
			// Reversed String
			newText = nextChar + newText;
			
			reverse(tempText);
		}
		return reversedText;
	}
}