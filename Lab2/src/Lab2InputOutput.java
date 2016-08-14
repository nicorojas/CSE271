// Nico Rojas
// CSE 271, 02/05/16
// Lab 2, Read input and write output with numbered lines.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

public class Lab2InputOutput {

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		String inName, outName;
		boolean loop = false;

		// ------------------------ Prompt user for input file name --------------------- //
		do {
			System.out.println("Enter input file name (including file extension): ");
			inName = in.next();
			try {
				// Input file name
				File fileIn = new File(inName);
				Scanner read = new Scanner(fileIn);
				loop = false;
			} catch (FileNotFoundException e1) {
				System.out.print("File not found. ");
				loop = true;
				// e1.printStackTrace();
			}
		} while (loop);
		
		// ------------------------ Prompt user for output file name --------------------- //
		System.out.println("Enter output file name (including file extension):");
		outName = in.next();

		// Write to user desired file
		PrintWriter newFile = new PrintWriter(new File(outName));
		File fileIn = new File(inName);
		Scanner read = new Scanner(fileIn);

		// ----------------- Count lines in input file / Copy to newFile ----------------- //
		BufferedReader reader = new BufferedReader(new FileReader(fileIn));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();
		
		int lineNum = 1;
		
		while(lines > 0){
			newFile.print("/* " + lineNum + " */ ");
			newFile.println(read.nextLine());
			lines--;
			lineNum++;
		}

		// ------------------------------------- Close ----------------------------------- //
		if (in != null)
			in.close();
		if (newFile != null)
			newFile.close();
		if(read != null)
			read.close();

	} // end main
} // end class