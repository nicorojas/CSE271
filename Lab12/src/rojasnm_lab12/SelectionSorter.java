// Nico Rojas
// CSE 271, Lab 12
// 4.29.16

/**
 * SelectionSorter contains two methods, sorting an array in descending order.
 * 
 * @author rojasnm
 */
public class SelectionSorter {

	
	/**
	 * Takes in an array of integers and uses a for loop to send its values to 
	 * maximumPosition() where it is sorted from largest value to smallest.
	 * 
	 * @param a
	 */
	public static void sort(int[] a){
		
		for(int i = 0; i < a.length - 1; i++){

			int maxPos = maximumPosition(a, i);
			ArrayUtil.swap(a, maxPos, i);
		}
	}

	/**
	 * Compares the parameter int from with all other preceding values in the array
	 * and checks for the largest value. The largest value is returned.
	 * 
	 * @param a
	 * @param from
	 * @return maxPos
	 */
	private static int maximumPosition(int[] a, int from){
		
		int maxPos = from;
		
		for(int i = from + 1; i < a.length; i++){
			if(a[i] > a[maxPos])
				maxPos = i;
		}
		return maxPos;
	}
}