package com.techelevator;

import java.util.*;

public class Lecture_Map {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();









		System.out.println();
		System.out.println("####################");
		System.out.println("      MAP ORDER     ");
		System.out.println("####################");
		System.out.println();

		System.out.println("The values where inserted in the following order: 2, 10, 25, 1");


		// HashMap does not retain order
		System.out.println();
		System.out.println("  HASHMAP");
		System.out.println("Does not retain any order.  Instead it uses it's own internal ordering");

		Map<Integer, String> hashMapNumbersToWords = new HashMap<Integer, String>();

		hashMapNumbersToWords.put(2, "Two");
		hashMapNumbersToWords.put(10, "Ten");
		hashMapNumbersToWords.put(25, "Twenty-Five");
		hashMapNumbersToWords.put(1, "One");

		for (Integer number : hashMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + hashMapNumbersToWords.get(number));
		}


		System.out.println();
		System.out.println("  LINKED HASHMAP");
		System.out.println("Retains the Order of Insertion");

		Map<Integer, String> linkedHashMapNumbersToWords = new LinkedHashMap<Integer, String>();

		linkedHashMapNumbersToWords.put(2, "Two");
		linkedHashMapNumbersToWords.put(10, "Ten");
		linkedHashMapNumbersToWords.put(25, "Twenty-Five");
		linkedHashMapNumbersToWords.put(1, "One");

		for (Integer number : linkedHashMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + linkedHashMapNumbersToWords.get(number));
		}


		System.out.println();
		System.out.println("  TREEMAP");
		System.out.println("Retains the Natural Order of the Data Type");
		System.out.println();
		System.out.println("Natural Order when numbers are Integer");

		Map<Integer, String> treeMapNumbersToWords = new TreeMap<Integer, String>();

		treeMapNumbersToWords.put(2, "Two");
		treeMapNumbersToWords.put(10, "Ten");
		treeMapNumbersToWords.put(25, "Twenty-Five");
		treeMapNumbersToWords.put(1, "One");

		for (Integer number : treeMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + treeMapNumbersToWords.get(number));
		}


		System.out.println();
		System.out.println("TreeMap Natural Order when numbers are String");

		Map<String, String> treeMapNumbersAsStrings = new TreeMap<String, String>();

		treeMapNumbersAsStrings.put("2", "Two");
		treeMapNumbersAsStrings.put("10", "Ten");
		treeMapNumbersAsStrings.put("25", "Twenty-Five");
		treeMapNumbersAsStrings.put("1", "One");

		for (String number : treeMapNumbersAsStrings.keySet()) {
			System.out.println(number + " is " + treeMapNumbersAsStrings.get(number));

		}

		System.out.println();
		System.out.println("####################");
		System.out.println("     Problems     ");
		System.out.println("####################");
		System.out.println();

		/*
			Given the following Map, transfer half the funds from account 12345 to account 56789
		 */
		Map<Integer, Double> accounts = new HashMap<Integer, Double>();
		accounts.put(12345, 100d);
		accounts.put(56789, 200d);


		/*
			Given the following Array count how many times each name exists
		 */
		String[] names = {"Rachelle", "John", "Rachelle", "Steve", "Dan", "Matt", "John", "Matt", "Rachelle", "Steve", "John", "Rachelle", "Rachelle" };


		/*
			Keep track of items you want to purchase at the store
			What collection would be best?

			Items: Ceiling Cleaner, Duct Tape, Hot Glue Gun, Googly Eyes, Pink Glitter Glue
		 */



		/*
			Create an Inventory for the following items
			What collection would work best?

			Example:
			A1: Candy Bar
			A2: Nut Bar
			A3: Bag of Chocolates
			B1: Potato Chips
			B2: Pretzels
			B3: Nutter Butters
			C1: Cat Treats
			C2: Dog Treats
			C3: Squirrel Treats
		 */


		/*
			Given the following map.  Replace all the null values with the word "default"
		 */
		Map<Integer, String> myMap = new HashMap<Integer, String>();

		myMap.put(1, "abc");
		myMap.put(2, null);
		myMap.put(3, null);
		myMap.put(4, "def");
		myMap.put(5, "null");
		myMap.put(6, null);
		myMap.put(7, "ghi");
		myMap.put(8, "jkl");


	}


}
