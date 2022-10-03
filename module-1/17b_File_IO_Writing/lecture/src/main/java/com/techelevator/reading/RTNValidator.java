package com.techelevator.reading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {

	/*
	A routing transit number is a nine-digit number used to identify
	a bank or financial institution when clearing funds for electronic
	transfers or processing checks in the United States.
	 */

	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args) throws FileNotFoundException {
		//calls the method printApplicationBanner()
		printApplicationBanner();

		//instantiates a new File object based on the File object returned by
		//the getInputFileFromUser() method
		File inputFile = getInputFileFromUser();

		//So we have a file but now we need to read it.
		//instead of passing in System.in into the new Scanner(),
		//we pass in the file
		try(Scanner fileScanner = new Scanner(inputFile)) {
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String rtn = line.substring(0, 9);
				
				if(checksumIsValid(rtn) == false) {
					System.out.println(line);
				}
			}
		}
	}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	@SuppressWarnings("resource")
	//Note how this returns a File object
	private static File getInputFileFromUser() {

		//instantiates a new Scanner object that will read in input from the user
		Scanner userInput = new Scanner(System.in);

		//Asks user for the path to the file
		System.out.print("Please enter path to input file >>> ");

		/*
		if we can use the relative path: rtn.txt
		if we need to use the absolute path: 
		C:\\Users\\Student\\source\\repos\\java-blue-main\\module-1\\16_FileIO_Reading_in\\lecture-student\\rtn.txt
		*/

		//now we have the path as a string
		String path = userInput.nextLine();

		//instantiate a new File object with the path provided
		File inputFile = new File(path);

		// checks for the existence of a file
		if(inputFile.exists() == false) {
			//print out to the user the file wasn't found and exit the program
			System.out.println(path+" does not exist");
			System.exit(1); // Ends the program
		}
		//Check to see if the item at that location is a file
			else if(inputFile.isFile() == false) {
			//print out to the user the object is not a file and exit the program
			System.out.println(path+" is not a file");
			System.exit(1); // Ends the program
		}

		//if we made it passed the if and else if, we have found a file!!
		//This is the File object we use above in the main() on line 17
		return inputFile;
	}

	private static boolean checksumIsValid(String routingNumber) {
		/*This silly little method loops over the routing number and
		multiplies each digit in the routing number by the corresponding value
		from CHECKSUM_WEIGHTS and builds a total check sum. If that
		check sum is found to be a multiple of 10, we can assume it is valid
		*/

		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
