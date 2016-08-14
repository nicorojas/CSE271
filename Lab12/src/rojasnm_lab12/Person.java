// Nico Rojas
// CSE 271, Lab 12
// 4.29.16

package edu.miamioh.rojasnm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Person creates a person with a String name.
 * @author rojasnm
 */
public class Person implements Comparable<Person> {

	private String name;
	static Scanner scan = new Scanner(System.in);
	static ArrayList<String> names = new ArrayList<String>();
	
	/**
	 * Reads user input and sends an arraylist containing user-inputted names to be sorted.
	 * @param args
	 */
	public static void main(String[] args){
		
		for(int i = 1; i <= 10; i++){
			System.out.println("Enter Name " + i + ": ");
			String nameInput = scan.next();      // read input
			Person name = new Person(nameInput); // create Person
			names.add(name.toString());          // add Person to arraylist
		}
		System.out.println(names.toString()); // output initial arraylist
		Collections.sort(names, String.CASE_INSENSITIVE_ORDER); // sorts alphabetically
		System.out.println("First sorted index: " + names.get(0).toString()); // first index
		System.out.println("Last sorted index: " + names.get(names.size()-1).toString()); // last index
	} 

	/**
	 * Constructor, initializes name.
	 * @param name
	 */
	public Person(String name){
		this.name = name;
	}
	
	/**
	 * Overrides default toString. Returns Person's name.
	 * @return name
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * compareTo method for the Comparable interface.
	 * @param o
	 * @return 0
	 */
	@Override
	public int compareTo(Person o) {
		return 0;
	}
}