// Nico Rojas
// CSE 271, Lab 8
// 3.29.16

package edu.miamioh.rojasnm;

/**
 * Creates a course with an assigned LectureHall.
 * 
 * @author rojasnm
 */
public class Class extends LectureHall{

	private LectureHall lectureHall = null;
	private String course = null;

	/**
	 * @param course
	 */
	public Class(String course){
		super();
		this.course = course;
	}
	
	/**
	 * @return course name
	 */
	public String getCourse(){
		return course;
	}

	/**
	 * Assigns a LectureHall to Class
	 * @param a
	 */
	public void setHall(LectureHall a){
		this.lectureHall = a;
	}
	
	/**
	 * @return Lecture hall name
	 */
	public LectureHall getHall(){
		return lectureHall;
	}	
}