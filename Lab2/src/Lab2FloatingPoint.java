// Nico Rojas
// CSE 271, 02/05/16
// Lab 2, Ask the user to input a set of floating-point values. When the user enters a value
// that is not a number, give the user a second chance to enter the value using exceptions
// by catching the appropriate exception.

import java.util.Scanner;

public class Lab2FloatingPoint {

	public static void main(String[] args) {

	    Scanner in = new Scanner(System.in);
	    boolean tryOne = true, tryTwo = true;
	    float sum = 0;
	
	    while (tryTwo){
	        try{
	            while (tryOne){
	                try{
	                    System.out.print("Enter a floating-point value: ");
	                    String input = in.nextLine();
	                    float f = Float.parseFloat(input);
	                    sum += f;
	                }
	                catch (NumberFormatException ex){
	                	System.out.print("Incorrect input. Enter a floating-point value: ");
	    	            String input = in.nextLine();
	    	            float f = Float.parseFloat(input);
	    	            sum += f;
	    	            tryOne = true;
	                }
	            } // end tryOne
	        } // end try
	        catch (NumberFormatException e){
	            tryTwo = false;
	        }
	    } // end tryTwo
	    
	    System.out.print("The sum of all entered floats is: " + sum);
	} // end main
} // end class