// Nico Rojas
// CSE 271, Lab 11
// 4.26.16

package edu.miamioh.rojasnm;

/**
 * RecursiveFinder contains a method largestElement(int[]) which recursively
 * finds the largest element in an array.
 * 
 * @author rojasnm
 */
public class RecursiveFinder {

	private static int currentLargest = Integer.MIN_VALUE, largestValue;

	/**
	 * Creates three arrays and outputs the largest value in each by calling the largestElement method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int[] array1 = { 3, 19, 96, 15, 9, 41, 1 };
		int[] array2 = { 101, 281, 712, 3987, 29 };
		int[] array3 = { 199, 82, 61, 1236, 11, 41, 1, 934, 211, 44 };

		System.out.println("array1 largest value: " + largestElement(array1));
		System.out.println("array2 largest value: " + largestElement(array2));
		System.out.println("array3 largest value: " + largestElement(array3));
	}

	/**
	 * Recursively finds the largest value in an array of integers.
	 * 
	 * @param array
	 * @return largest value
	 */
	private static int largestElement(int[] array) {

		int arraySize = array.length;

		// Base Case
		if (arraySize == 1) {
			if (array[0] > currentLargest)
				currentLargest = array[0];
			
			largestValue = currentLargest;
			
			// Reset Values
			currentLargest = Integer.MIN_VALUE;
		}

		// Simplifier
		else {

			if (array[0] > array[1] && array[0] > currentLargest)
				currentLargest = array[0];

			else if (array[0] < array[1] && array[1] > currentLargest)
				currentLargest = array[1];

			// Create new array
			int[] newArray = new int[arraySize - 1];
			for (int i = 0; i < arraySize - 1; i++) {

				newArray[i] = array[i + 1]; // new array should consist of
											// previous array minus first index
			}
			largestElement(newArray);
		}
		return largestValue;
	}
}