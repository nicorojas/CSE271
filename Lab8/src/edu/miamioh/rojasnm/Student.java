// Nico Rojas
// CSE 271, Lab 8
// 3.29.16

package edu.miamioh.rojasnm;
import java.util.ArrayList;

/**
 * Creates a Student with a major, final grade, ID#, and email. Students are
 * able to set their majors, view a list of classes their taking, view their 
 * final grade, id, and email.
 * 
 * @author rojasnm
 */
public class Student {

	private String major, id, email;
	double finalGrade;
	ArrayList<String> classes = new ArrayList<String>();

	/**
	 * @param major
	 * @param finalGrade
	 */
	public Student(String major, String id, String email) {
		super();
		this.major = major;
		this.id = id;
		this.email = email;
	}

	/**
	 * Sets the major of the student to the given parameter.
	 * 
	 * @param major
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * @return student's final grade.
	 */
	public double getFinalGrade() {

		return finalGrade;
	}

	/**
	 * Sets student's final grade.
	 * @param grade
	 */
	public void setFinalGrade(double grade) {
		this.finalGrade = grade;
	}

	/**
	 * Adds a class to the student's list of classes.
	 * @param a
	 */
	public void setClasses(Class a) {
		classes.add(a.getCourse());
	}

	/**
	 * @return list of classes student is enrolled in.
	 */
	public ArrayList<String> getClasses() {
		return classes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [major = " + major + ", finalGrade = " + finalGrade + ", id = " + id + ", email = " + email
				+ ", classes = " + classes + "]";
	}
}