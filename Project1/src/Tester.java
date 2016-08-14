// Nico Rojas
// CSE 271, Project 1
// 3.10.16

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner kb = new Scanner(System.in);
		ArrayList<String> load = new ArrayList<String>();
		final Object Onetime = "onetime", Monthly = "monthly", Daily = "daily";
		
		AppointmentBook.add(Onetime, "dentist", "01-20-2016");
		AppointmentBook.add(Monthly, "class", "09-02-2011");
		AppointmentBook.add(Daily, "gym", "01-21-2013");
		AppointmentBook.add(Monthly, "car_wash", "07-01-2016");
		AppointmentBook.add(Onetime, "drive_to_airport", "01-20-2016");
		AppointmentBook.add(Onetime, "pick_up_laundry", "04-16-2016");
		AppointmentBook.save();
		
		System.out.println("Enter date (format: dd-mm-yyyy): ");
		String date = kb.next();

		loadByDate(load, date);
		System.out.println(load); // output all appointments on desired date
	}
	
	public static void loadByDate(ArrayList<String> load, String date) throws FileNotFoundException{
		
		Scanner fileIn = new Scanner(new File("appointments.txt"));
		Scanner fileCheckLine = new Scanner(new File("appointments.txt"));
		
		int lineCount = 0;
		double loadString = 0;
		double tempString = 0;
		int totalLines = 0; // total lines in file
		int countStrings = 0;
		
		while(fileCheckLine.hasNextLine()){ // count lines in file
			totalLines++;
			fileCheckLine.nextLine();
		} // end while
		
		int totalStrings = totalLines * 12; // total strings in file
		fileCheckLine.close();
		
		while (countStrings <= totalStrings) {
			
			lineCount++;
			
			if(fileIn.hasNext() && fileIn.next().equals(date+",")){ // saves String that contains desired dates
				loadString = lineCount;
				fileIn.nextLine();
				tempString = loadString;
			} // end if
			
			if(tempString != 0){
				Scanner fileIn2 = new Scanner(new File("appointments.txt"));
				
				double loadLine = (tempString/12); // 12 strings per line
				loadLine = (int)loadLine; // round down
				
				for(int i = 0; i < loadLine; i++)
					fileIn2.nextLine(); // skips to line before desired date

				load.add(fileIn2.nextLine()); // adds line to ArrayList
	
				tempString = 0;
				fileIn2.close();
			}
			countStrings++;
		} // end while
		fileIn.close();
	} // end load method
}