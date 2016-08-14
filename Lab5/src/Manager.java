// Nico Rojas
// CSE 271, Lab 5
// 2.26.16

public class Manager extends Employee {

	private String department;

	/**
	 * @param name
	 * @param salary
	 * @param department
	 */
	public Manager(String name, double salary, String department) {
		super(name, salary);
		this.department = department;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Manager [super = " + super.toString() + ", department = " + department + "]";
	}
}