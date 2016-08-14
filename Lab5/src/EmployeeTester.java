// Nico Rojas
// CSE 271, Lab 5
// 2.26.16

public class EmployeeTester {

	public static void main(String[] args) {

		// Employee Tester
		Employee cashier = new Employee("John", 75000);
		Manager boss = new Manager("Adam", 100000, "Sales");
		Executive ceo = new Executive("Susan", 200000, "Marketing", "Oxford");
		System.out.println(cashier);
		System.out.println(boss);
		System.out.println(ceo);
	}
}
