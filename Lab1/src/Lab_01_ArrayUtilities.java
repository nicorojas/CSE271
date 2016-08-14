// Nico Rojas
// CSE 271 | 01.29.16
// Array helper class.

public class Lab_01_ArrayUtilities {

	public int[] buildIntArray(int length, int fromNum, int toNum){

		int[] randomInts = new int[length];

		for (int i = 0; i < length; i++)
			randomInts[i] = (int) (Math.random() * (toNum-fromNum) + (fromNum+1));

		return randomInts;
		
	} // end buildIntArray

	public void swap(int[] nums, int i, int j){
		
		int count = 0;
		
		if(nums.length % 2 != 0)
			count++;

		while(count < nums.length){
			// Swap even index with odd
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
	
			i+=2;
			j+=2;
			count+=2;
			
		} // end while
	
	} // end swap
	
} // end class
