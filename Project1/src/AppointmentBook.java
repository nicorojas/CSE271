// Nico Rojas
// CSE 271, Project 1
// 3.10.16

import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class AppointmentBook {

	static final Object Onetime = "onetime", Monthly = "monthly", Daily = "daily";
	String description, date, type;

	static ArrayList<String> appointments = new ArrayList<String>();
	static ArrayList<String> loaded = new ArrayList<String>();

	/*
	// Test load method
	public static void main(String[] args) throws FileNotFoundException {
		add(Onetime, "gym", "12-14-2013");
		add(Onetime, "homedepot", "06-01-2000");
		add(Monthly, "bar", "03-10-2016");
		add(Onetime, "class", "10-16-2014");
		add(Daily, "concert", "10-30-1992");
		save();
		load(loaded, Onetime);

		System.out.println(loaded);
	}
	*/

	/**
	 * @param description
	 * @param date
	 * @param type
	 */
	public AppointmentBook(String description, String date, String type) {
		super();
		this.description = description;
		this.date = date;
		this.type = type;
	} // end constructor

	/**
	 * @param type
	 * @param description
	 * @param date
	 * date format: mm-dd-yyyy
	 */
	public static void add(Object type, String description, String date) {

		// convert String date to GregorianCalendar
		GregorianCalendar newDate = new GregorianCalendar();

		String year = date.substring(6, 10);
		String month = date.substring(0, 2);
		String day = date.substring(3, 5);

		newDate.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

		String appt = "AppointmentBook [ description = " + description + ", date = " + date + ", type = " + type + " ]";
		appointments.add(appt);
	} // end add method

	/**
	 * @throws FileNotFoundException
	 */
	public static void save() throws FileNotFoundException {

		PrintWriter newFile = new PrintWriter(new File("appointments.txt"));

		for (int i = 0; i < appointments.size(); i++) {
			newFile.print(appointments.get(i));
			newFile.print("\n");
		}
		newFile.close();
	} // end save method

	/**
	 * @param loaded
	 * @param type
	 * @throws FileNotFoundException
	 */
	public static void load(ArrayList<String> loaded, Object type) throws FileNotFoundException {

		Scanner fileIn = new Scanner(new File("appointments.txt"));
		Scanner fileCheckLine = new Scanner(new File("appointments.txt"));

		int lineCount = 0;
		double loadString = 0;
		double tempString = 0;
		int totalLines = 0; // total lines in file
		int countStrings = 0;

		while (fileCheckLine.hasNextLine()) { // count lines in file
			totalLines++;
			fileCheckLine.nextLine();
		} // end while

		int totalStrings = totalLines * 12; // total strings in file
		fileCheckLine.close();

		while (countStrings <= totalStrings) {

			lineCount++;

			// System.out.println("test inside while");

			if (fileIn.hasNext() && fileIn.next().equals(type)) { // saves
																	// String
																	// that
																	// contains
																	// desired
																	// dates
				loadString = lineCount;
				fileIn.nextLine();
				tempString = loadString;
			} // end if

			if (tempString != 0) {
				Scanner fileIn2 = new Scanner(new File("appointments.txt"));

				double loadLine = (tempString / 12); // 12 strings per line
				loadLine = (int) loadLine; // round down

				for (int i = 0; i < loadLine; i++) {
					fileIn2.nextLine(); // skips to line before desired date
				}

				loaded.add(fileIn2.nextLine()); // adds line to ArrayList

				tempString = 0;
				fileIn2.close();
			}
			countStrings++;

		} // end while
		fileIn.close();
	} // end load method
}