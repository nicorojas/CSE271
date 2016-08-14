// Nico Rojas
// CSE 271, Lab 8
// 3.29.16

import edu.miamioh.rojasnm.AdminStaff;
import edu.miamioh.rojasnm.Instructor;
import edu.miamioh.rojasnm.Class;
import edu.miamioh.rojasnm.LectureHall;
import edu.miamioh.rojasnm.Student;

/**
 * Tests Lab8 and all included classes.
 * @author rojasnm
 *
 */
public class Tester {

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
		LectureHall bethesdaHall = new LectureHall();
			bethesdaHall.setCapacity(20); // set cap
		LectureHall glenbrookHall = new LectureHall();
			glenbrookHall.setCapacity(5); // set cap
		LectureHall georgetownHall = new LectureHall();
			georgetownHall.setCapacity(100); // set cap
		
		// Create Classes/Courses	
		Class BIO101 = new Class("BIO 101");
		Class ABC123 = new Class("ABC 123");
		Class IMS333 = new Class("IMS 333");
		Class MBI221 = new Class("MBI 221");
			
		// Assign Halls to Courses
		staff.assignHall(BIO101, exeterHall);
		staff.assignHall(ABC123, glenbrookHall);
		staff.assignHall(IMS333, georgetownHall);
		staff.assignHall(MBI221, bethesdaHall);
		
		// Enroll Students
		staff.enroll(sophomore, BIO101);
		staff.enroll(kim, BIO101);
		staff.enroll(first_year, BIO101);
		staff.enroll(sophomore, ABC123);
		staff.enroll(anthony, ABC123);
		staff.enroll(kim, IMS333);
		staff.enroll(first_year, MBI221);
		staff.enroll(anthony, MBI221);
		
		// Assign Professor to Course
		staff.assignInstructor(professor, BIO101);
		staff.assignInstructor(professor, ABC123);
		staff.assignInstructor(dr_brown, IMS333);
		staff.assignInstructor(dr_brown, MBI221);
		
		// Assign Single Final Cumulative Semester Grades (GPA)
		professor.assignFinalGrade(sophomore, 3.00);
		dr_brown.assignFinalGrade(kim, 3.12);
		dr_brown.assignFinalGrade(anthony, 2.55);
		professor.assignFinalGrade(first_year, 3.89);
		
		// Student Outputs
		System.out.println(sophomore.toString());
		System.out.println("Correct Output: [major = Criminal Justice, finalGrade = 3.00, id = 9812944, email = jberr8@school.edu, classes = [BIO 101, ABC 123]]\n");
		
		System.out.println(anthony.toString());
		System.out.println("Correct Output: [major = Biology, finalGrade = 2.55, id = 119383, email = anthonywj@school.edu, classes = [ABC 123, MBI 221]]\n");
		
		System.out.println(kim.toString());
		System.out.println("Correct Output: [major = Chemical Engineering, finalGrade = 3.12, id = 237824, email = kimk@school.edu, classes = [BIO 101, IMS 333]]\n");
		
		System.out.println(first_year.toString());
		System.out.println("Correct Output: [major = Graphic Design, finalGrade = 3.89, id = 764620, email = fskoo99@school.edu, classes = [BIO 101, MBI 221]]\n");
		
		// Instructor Outputs
		System.out.println(professor.toString());
		System.out.println("Correct Output: [id = 514272, email = prof82@school.edu, salary = $85000.0, classes = [BIO 101, ABC 123]]\n");
		
		System.out.println(dr_brown.toString());
		System.out.println("Correct Output: [id = 1344172, email = browndr@school.edu, salary = $91000.0, classes = [IMS 333, MBI 221]]\n");
		
		// AdminStaff Output
		System.out.println(staff.toString());
		System.out.println("Correct Output: [id = 9817221, email = staff29@school.edu, salary = $88000.0]\n");
	}
}

//JOptionPane -- GUI

		/*
		 * 
		 * // Menu 1 String[] option = new String[] { "Cancel", "View Users",
		 * "Log In" }; int response = JOptionPane.showOptionDialog(null,
		 * "Select from the following options...", "Options Menu",
		 * JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option,
		 * option[0]);
		 * 
		 * // Menu 2 if (response == 2) { // if "Log In" is selected String[]
		 * options = new String[] { "Cancel", "Instructor", "Administrator",
		 * "Student" }; int response1 = JOptionPane.showOptionDialog(null,
		 * "Log in as...", "Options Menu", JOptionPane.DEFAULT_OPTION,
		 * JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		 * 
		 * // Menu 3 if (response1 == 1) { // log in as instructor
		 * 
		 * String[] options2 = new String[] { "Cancel",
		 * professor.getInstructorId(), dr_brown.getInstructorId() }; int
		 * instructorID = JOptionPane.showOptionDialog(null,
		 * "Select your instructor ID:", "Options Menu",
		 * JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
		 * options2, options2[0]);
		 * 
		 * String[] options1 = new String[] { "Cancel", "Change Grade",
		 * "View Class List" }; int response3 =
		 * JOptionPane.showOptionDialog(null, null, "Options Menu",
		 * JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
		 * options1, options1[0]);
		 * 
		 * if (response3 == 1) { // change grade // choose student String[] ids
		 * = { sophomore.getId(), anthony.getId(), kim.getId(),
		 * first_year.getId() };
		 * 
		 * // JFrame frame = new JFrame("Input Dialog Example 3"); String
		 * selectStudent = (String) JOptionPane.showInputDialog(null,
		 * "Select ID# which you'd like to change the grade of:", "Change Grade"
		 * , JOptionPane.QUESTION_MESSAGE, null, ids, ids[0]);
		 * 
		 * // enter new GPA String gradeChange =
		 * JOptionPane.showInputDialog(null, "Enter new GPA:"); double newGrade
		 * = Double.parseDouble(gradeChange); Student studentToChange = null; if
		 * (selectStudent.equals(sophomore.getId())) { studentToChange =
		 * sophomore; } else if (selectStudent.equals(anthony.getId())) {
		 * studentToChange = anthony; } else if
		 * (selectStudent.equals(kim.getId())) { studentToChange = kim; } else {
		 * studentToChange = first_year; } if (instructorID == 1) {
		 * professor.assignFinalGrade(studentToChange, newGrade); } else if
		 * (instructorID == 2) dr_brown.assignFinalGrade(studentToChange,
		 * newGrade); } // end change grade
		 * 
		 * else if (response3 == 2) { System.out.println(instructorID); if
		 * (instructorID == 1) JOptionPane.showMessageDialog(null,
		 * professor.getInstructorClasses()); else
		 * JOptionPane.showMessageDialog(null, dr_brown.getInstructorClasses());
		 * }
		 * 
		 * } // end 'if' log in as Instructor
		 * 
		 * else if (response1 == 2) { // log in as admin
		 * 
		 * String[] options2 = new String[] { "Cancel", staff.getId() + "" };
		 * int instructorID = JOptionPane.showOptionDialog(null,
		 * "Select your admin ID:", "Options Menu", JOptionPane.DEFAULT_OPTION,
		 * JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
		 * 
		 * // enroll student, assign hall to class, assign teacher to class
		 * String[] options1 = new String[] { "Cancel", "Enroll Student",
		 * "Assign Hall", "Assign Instructor" }; int response11 =
		 * JOptionPane.showOptionDialog(null, "Select from the following...",
		 * "Options Menu", JOptionPane.DEFAULT_OPTION,
		 * JOptionPane.PLAIN_MESSAGE, null, options1, options1[0]);
		 * 
		 * if (response11 == 1) { // enroll student String[] options5 = new
		 * String[] { "Cancel", sophomore.getId(), anthony.getId(), kim.getId(),
		 * first_year.getId() }; int response5 =
		 * JOptionPane.showOptionDialog(null,
		 * "Select student ID to enroll in a class:", "Options Menu",
		 * JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
		 * options5, options5[0]);
		 * 
		 * String[] options6 = new String[] { "Cancel", BIO101.getCourse(),
		 * MBI221.getCourse(), IMS333.getCourse(), ABC123.getCourse() }; int
		 * response6 = JOptionPane.showOptionDialog(null,
		 * "Select class to enroll student in:", "Options Menu",
		 * JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
		 * options6, options6[0]);
		 * 
		 * Student studentToEnroll = null; if (response5 == 1) studentToEnroll =
		 * sophomore; else if (response5 == 2) studentToEnroll = anthony; else
		 * if (response5 == 3) studentToEnroll = kim; else studentToEnroll =
		 * first_year;
		 * 
		 * Class classEnrolled = null; if (response6 == 1) classEnrolled =
		 * BIO101; else if (response6 == 2) classEnrolled = MBI221; else if
		 * (response6 == 3) classEnrolled = IMS333; else classEnrolled = ABC123;
		 * 
		 * staff.enroll(studentToEnroll, classEnrolled);
		 * 
		 * // if class lecture hall is full: if
		 * (classEnrolled.getCurrentAmount() >=
		 * (classEnrolled.getHall()).getCapacity()) {
		 * JOptionPane.showMessageDialog(null,
		 * "Problem adding student to course.",
		 * "The course's lecture hall is at capacity.",
		 * JOptionPane.ERROR_MESSAGE); }
		 * 
		 * } // end 'if' enroll student
		 * 
		 * else if (response11 == 2) { // assign hall to class
		 * 
		 * String[] options6 = new String[] { "Cancel", BIO101.getCourse(),
		 * MBI221.getCourse(), IMS333.getCourse(), ABC123.getCourse() }; int
		 * response6 = JOptionPane.showOptionDialog(null,
		 * "Select class to assign a hall to:", "Options Menu",
		 * JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
		 * options6, options6[0]);
		 * 
		 * String[] options7 = new String[] { "Cancel", "Exeter Hall",
		 * "Bethesda Hall", "Glenbrook Hall", "Georgetown Hall" }; int response7
		 * = JOptionPane.showOptionDialog(null,
		 * "Select hall to assign to class:", "Options Menu",
		 * JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
		 * options7, options7[0]);
		 * 
		 * Class classToAssign = null; LectureHall hallToAssign = null;
		 * 
		 * if (response6 == 1) classToAssign = BIO101; else if (response6 == 2)
		 * classToAssign = MBI221; else if (response6 == 3) classToAssign =
		 * IMS333; else classToAssign = ABC123;
		 * 
		 * if (response7 == 1) hallToAssign = exeterHall; else if (response7 ==
		 * 2) hallToAssign = bethesdaHall; else if (response7 == 3) hallToAssign
		 * = glenbrookHall; else hallToAssign = georgetownHall;
		 * 
		 * staff.assignHall(classToAssign, hallToAssign);
		 * 
		 * } // end assign hall to class 'else if'
		 * 
		 * else if (response11 == 3) { // assign instructor to class
		 * 
		 * String[] options6 = new String[] { "Cancel", BIO101.getCourse(),
		 * MBI221.getCourse(), IMS333.getCourse(), ABC123.getCourse() }; int
		 * response6 = JOptionPane.showOptionDialog(null,
		 * "Select class to assign an instructor to:", "Options Menu",
		 * JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
		 * options6, options6[0]);
		 * 
		 * String[] options7 = new String[] { "Cancel",
		 * professor.getInstructorId(), dr_brown.getInstructorId() }; int
		 * instructorID2 = JOptionPane.showOptionDialog(null,
		 * "Select instructor's ID to assign to class:", "Options Menu",
		 * JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
		 * options7, options7[0]);
		 * 
		 * Instructor instructorToAssign = null; Class courseToAssign = null;
		 * 
		 * if (response6 == 1) courseToAssign = BIO101; else if (response6 == 2)
		 * courseToAssign = MBI221; else if (response6 == 3) courseToAssign =
		 * IMS333; else courseToAssign = ABC123;
		 * 
		 * if (instructorID2 == 1) instructorToAssign = professor; else if
		 * (instructorID2 == 2) instructorToAssign = dr_brown;
		 * 
		 * staff.assignInstructor(instructorToAssign, courseToAssign);
		 * 
		 * } // end assign instructor 'else if'
		 * 
		 * } // end 'else if' log in as admin
		 * 
		 * else if (response1 == 3) { // log in as student
		 * 
		 * String[] options5 = new String[] { "Cancel", sophomore.getId(),
		 * anthony.getId(), kim.getId(), first_year.getId() }; int response5 =
		 * JOptionPane.showOptionDialog(null,
		 * "Select student's ID to log-in as:", "Options Menu",
		 * JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
		 * options5, options5[0]);
		 * 
		 * String[] options8 = new String[] { "Cancel",
		 * "View Courses Enrolled In", "View Grade", "View General Info" }; int
		 * response8 = JOptionPane.showOptionDialog(null, "Select action:",
		 * "Options Menu", JOptionPane.DEFAULT_OPTION,
		 * JOptionPane.PLAIN_MESSAGE, null, options8, options8[0]);
		 * 
		 * Student studentSelected = null; if (response5 == 1) studentSelected =
		 * sophomore; else if (response5 == 2) studentSelected = anthony; else
		 * if (response5 == 3) studentSelected = kim; else studentSelected =
		 * first_year;
		 * 
		 * if (response8 == 1) // view courses enrolled in
		 * JOptionPane.showMessageDialog(null, studentSelected.getClasses());
		 * 
		 * else if (response8 == 2) // view grade
		 * JOptionPane.showMessageDialog(null, studentSelected.getFinalGrade());
		 * 
		 * else if (response8 == 3) { // view general info
		 * JOptionPane.showMessageDialog(null, "ID#: " + studentSelected.getId()
		 * + "\nEmail: " + studentSelected.getEmail() + "\nMajor: " +
		 * studentSelected.getMajor()); } } // end log in as student
		 * 
		 * } // end 'Log In'
		 * 
		 * else if (response == 1) { // if "view users" is selected String[]
		 * String[] options = new String[] { "Cancel", "View Students",
		 * "View Instructors", "View Administrators" }; int response2 =
		 * JOptionPane.showOptionDialog(null, null, "Options Menu",
		 * JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
		 * options[0]);
		 * 
		 * if (response2 == 1) { // view students
		 * JOptionPane.showMessageDialog(null, sophomore.toString() + "\n" +
		 * anthony.toString() + "\n" + kim.toString() + "\n" +
		 * first_year.toString()); } else if (response2 == 2) { // view
		 * instructors JOptionPane.showMessageDialog(null, professor.toString()
		 * + "\n" + dr_brown.toString()); } else if (response2 == 3) { // view
		 * administrators JOptionPane.showMessageDialog(null, staff.toString());
		 * }
		 * 
		 * } // end "view users" if statement END BLOCK COMMENT
		 */
