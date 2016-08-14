// Nico Rojas
// CSE 271, Lab 8
// 3.28.16

package edu.miamioh.rojasnm;

/**
 * AdminStaff is responsible for administrative work such as enrolling students
 * in a class, assigning a LectureHall to a class, and assigning an Instructor
 * to a class.
 * 
 * @author rojasnm
 */
public class AdminStaff extends LectureHall {

	private String email;
	private int id;
	private double salary;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param i
	 *            the id to set
	 */
	public void setId(int i) {
		this.id = i;
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
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * Enrolls a student in a class.
	 * @param a (Student a)
	 * @param b (Class b)
	 */
	public void enroll(Student a, Class b) {

		if (b.getCurrentAmount() >= (b.getHall()).getCapacity()) {
			// Empty 'if statement' because if the # of students currently
			// enrolled exceeds the hall
			// maximum capacity, then the student is not added to the class.
		}

		else {
			b.setCurrentAmount(); // +1 to current # of students enrolled in
									// class
			a.setClasses(b);
		}
	}

	/**
	 * Assigns a LectureHall to a class.
	 * @param course
	 * @param hall
	 */
	public void assignHall(Class course, LectureHall hall) {
		course.setHall(hall);
	}

	/**
	 * Assigns an Instructor to a class.
	 * @param a (Instructor a)
	 * @param course
	 */
	public void assignInstructor(Instructor a, Class course) {
		a.setClasses(course);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdminStaff [id = " + id + ", email = " + email + ", salary = $" + salary + "]";
	}
}