
// Nico Rojas
// CSE 271, Lab 8
// 3.28.16

import javax.swing.JOptionPane;
import edu.miamioh.rojasnm.AdminStaff;
import edu.miamioh.rojasnm.Instructor;
import edu.miamioh.rojasnm.Class;
import edu.miamioh.rojasnm.LectureHall;
import edu.miamioh.rojasnm.Student;

/**
 * Tests Lab8 and all included classes.
 * 
 * @author rojasnm
 *
 */
public class TesterwGUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Create AdminStaff
		AdminStaff staff = new AdminStaff();
		staff.setId(9817221);
		staff.setEmail("staff29@school.edu");
		staff.setSalary(88000);

		// Create Instructors
		Instructor professor = new Instructor("514272", "prof82@school.edu", 85000);
		Instructor dr_brown = new Instructor("1344172", "browndr@school.edu", 91000);

		// Create Students
		Student sophomore = new Student("Criminal Justice", "9812944", "jberr8@school.edu");
		Student kim = new Student("Chemical Engineering", "237824", "kimk@school.edu");
		Student anthony = new Student("Biology", "119383", "anthonywj@school.edu");
		Student first_year = new Student("Graphic Design", "764620", "fskoo99@school.edu");

		// Create LectureHalls
		LectureHall exeterHall = new LectureHall();
		exeterHall.setCapacity(50); // set cap
		exeterHall.setName("Exeter Hall");
		LectureHall bethesdaHall = new LectureHall();
		bethesdaHall.setCapacity(20); // set cap
		bethesdaHall.setName("Bethesda Hall");
		LectureHall glenbrookHall = new LectureHall();
		glenbrookHall.setCapacity(5); // set cap
		glenbrookHall.setName("Glenbrook Hall");
		LectureHall georgetownHall = new LectureHall();
		georgetownHall.setCapacity(100); // set cap
		georgetownHall.setName("Georgetown Hall");

		// Create Classes/Courses
		Class BIO101 = new Class("BIO 101");
		Class ABC123 = new Class("ABC 123");
		Class IMS333 = new Class("IMS 333");
		Class MBI221 = new Class("MBI 221");

		// Assign Halls to Courses -- JOPTIONPANE
		staff.assignHall(BIO101, exeterHall);
		staff.assignHall(ABC123, glenbrookHall);
		staff.assignHall(IMS333, georgetownHall);
		staff.assignHall(MBI221, bethesdaHall);

		// Enroll Students -- JOPTIONPANE
		staff.enroll(sophomore, BIO101);
		staff.enroll(kim, BIO101);
		staff.enroll(first_year, BIO101);
		staff.enroll(sophomore, ABC123);
		staff.enroll(anthony, ABC123);
		staff.enroll(kim, IMS333);
		staff.enroll(first_year, MBI221);
		staff.enroll(anthony, MBI221);

		// Assign Professor to Course -- JOPTIONPANE
		staff.assignInstructor(professor, BIO101);
		staff.assignInstructor(professor, ABC123);
		staff.assignInstructor(dr_brown, IMS333);
		staff.assignInstructor(dr_brown, MBI221);

		// Assign Single Final Cumulative Semester Grades (GPA) -- JOPTIONPANE
		professor.assignFinalGrade(sophomore, 3.00);
		dr_brown.assignFinalGrade(kim, 3.12);
		dr_brown.assignFinalGrade(anthony, 2.55);
		professor.assignFinalGrade(first_year, 3.89);

		// Student Outputs -- JOPTIONPANE
		System.out.println(sophomore.toString());
		System.out.println(
				"Expected Output: [major = Criminal Justice, finalGrade = 3.00, id = 9812944, email = jberr8@school.edu, classes = [BIO 101, ABC 123]]\n");

		System.out.println(anthony.toString());
		System.out.println(
				"Expected Output: [major = Biology, finalGrade = 2.55, id = 119383, email = anthonywj@school.edu, classes = [ABC 123, MBI 221]]\n");

		System.out.println(kim.toString());
		System.out.println(
				"Expected Output: [major = Chemical Engineering, finalGrade = 3.12, id = 237824, email = kimk@school.edu, classes = [BIO 101, IMS 333]]\n");

		System.out.println(first_year.toString());
		System.out.println(
				"Expected Output: [major = Graphic Design, finalGrade = 3.89, id = 764620, email = fskoo99@school.edu, classes = [BIO 101, MBI 221]]\n");

		// Instructor Outputs -- JOPTIONPANE
		System.out.println(professor.toString());
		System.out.println(
				"Expected Output: [id = 514272, email = prof82@school.edu, salary = $85000.0, classes = [BIO 101, ABC 123]]\n");

		System.out.println(dr_brown.toString());
		System.out.println(
				"Expected Output: [id = 1344172, email = browndr@school.edu, salary = $91000.0, classes = [IMS 333, MBI 221]]\n");

		// AdminStaff Output -- JOPTIONPANE
		System.out.println(staff.toString());
		System.out.println("Expected Output: [id = 9817221, email = staff29@school.edu, salary = $88000.0]\n");

		GUI(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123, exeterHall,
				bethesdaHall, glenbrookHall, georgetownHall);
	}

	/**
	 * 
	 * Start of GUI. Calls on other 'menu' methods depending on user input through JOPTIONPANE. 
	 * menu1 through menu15 are all related to the GUI. The GUI was split up into these methods for organization and to
	 * allow for the 'back' button to simply call the preceding method (to go back).
	 * 
	 * @param professor
	 * @param dr_brown
	 * @param sophomore
	 * @param anthony
	 * @param kim
	 * @param first_year
	 * @param staff
	 * @param BIO101
	 * @param MBI221
	 * @param IMS333
	 * @param ABC123
	 * @param exeterHall
	 * @param bethesdaHall
	 * @param glenbrookHall
	 * @param georgetownHall
	 */
	public static void GUI(Instructor professor, Instructor dr_brown, Student sophomore, Student anthony, Student kim,
			Student first_year, AdminStaff staff, Class BIO101, Class MBI221, Class IMS333, Class ABC123,
			LectureHall exeterHall, LectureHall bethesdaHall, LectureHall glenbrookHall, LectureHall georgetownHall) {

		menu1(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
				exeterHall, bethesdaHall, glenbrookHall, georgetownHall);

		System.exit(0);
	}

	public static void menu1(Instructor professor, Instructor dr_brown, Student sophomore, Student anthony, Student kim,
			Student first_year, AdminStaff staff, Class BIO101, Class MBI221, Class IMS333, Class ABC123,
			LectureHall exeterHall, LectureHall bethesdaHall, LectureHall glenbrookHall, LectureHall georgetownHall) {

		String[] option = new String[] { "Cancel", "View Users", "Log In", "View Classes" };
		int response = JOptionPane.showOptionDialog(null, "Select from the following options...", "Options Menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

		switch (response) {

		case 0:
			System.exit(0); // Close
			break;

		case 1:
			menu3(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // "View
																				// Users"
			break;

		case 2:
			menu2(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // "Log
																				// In"
			break;

		case 3:
			menu15(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // "View
																				// Classes"
			break;

		}

	}

	public static void menu2(Instructor professor, Instructor dr_brown, Student sophomore, Student anthony, Student kim,
			Student first_year, AdminStaff staff, Class BIO101, Class MBI221, Class IMS333, Class ABC123,
			LectureHall exeterHall, LectureHall bethesdaHall, LectureHall glenbrookHall, LectureHall georgetownHall) {

		String[] option = new String[] { "Back", "Instructor", "Administrator", "Student" };
		int response = JOptionPane.showOptionDialog(null, "Log in as...", "Options Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

		switch (response) {

		case 0:
			menu1(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // Back
																				// Button
			break;

		case 1:
			menu4(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // Log
																				// in
																				// as
																				// "Instructor"
			break;

		case 2:
			menu5(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // Log
																				// in
																				// as
																				// "Admin"
			break;

		case 3:
			menu6(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // Log
																				// in
																				// as
																				// "Student"
			break;
		}

	}

	public static void menu3(Instructor professor, Instructor dr_brown, Student sophomore, Student anthony, Student kim,
			Student first_year, AdminStaff staff, Class BIO101, Class MBI221, Class IMS333, Class ABC123,
			LectureHall exeterHall, LectureHall bethesdaHall, LectureHall glenbrookHall, LectureHall georgetownHall) {

		String[] option = new String[] { "Back", "View Students", "View Instructors", "View Administrators" };
		int response = JOptionPane.showOptionDialog(null, null, "Options Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

		switch (response) {

		case 0:
			menu1(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // Back
																				// Button
			break;

		case 1:
			JOptionPane.showMessageDialog(null, sophomore.toString() + "\n" + anthony.toString() + "\n" + kim.toString()
					+ "\n" + first_year.toString()); // View "Students"
			break;

		case 2:
			JOptionPane.showMessageDialog(null, professor.toString() + "\n" + dr_brown.toString()); // View
																									// "Instructors"
			break;

		case 3:
			JOptionPane.showMessageDialog(null, staff.toString()); // View
																	// "Admins"
			break;
		}
		menu7(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
				exeterHall, bethesdaHall, glenbrookHall, georgetownHall);
	}

	public static void menu4(Instructor professor, Instructor dr_brown, Student sophomore, Student anthony, Student kim,
			Student first_year, AdminStaff staff, Class BIO101, Class MBI221, Class IMS333, Class ABC123,
			LectureHall exeterHall, LectureHall bethesdaHall, LectureHall glenbrookHall, LectureHall georgetownHall) {

		String[] option = new String[] { professor.getInstructorId(), dr_brown.getInstructorId() };
		int response = JOptionPane.showOptionDialog(null, "Select your instructor ID:", "Options Menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, null);

		String[] option2 = new String[] { "Back", "Change Grade", "View Class List" };
		int response2 = JOptionPane.showOptionDialog(null, null, "Options Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, option2, option2[0]);

		switch (response2) {

		case 0:
			menu2(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // Back
																				// button
			break;

		case 1: // "Change Grade" is selected
			String[] ids = { sophomore.getId(), anthony.getId(), kim.getId(), first_year.getId() };
			String selectStudent = (String) JOptionPane.showInputDialog(null,
					"Select ID# which you'd like to change the grade of:", "Change Grade", JOptionPane.QUESTION_MESSAGE,
					null, ids, ids[0]);

			if (selectStudent == null) { // Back/Cancel Button
				menu2(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
						exeterHall, bethesdaHall, glenbrookHall, georgetownHall);
			}

			else {
				// enter new GPA
				String gradeChange = JOptionPane.showInputDialog(null, "Enter new GPA:");
				Student studentToChange = null;

				if (gradeChange == null) {
					menu2(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333,
							ABC123, exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // Back/Cancel
																								// button
				}

				else {
					if (selectStudent.equals(sophomore.getId()))
						studentToChange = sophomore;
					else if (selectStudent.equals(anthony.getId()))
						studentToChange = anthony;
					else if (selectStudent.equals(kim.getId()))
						studentToChange = kim;
					else
						studentToChange = first_year;

					double newGrade = Double.parseDouble(gradeChange);

					if (response == 0)
						professor.assignFinalGrade(studentToChange, newGrade);
					else if (response == 1)
						dr_brown.assignFinalGrade(studentToChange, newGrade);

					menu7(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333,
							ABC123, exeterHall, bethesdaHall, glenbrookHall, georgetownHall);
				}
			}
			break;

		case 2: // "View Class List" is selected

			if (response == 0)
				JOptionPane.showMessageDialog(null, professor.getInstructorClasses());
			else
				JOptionPane.showMessageDialog(null, dr_brown.getInstructorClasses());

			menu7(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall);

			break;
		} // end Switch statement

	}

	public static void menu5(Instructor professor, Instructor dr_brown, Student sophomore, Student anthony, Student kim,
			Student first_year, AdminStaff staff, Class BIO101, Class MBI221, Class IMS333, Class ABC123,
			LectureHall exeterHall, LectureHall bethesdaHall, LectureHall glenbrookHall, LectureHall georgetownHall) {

		// Log-In as Admin
		String[] option = new String[] { "Back", staff.getId() + "" };
		int response = JOptionPane.showOptionDialog(null, "Select your admin ID:", "Options Menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

		switch (response) {

		case 0:
			menu2(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall);

			break;

		case 1:
			menu8(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall);

			break;

		}

	}

	public static void menu6(Instructor professor, Instructor dr_brown, Student sophomore, Student anthony, Student kim,
			Student first_year, AdminStaff staff, Class BIO101, Class MBI221, Class IMS333, Class ABC123,
			LectureHall exeterHall, LectureHall bethesdaHall, LectureHall glenbrookHall, LectureHall georgetownHall) {

		String[] option = new String[] { "Back", sophomore.getId(), anthony.getId(), kim.getId(), first_year.getId() };
		int response = JOptionPane.showOptionDialog(null, "Select student's ID to log-in as:", "Options Menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

		Student studentSelected = null;
		if (response == 1)
			studentSelected = sophomore;
		else if (response == 2)
			studentSelected = anthony;
		else if (response == 3)
			studentSelected = kim;
		else if (response == 4)
			studentSelected = first_year;
		else {
			menu2(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // Back
																				// button
		}

		String[] option2 = new String[] { "Back to Log In Menu", "View Courses Enrolled In", "View Grade",
				"View General Info" };
		int response2 = JOptionPane.showOptionDialog(null, "Select action:", "Options Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, option2, option2[0]);

		if (response2 == 1) // view courses enrolled in
			JOptionPane.showMessageDialog(null, studentSelected.getClasses());

		else if (response2 == 2) // view grade
			JOptionPane.showMessageDialog(null, studentSelected.getFinalGrade());

		else if (response2 == 3) { // view general info
			JOptionPane.showMessageDialog(null, "ID#: " + studentSelected.getId() + "\nEmail: "
					+ studentSelected.getEmail() + "\nMajor: " + studentSelected.getMajor());
		} else {
			menu2(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // Back
																				// button
		}
		menu7(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
				exeterHall, bethesdaHall, glenbrookHall, georgetownHall);

	}

	public static void menu7(Instructor professor, Instructor dr_brown, Student sophomore, Student anthony, Student kim,
			Student first_year, AdminStaff staff, Class BIO101, Class MBI221, Class IMS333, Class ABC123,
			LectureHall exeterHall, LectureHall bethesdaHall, LectureHall glenbrookHall, LectureHall georgetownHall) {

		String[] option = new String[] { "Close", "Main Menu" };
		int response = JOptionPane.showOptionDialog(null, "Click to go back to the main menu or close the app.",
				"Options Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

		if (response == 0)
			System.exit(0);

		menu1(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
				exeterHall, bethesdaHall, glenbrookHall, georgetownHall);

	}

	public static void menu8(Instructor professor, Instructor dr_brown, Student sophomore, Student anthony, Student kim,
			Student first_year, AdminStaff staff, Class BIO101, Class MBI221, Class IMS333, Class ABC123,
			LectureHall exeterHall, LectureHall bethesdaHall, LectureHall glenbrookHall, LectureHall georgetownHall) {

		String[] option = new String[] { "Back", "Enroll Student", "Assign Hall", "Assign Instructor" };
		int response = JOptionPane.showOptionDialog(null, "Select from the following...", "Options Menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

		switch (response) {

		case 0:
			menu5(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // Back
																				// button
			break;

		case 1:
			menu9(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // Enroll
																				// student
			break;

		case 2:
			menu10(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // Assign
																				// hall
																				// to
																				// class
			break;

		case 3:
			menu11(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // Assign
																				// instructor
																				// to
																				// class
			break;
		}

		menu7(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
				exeterHall, bethesdaHall, glenbrookHall, georgetownHall);

	}

	public static void menu9(Instructor professor, Instructor dr_brown, Student sophomore, Student anthony, Student kim,
			Student first_year, AdminStaff staff, Class BIO101, Class MBI221, Class IMS333, Class ABC123,
			LectureHall exeterHall, LectureHall bethesdaHall, LectureHall glenbrookHall, LectureHall georgetownHall) {

		// Enroll student
		String[] option = new String[] { "Back", sophomore.getId(), anthony.getId(), kim.getId(), first_year.getId() };
		int response = JOptionPane.showOptionDialog(null, "Select student ID to enroll in a class:", "Options Menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

		switch (response) {

		case 0:
			menu8(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // Back
																				// button
			break;

		default:
			Student studentToEnroll = null;

			if (response == 1)
				studentToEnroll = sophomore;
			else if (response == 2)
				studentToEnroll = anthony;
			else if (response == 3)
				studentToEnroll = kim;
			else if (response == 4)
				studentToEnroll = first_year;

			menu12(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall, studentToEnroll); // All
																								// other
																								// options
			break;
		}

	}

	public static void menu10(Instructor professor, Instructor dr_brown, Student sophomore, Student anthony,
			Student kim, Student first_year, AdminStaff staff, Class BIO101, Class MBI221, Class IMS333, Class ABC123,
			LectureHall exeterHall, LectureHall bethesdaHall, LectureHall glenbrookHall, LectureHall georgetownHall) {

		// Assign hall to class

		String[] option = new String[] { "Back", BIO101.getCourse(), MBI221.getCourse(), IMS333.getCourse(),
				ABC123.getCourse() };
		int response = JOptionPane.showOptionDialog(null, "Select class to assign a hall to:", "Options Menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

		Class classToAssign = null;

		switch (response) {

		case 0:
			menu8(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall);
			break;

		case 1:
			classToAssign = BIO101;
			break;

		case 2:
			classToAssign = MBI221;
			break;

		case 3:
			classToAssign = IMS333;
			break;

		case 4:
			classToAssign = ABC123;
			break;
		}

		menu13(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
				exeterHall, bethesdaHall, glenbrookHall, georgetownHall, classToAssign);

	}

	public static void menu11(Instructor professor, Instructor dr_brown, Student sophomore, Student anthony,
			Student kim, Student first_year, AdminStaff staff, Class BIO101, Class MBI221, Class IMS333, Class ABC123,
			LectureHall exeterHall, LectureHall bethesdaHall, LectureHall glenbrookHall, LectureHall georgetownHall) {

		// assign instructor to class

		String[] option = new String[] { "Back", BIO101.getCourse(), MBI221.getCourse(), IMS333.getCourse(),
				ABC123.getCourse() };
		int response = JOptionPane.showOptionDialog(null, "Select class to assign an instructor to:", "Options Menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

		Class courseToAssign = null;
		switch (response) {

		case 0:
			menu8(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall);
			break;

		case 1:
			courseToAssign = BIO101;
			break;

		case 2:
			courseToAssign = MBI221;
			break;

		case 3:
			courseToAssign = IMS333;
			break;

		case 4:
			courseToAssign = ABC123;
			break;

		}

		menu14(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
				exeterHall, bethesdaHall, glenbrookHall, georgetownHall, courseToAssign);

	}

	public static void menu12(Instructor professor, Instructor dr_brown, Student sophomore, Student anthony,
			Student kim, Student first_year, AdminStaff staff, Class BIO101, Class MBI221, Class IMS333, Class ABC123,
			LectureHall exeterHall, LectureHall bethesdaHall, LectureHall glenbrookHall, LectureHall georgetownHall,
			Student studentToEnroll) {

		String[] option = new String[] { "Back", BIO101.getCourse(), MBI221.getCourse(), IMS333.getCourse(),
				ABC123.getCourse() };
		int response = JOptionPane.showOptionDialog(null, "Select class to enroll student in:", "Options Menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

		Class classEnrolled = null;
		if (response == 1)
			classEnrolled = BIO101;
		else if (response == 2)
			classEnrolled = MBI221;
		else if (response == 3)
			classEnrolled = IMS333;
		else
			classEnrolled = ABC123;

		staff.enroll(studentToEnroll, classEnrolled);

		// if class lecture hall is full
		if (classEnrolled.getCurrentAmount() >= (classEnrolled.getHall()).getCapacity()) {
			JOptionPane.showMessageDialog(null, "Problem adding student to course.",
					"The course's lecture hall is at capacity.", JOptionPane.ERROR_MESSAGE);

			menu7(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall);
		}

	}

	public static void menu13(Instructor professor, Instructor dr_brown, Student sophomore, Student anthony,
			Student kim, Student first_year, AdminStaff staff, Class BIO101, Class MBI221, Class IMS333, Class ABC123,
			LectureHall exeterHall, LectureHall bethesdaHall, LectureHall glenbrookHall, LectureHall georgetownHall,
			Class classToAssign) {

		String[] option = new String[] { "Back", "Exeter Hall", "Bethesda Hall", "Glenbrook Hall", "Georgetown Hall" };
		int response = JOptionPane.showOptionDialog(null, "Select hall to assign to class:", "Options Menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

		LectureHall hallToAssign = null;

		switch (response) {

		case 0:
			menu10(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall); // Back
																				// button
			break;

		case 1:
			hallToAssign = exeterHall;
			break;

		case 2:
			hallToAssign = bethesdaHall;
			break;

		case 3:
			hallToAssign = glenbrookHall;
			break;

		case 4:
			hallToAssign = georgetownHall;
			break;

		}

		staff.assignHall(classToAssign, hallToAssign);
		menu7(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
				exeterHall, bethesdaHall, glenbrookHall, georgetownHall);

	}

	public static void menu14(Instructor professor, Instructor dr_brown, Student sophomore, Student anthony,
			Student kim, Student first_year, AdminStaff staff, Class BIO101, Class MBI221, Class IMS333, Class ABC123,
			LectureHall exeterHall, LectureHall bethesdaHall, LectureHall glenbrookHall, LectureHall georgetownHall,
			Class courseToAssign) {

		String[] option = new String[] { "Back", professor.getInstructorId(), dr_brown.getInstructorId() };
		int response = JOptionPane.showOptionDialog(null, "Select instructor's ID to assign to class:", "Options Menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

		Instructor instructorToAssign = null;

		switch (response) {

		case 0:
			menu11(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall);
			break;

		case 1:
			instructorToAssign = professor;
			break;

		case 2:
			instructorToAssign = dr_brown;
			break;
		}

		staff.assignInstructor(instructorToAssign, courseToAssign);

	}

	public static void menu15(Instructor professor, Instructor dr_brown, Student sophomore, Student anthony,
			Student kim, Student first_year, AdminStaff staff, Class BIO101, Class MBI221, Class IMS333, Class ABC123,
			LectureHall exeterHall, LectureHall bethesdaHall, LectureHall glenbrookHall, LectureHall georgetownHall) {

		String[] option = new String[] { "Back", BIO101.getCourse(), MBI221.getCourse(), IMS333.getCourse(),
				ABC123.getCourse() };
		int response = JOptionPane.showOptionDialog(null, "Select class:", "Options Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

		switch (response) {

		case 0:
			menu1(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
					exeterHall, bethesdaHall, glenbrookHall, georgetownHall);
			break;

		case 1:
			JOptionPane.showMessageDialog(null,
					BIO101.getCourse() + "\n" + BIO101.getHallName() + "\nCapacity: " + BIO101.getHall().getCapacity()); // "BIO
																															// 101"
			break;

		case 2:
			JOptionPane.showMessageDialog(null,
					MBI221.getCourse() + "\n" + MBI221.getHallName() + "\nCapacity: " + MBI221.getHall().getCapacity()); // "MBI
																															// 221"
			break;

		case 3:
			JOptionPane.showMessageDialog(null,
					IMS333.getCourse() + "\n" + IMS333.getHallName() + "\nCapacity: " + IMS333.getHall().getCapacity()); // "IMS
																															// 333"
			break;

		case 4:
			JOptionPane.showMessageDialog(null,
					ABC123.getCourse() + "\n" + ABC123.getHallName() + "\nCapacity: " + ABC123.getHall().getCapacity()); // "ABC
																															// 123"
			break;
		}
		menu7(professor, dr_brown, sophomore, anthony, kim, first_year, staff, BIO101, MBI221, IMS333, ABC123,
				exeterHall, bethesdaHall, glenbrookHall, georgetownHall);
	}
}