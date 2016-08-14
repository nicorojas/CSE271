// Nico Rojas
// CSE 271, Lab 8
// 3.29.16

package edu.miamioh.rojasnm;

/**
 * Creates a lecture hall with a maximum capacity.
 * @author rojasnm
 */
public class LectureHall {

	private int capacity, currentAmount = 0;

	/**
	 * Sets the maximum capacity of LectureHall
	 * @param capacity
	 */
	public void setCapacity(int capacity){
		this.capacity = capacity;
	}

	/**
	 * @return capacity
	 */
	public int getCapacity(){
		return capacity;
	}
	
	/**
	 * Adds 1 to number of enrolled students when an additional student is enrolled in a course offered in a LectureHall
	 */
	public void setCurrentAmount(){
		currentAmount++;
	}
	
	/**
	 * Gets current # of students in LectureHall
	 * @return currentAmount
	 */
	public int getCurrentAmount(){
		return currentAmount;
	}
}