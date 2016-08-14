// Nico Rojas
// CSE 271, Lab 8
// 3.29.16

package edu.miamioh.rojasnm;
import java.util.ArrayList;

/**
 * Instructor is responsible for assigning final grades to students. An Instructor is
 * also able to view a list of classes they are teaching.
 * 
 * @author rojasnm
 */
public class Instructor extends AdminStaff {

	private String id, email;
	private double salary;
	ArrayList<String> classes = new ArrayList<String>();

	/**
	 * @param id
	 * @param email
	 * @param salary
	 */
	public Instructor(String id, String email, double salary) {
		super();
		this.id = id;
		this.email = email;
		this.salary = salary;
	}

	/**
	 * Allows Instructor to assign a final grade (String grade) to a student (Student a).
	 * @param a
	 * @param grade
	 */
	public void assignFinalGrade(Student a, double grade) {
		a.setFinalGrade(grade);
	}

	/**
	 * Allows Instructor to have a class added to their list of classes being taught.
	 * @param course
	 */
	public void setClasses(Class course) {
		classes.add(course.getCourse());
	}

	/**
	 * @return list of classes assigned to Instructor.
	 */
	public ArrayList<String> getInstructorClasses() {
		return classes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Instructor [id = " + id + ", email = " + email + ", salary = $" + salary + ", classes = " + classes
				+ "]";
	}
}