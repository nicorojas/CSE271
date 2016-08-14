// Nico Rojas
// CSE 271 | 01.29.16
// Lab1 tester class.

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Lab_01_Tester {

	public static void main(String[] args) throws FileNotFoundException {

		PrintWriter newFile = new PrintWriter(new File("Lab_01_nums.txt"));
		Lab_01_ArrayUtilities Utilities = new Lab_01_ArrayUtilities();

		int[] randomInts = Utilities.buildIntArray(20, 10, 29);

		// ------ Print randomInts array to screen, save to .txt ------- //
		newFile.print("[");
		System.out.print("[");
		for (int i = 0; i < randomInts.length; i++) {
			System.out.print(randomInts[i]);
			newFile.print(randomInts[i]);

			if (i < randomInts.length-1) {
				System.out.print(", ");
				newFile.print(", ");
			}
		}
		System.out.println("]");
		newFile.print("]");

		// ------- Swap and print even and odd index within array ------ //

		Utilities.swap(randomInts, 0, 1);
		newFile.println("\n");
		newFile.print("[");
		System.out.print("\n[");

		for (int i = 0; i < randomInts.length; i++) {

			newFile.print(randomInts[i]);
			System.out.print(randomInts[i]);

			if (i < randomInts.length-1) {
				newFile.print(", ");
				System.out.print(", ");
			}
		}
		System.out.print("]");
		newFile.print("]");
		newFile.println("\n");

		// --------------------- Sort and print array ------------------ //

		Arrays.sort(randomInts);
		newFile.print("[");
		System.out.print("\n\n[");

		for (int i = 0; i < randomInts.length; i++) {

			System.out.print(randomInts[i]);
			newFile.print(randomInts[i]);

			if (i < randomInts.length-1) {
				newFile.print(", ");
				System.out.print(", ");
			}
		}
		System.out.println("]");
		newFile.print("]");
		newFile.println("\n");

		// -------------------------- Odd Numbers ---------------------- //

		int numOfOdds = 0; // in single array

		for (int i = 0; i < randomInts.length; i++) {

			if (randomInts[i] % 2 != 0)
				numOfOdds++;
		}

		newFile.println("Odd values: " + numOfOdds);
		System.out.println("\nOdd values: " + numOfOdds);

		// ----------------- Vowels, Consonants, Characters ------------- //

		int vowels = 0, consonants = 0, characters = 0;
		Scanner in = new Scanner(new File("words.txt"));
		String text = "";
		
		while(in.hasNext()) // convert words.txt to string
			text += in.next();
	
		for(int i = 0; i < text.length(); i++){
			
			if((text.charAt(i) == 'a')||(text.charAt(i) == 'e')||
			  (text.charAt(i) == 'i')||(text.charAt(i) == 'o')||
			  (text.charAt(i) == 'u')||(text.charAt(i) == 'A')||
			  (text.charAt(i) == 'E')||(text.charAt(i) == 'I')||
			  (text.charAt(i) == 'O')||(text.charAt(i) == 'U')) 
				vowels++; // count vowels
			
			else if((text.charAt(i) == 'q')||(text.charAt(i) == 'w')||
			  (text.charAt(i) == 'r')||(text.charAt(i) == 't')||
			  (text.charAt(i) == 'y')||(text.charAt(i) == 'p')||
			  (text.charAt(i) == 's')||(text.charAt(i) == 'd')||
			  (text.charAt(i) == 'f')||(text.charAt(i) == 'g')||
			  (text.charAt(i) == 'h')||(text.charAt(i) == 'j')||
			  (text.charAt(i) == 'k')||(text.charAt(i) == 'l')||
			  (text.charAt(i) == 'z')||(text.charAt(i) == 'x')||
			  (text.charAt(i) == 'c')||(text.charAt(i) == 'v')||
			  (text.charAt(i) == 'b')||(text.charAt(i) == 'n')||
			  (text.charAt(i) == 'm')||(text.charAt(i) == 'Q')||
			  (text.charAt(i) == 'W')||(text.charAt(i) == 'R')||
			  (text.charAt(i) == 'T')||(text.charAt(i) == 'Y')||
			  (text.charAt(i) == 'P')||(text.charAt(i) == 'S')||
			  (text.charAt(i) == 'D')||(text.charAt(i) == 'F')||
			  (text.charAt(i) == 'G')||(text.charAt(i) == 'H')||
			  (text.charAt(i) == 'J')||(text.charAt(i) == 'K')||
			  (text.charAt(i) == 'L')||(text.charAt(i) == 'Z')||
			  (text.charAt(i) == 'X')||(text.charAt(i) == 'C')||
			  (text.charAt(i) == 'V')||(text.charAt(i) == 'B')||
			  (text.charAt(i) == 'N')||(text.charAt(i) == 'M')) 
				consonants++; // count consonants
			
			else
				characters++; // count other characters
		}

		newFile.printf("\nThere were %1d", vowels);
		newFile.printf(" vowels, %1d", consonants);
		newFile.printf(" consonants, and %1d", characters);
		newFile.print(" characters.");

		System.out.println("\nThere were " + vowels + " vowels, " +
		                   consonants + " consonants, and " + 
				           characters + " characters.");
		
		newFile.close();
		in.close();

	} // end main

} // end class