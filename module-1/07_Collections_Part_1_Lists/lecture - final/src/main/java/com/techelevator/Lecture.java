package com.techelevator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {


		System.out.println("####################");
		System.out.println("       BigDecimal");
		System.out.println("####################");

		BigDecimal firstNumber = new BigDecimal(0);
		BigDecimal secondNumber = BigDecimal.ZERO;

//		BigDecimal numberToAdd = new BigDecimal(10);
//		firstNumber = firstNumber.add( numberToAdd );

		firstNumber = firstNumber.add( new BigDecimal(10) );
		BigDecimal numbersMultiplied = secondNumber.multiply( new BigDecimal(5) );

		/*
			compareTo returns
			-1 if less than the compared bigdecimal
			0 if equal to the compared bigdecimal
			1 if greater than the compared bigdecimal
		 */
		System.out.println( firstNumber.compareTo(secondNumber) );
		System.out.println( secondNumber.compareTo(firstNumber) );

		System.out.println("####################");
		System.out.println("       LocalDate");
		System.out.println("####################");

		// Today's Date
		LocalDate today = LocalDate.now();

		// Tomorrow's date
		LocalDate tomorrow = today.plusDays(1);

		// Specific Date
		LocalDate april122010 = LocalDate.of(2010, 4, 13);

		// Specific Date parsed from String
		LocalDate halloween1980 = LocalDate.parse("1980-10-31");

		System.out.println( halloween1980 );

		// DateTimeFormatter can be used to set the format of the date for printing or input
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		System.out.println( dateFormatter.format( halloween1980) );

		LocalDate nov171980 = LocalDate.parse("11/17/1980", dateFormatter);

		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> instructors = new ArrayList<String>();
		instructors.add("John");
		instructors.add("Steve");
		instructors.add("Matt");
		instructors.add("Scott");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for (int i = 0; i < instructors.size(); i++) {
			System.out.println( instructors.get(i) );
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		instructors.add("John");

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		instructors.add(2,"Laura");

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		instructors.remove(3);


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		System.out.println( instructors.contains("Laura") );

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		int indexOfSteve = instructors.indexOf("Steve");
		int indexOfSecondJohn = instructors.lastIndexOf("John");

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] instructorArray = instructors.toArray( new String[instructors.size()] );

		System.out.println("####################");
		System.out.println("Array can be turned into a List");
		System.out.println("####################");

		String[] lettersArray = {"a","b","c","d"};
		List<String> lettersAsList = Arrays.asList(lettersArray);


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort( instructors );

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse( instructors );

		System.out.println("####################");
		System.out.println("Lists can be shuffle too");
		System.out.println("####################");

		Collections.shuffle( instructors );


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for (String instructorName : instructors) {
			System.out.println(instructorName);
		}

		int[] numbers = { 10, 20, 30, 40, 50};

		for (int n : numbers) {
			System.out.println( n );
		}


		System.out.println("####################");
		System.out.println("       AUTOBOXING");
		System.out.println("####################");



		Integer numberOfEmployees = 25;
		Integer piecesOfCake = new Integer("24");

		if (numberOfEmployees > piecesOfCake) {
			System.out.println("Not enough cake");
		}

		int x = numberOfEmployees;
		int y = piecesOfCake;

		if (piecesOfCake <= 10) {
			System.out.println("Need more cake");
		}

		Integer moreCake = piecesOfCake + 25;
		int moreEmployees = numberOfEmployees + 5;

		List<Integer> numberList = new ArrayList<Integer>();


		numberList.add( 5 );

		int primitiveInt = 11;

		numberList.add( primitiveInt );

		numberList.add(7);
		numberList.remove(2);
		numberList.add(1, 14);


	}
}
