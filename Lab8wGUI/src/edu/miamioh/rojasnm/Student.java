// Nico Rojas
// CSE 271, Lab 8
// 3.28.16

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
		this.setId(id);
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
	 * 
	 * @param grade
	 */
	public void setFinalGrade(double grade) {
		this.finalGrade = grade;
	}

	/**
	 * Adds a class to the student's list of classes.
	 * 
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

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [major = " + major + ", finalGrade = " + finalGrade + ", id = " + getId() + ", email = " + email
				+ ", classes = " + classes + "]";
	}
}