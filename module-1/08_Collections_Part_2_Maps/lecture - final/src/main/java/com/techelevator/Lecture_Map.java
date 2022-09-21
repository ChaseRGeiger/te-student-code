package com.techelevator;

import java.util.*;

public class Lecture_Map {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		Map<String, String> animalNoises = new HashMap<String, String>();

		/*
			Put adds key/value to the map
			.put(key, value)
		 */
		animalNoises.put("Cow", "Moo");
		animalNoises.put("Chicken", "Cluck");
		animalNoises.put("Dog", "Bark");
		animalNoises.put("Cat", "Meow");
		// The keys must be unique the values do not
		animalNoises.put("Lion", "Roar");
		animalNoises.put("Duck", "Roar");

		/*
			Get uses the key to retrieve the value
			value <-- .get( key )
		 */
		System.out.println( "The duck says " + animalNoises.get("Duck") );

		/*
			Put updates the value if the key already exists in the map
		 */
		animalNoises.put("Duck", "Quack");

		System.out.println( "Now the duck says " + animalNoises.get("Duck") );

		/*
			If get() is used with a key that does not exist in the map
			then null is returned
		 */
		String wolfNoise = animalNoises.get("wolf");

		/*
			remove() removes the key and value from the map and
			returns the value
		 */
		String lionNoise = animalNoises.remove("Lion");


		/*
			containsKey( key ) returns TRUE if the key exists in the map
		 */
		if ( animalNoises.containsKey("Cat") ) {
			System.out.println("There is a Cat in the map");
		}

		/*
			containsValue( value ) returns TRUE if the value exists in the map
		 */
		if ( animalNoises.containsValue("Bark") ) {
			System.out.println("There is an animal that barks in the map");
		}

		/*
			keySet() returns the set of all the keys in the map
		 */
		Set<String> keysFromTheMap = animalNoises.keySet();

		/*
			Looping through a Map using its entrySet
		 */

		for (Map.Entry<String, String> entryFromMap : animalNoises.entrySet() ) {
			String animalName = entryFromMap.getKey();
			String animalNoise = entryFromMap.getValue();

			System.out.println("The " + animalName + " says " + animalNoise);
		}


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

		double halfOfAccount12345 = accounts.get(12345) / 2.0;
		accounts.put(56789, accounts.get(56789) + halfOfAccount12345);
		accounts.put(12345, accounts.get(12345) - halfOfAccount12345);




		/*
			Given the following Array count how many times each name exists
			Rachelle: 5
			John: 3
			Steve: 2
			Dan: 1
			Matt: 2
		 */
		String[] names = {"Rachelle", "John", "Rachelle", "Steve", "Dan", "Matt", "John", "Matt", "Rachelle", "Steve", "John", "Rachelle", "Rachelle" };

		Map<String, Integer> counts = new HashMap<String, Integer>();
		for (String name : names) {
			Integer value = counts.get(name);
			if (value == null) {
				value = 0;
			}
			counts.put(name, value + 1);
		}

		/*
			Keep track of items you want to purchase at the store
			What collection would be best?

			Items: Ceiling Cleaner, Duct Tape, Hot Glue Gun, Googly Eyes, Pink Glitter Glue

			LIST
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

			MAP
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

		for (Integer key :  myMap.keySet()) {
			String value = myMap.get( key );
			if (value == null) {
				myMap.put(key, "default");
			}
		}

	}


}
