package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Please enter a number: ");
		String lastNum = input.nextLine();
		int lastNumAsInt = Integer.parseInt(lastNum);
		int firstNum = 0;
		int secondNum = 1;
		int count = 0;

		while(firstNum <= lastNumAsInt){

			System.out.print(firstNum + " ");
			count = firstNum + secondNum;
			firstNum = secondNum;
			secondNum = count;

		}




		/*
		they give number that it is going to count to
		make initial variable that starts at 0
		make a for loop
		i starts at 1
		conditional makes i less than value they give
		iteration count???????????? (i+=i)?
		inside for loop first line is sout (firstNum + " ")
		firstNum = i
		i+=firstNum
		can i do while????

		 */



	}



}
