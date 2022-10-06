package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Scanner userInput = new Scanner(System.in);



		String initialFile = "1to300.txt";
		System.out.println("What is the destination file?");
		String destinationFile = userInput.nextLine();

		File initialAsFile = new File(initialFile);
		File destinationAsFile = new File(destinationFile);

		try (Scanner fileScanner = new Scanner(initialAsFile);
			 PrintWriter printWriter = new PrintWriter(destinationAsFile);
			 BufferedWriter bufferedWriter = new BufferedWriter(printWriter)) {

			while (fileScanner.hasNextLine()){
				String lineReadFromFile = fileScanner.nextLine();
				int num = Integer.parseInt(lineReadFromFile);

				if(num % 3 == 0 && num % 5 == 0){
					bufferedWriter.write("FizzBuzz");
					bufferedWriter.newLine();
				}
				else if(num % 3 == 0){
					bufferedWriter.write("Fizz");
					bufferedWriter.newLine();
				}
				else if(num % 5 == 0){
					bufferedWriter.write("Buzz");
					bufferedWriter.newLine();
				}
				else{
					bufferedWriter.write(num);
					bufferedWriter.newLine();
				}


			}

		}
	}

}
