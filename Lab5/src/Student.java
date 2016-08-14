// Nico Rojas
// CSE 271, Lab 5
// 2.26.16

public class Student extends Person {

	private String major;

	/**
	 * @param name
	 * @param birthYear
	 */
	public Student(String name, int birthYear, String major) {
		super(name, birthYear);
		this.major = major;
	}

	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [super = " + super.toString() + ", major = " + major + "]";
	}
}