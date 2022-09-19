package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		double temperatureFahrenheit = 0;
		double temperatureCelsius = 0;


		System.out.print("Please enter the temperature: ");
		String initialTemp = input.nextLine();
		System.out.print("Is the temperature in (C)elsius or (F)ahrenheit? ");
		String initialTempMeasure = input.nextLine();

		double initialTempNum = Double.parseDouble(initialTemp);

		if(initialTempMeasure.equalsIgnoreCase("C")){

			temperatureFahrenheit = initialTempNum * 1.8 + 32;
			System.out.println(initialTempNum + "C is " + temperatureFahrenheit + "F.");

		}
		else if(initialTempMeasure.equalsIgnoreCase("F")){

			temperatureCelsius = (initialTempNum - 32) / 1.8;
			System.out.println(initialTempNum + "F is " + temperatureCelsius + "C.");

		}
		else{
			System.out.println("Invalid input");
		}

	}

}
