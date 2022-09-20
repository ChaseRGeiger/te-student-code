package com.techelevator;

import java.util.Enumeration;
import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		/*  This problem had me stuck for a few hours, but I finally got it
		    I did an if else statement in case the user put in a single value
		    instead of multiple values separated by spaces
		    I'm pretty sure this is correct if not pleas let me know where
		    I went wrong, thanks!
		 */
		int[] binary = new int[100];
		int position = 0;
		int variableAmt = 0;


		Scanner input = new Scanner(System.in);

		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		String decimalAsString = input.nextLine();

		String[] sections = decimalAsString.split("\\ ");
		if(decimalAsString.contains(" ")){

			 variableAmt = sections.length;
			 int[] decimalArray = new int[variableAmt];

			 for(int i = 0; i < variableAmt; i++){

				 decimalArray[i] = Integer.parseInt(sections[i].toString());

				 System.out.print(decimalArray[i] + " in binary is ");
				 while (decimalArray[i] > 0) {

					 binary[position++] = decimalArray[i] % 2;
					 decimalArray[i] = decimalArray[i] / 2;


				 }


				 for (int j = position - 1; j >= 0; j--) {

					 System.out.print(binary[j] + "");

				 }
				 position = 0;
				 System.out.println();

			 }

		}

		else {

			int decimal = Integer.parseInt(decimalAsString);

			while (decimal > 0) {

				binary[position++] = decimal % 2;
				decimal = decimal / 2;


			}

			System.out.print(decimalAsString + " in binary is ");

			for (int i = position - 1; i >= 0; i--) {

				System.out.print(binary[i]);

			}
		}

	}

}
