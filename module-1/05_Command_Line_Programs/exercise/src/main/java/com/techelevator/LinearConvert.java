package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		double feet = 0;
		double meters = 0;


		System.out.print("Please enter the length: ");
		String initialLength = input.nextLine();
		System.out.print("Is the measurement in (m)eters or (f)eet? ");
		String initialLengthMeasure = input.nextLine();

		double initialLengthNum = Double.parseDouble(initialLength);

		if(initialLengthMeasure.equalsIgnoreCase("m")){

			feet = initialLengthNum * 3.2808399;
			System.out.println(initialLengthNum + "m is " + feet + "f.");

		}
		else if(initialLengthMeasure.equalsIgnoreCase("f")){

			meters = initialLengthNum * 0.3048;
			System.out.println(initialLengthNum + "f is " + meters + "m.");

		}
		else{
			System.out.println("Invalid input");
		}


	}

}
