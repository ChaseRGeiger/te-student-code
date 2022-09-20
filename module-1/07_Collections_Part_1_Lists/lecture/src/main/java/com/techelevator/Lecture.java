package com.techelevator;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("       BigDecimal");
		System.out.println("####################");

		BigDecimal firstNum = new BigDecimal(0);
		BigDecimal secondNum = BigDecimal.ZERO;

		firstNum = firstNum.add(new BigDecimal(10));

		System.out.println("####################");
		System.out.println("       LocalDate");
		System.out.println("####################");

		//todays date
		LocalDate today = LocalDate.now();

		//tmrws date
		LocalDate tomorrow = today.plusDays(1);

		//specific date

		LocalDate april122010 = LocalDate.of(2010, 4, 12);

		//specific date parse form string

		LocalDate halloween1980 = LocalDate.parse("1980-10-31");

		//System.out.println(halloween1980);

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		System.out.println(dateFormatter.format(halloween1980));

		//LocalDate nov171980 = LocalDate.parse("11/17/1980", dateFormatter);
		//System.out.println(nov171980);

		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> instructors = new ArrayList<String>();
		instructors.add("John");
		instructors.add("Steve");
		instructors.add("Matt");
		instructors.add("Scott");

		for(int i = 0; i < instructors.size(); i++){

			System.out.println(instructors.get(i));

		}


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");


		instructors.add(2, "Laura");
		System.out.println(instructors);


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		instructors.remove(3);


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		System.out.println(instructors.contains("Laura"));


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		int indexOfSteve = instructors.indexOf("Steve");


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] instructorArray = instructors.toArray(new String[instructors.size()]);

		String[] lettersArray = {"a", "b", "c", "d"};
		List<String> lettersAsList = Arrays.asList(lettersArray);



		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(instructors);


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(instructors);

		Collections.shuffle(instructors);


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for(String instructorName : instructors){

			System.out.println(instructorName);

		}



		System.out.println("####################");
		System.out.println("       AUTOBOXING");
		System.out.println("####################");

		List<Integer> nums = new ArrayList<Integer>();

		Integer numberOfEmployees = 25;
		Integer piecesOfCake = new Integer("24");

		if(numberOfEmployees > piecesOfCake){
			System.out.println("Not Enough Cake");
		}

		int x = numberOfEmployees;
		int y = piecesOfCake;

		if (piecesOfCake <= 20) {

		}

		Integer moreCakes = piecesOfCake + 25;
		int moreEmployees = numberOfEmployees + 5;

	}
}
