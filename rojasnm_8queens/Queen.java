package edu.miamioh.rojasnm;

/**
 * The Queen class was developed by Dr. Matthew Stephan and modified by Nico Rojas.
 * The class contains an attacks() method which checks to see if two queens can attack
 * each other.
 * 
 * @author stephamd
 */
public class Queen {
	private int row;
	private int column;

	/**
	 * Creates a Queen given a row and a column.
	 * 
	 * @param row
	 * @param column
	 */
	public Queen(int row, int column) {
		this.row = row;
		this.column = column;
	}

	/**
	 * Checks to see if two queens attack each other.
	 * 
	 * @param other
	 * @return
	 */
	public boolean attacks(Queen other) {
		return row == other.row || column == other.column
				|| Math.abs(row - other.row) == Math.abs(column - other.column);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		int space = (column*8) + (row+1);
		
		return " " + space; // "" + "abcdefgh".charAt(column) + (row + 1);
	}
}