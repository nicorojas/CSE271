// Nico Rojas
// CSE 271, Lab 5
// 2.26.16

public class Executive extends Manager {

	private String location;

	/**
	 * @param name
	 * @param salary
	 * @param department
	 * @param location
	 */
	public Executive(String name, double salary, String department, String location) {
		super(name, salary, department);
		this.location = location;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Executive [super = " + super.toString() + ", location = " + location + "]";
	}
}