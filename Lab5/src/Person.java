// Nico Rojas
// CSE 271, Lab 5
// 2.26.16

public class Person {

	private String name;
	private int birthYear;

	/**
	 * @param name
	 * @param birthYear
	 */
	public Person(String name, int birthYear) {
		super();
		this.name = name;
		this.birthYear = birthYear;
	}

	@Override
	public String toString() {
		return "Person [name = " + name + ", birthYear = " + birthYear + "]";
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birthYear
	 */
	public int getBirthYear() {
		return birthYear;
	}

	/**
	 * @param birthYear the birthYear to set
	 */
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
}