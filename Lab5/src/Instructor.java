// Nico Rojas
// CSE 271, Lab 5
// 2.26.16

public class Instructor extends Person {

	private double salary;

	/**
	 * @param name
	 * @param birthYear
	 */
	public Instructor(String name, int birthYear, double salary) {
		super(name, birthYear);
		this.salary = salary;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Instructor [super = " + super.toString() + ", salary = $" + salary + "]";
	}
}