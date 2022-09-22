package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "Herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {

		Map<String, String> animalGroup = new HashMap<String, String>();

		animalGroup.put( "rhino", "Crash");
		animalGroup.put( "giraffe", "Tower");
		animalGroup.put( "elephant", "Herd");
		animalGroup.put( "lion", "Pride");
		animalGroup.put( "crow", "Murder");
		animalGroup.put( "pigeon", "Kit");
		animalGroup.put( "flamingo", "Pat");
		animalGroup.put( "deer", "Herd");
		animalGroup.put( "dog", "Pack");
		animalGroup.put( "crocodile", "Float");

		if(animalName == null){
			return "unknown";
		}

		animalName = animalName.toLowerCase();

		if(animalGroup.containsKey(animalName) == false){
			return "unknown";
		}

		return animalGroup.get(animalName);
	}

	/*
	 * Given a String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {

		Map<String, Double> onSale = new HashMap<String, Double>();

		onSale.put( "KITCHEN4001", 0.20);
		onSale.put( "GARAGE1070", 0.15);
		onSale.put( "LIVINGROOM", 0.10);
		onSale.put( "KITCHEN6073", 0.40);
		onSale.put( "BEDROOM3434", 0.60);
		onSale.put( "BATH0073", 0.15);

		if(itemNumber == null){
			return 0.00;
		}

		itemNumber = itemNumber.toUpperCase();

		if(onSale.containsKey(itemNumber) == false){
			return 0.00;
		}

		return onSale.get(itemNumber);
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {

		if(peterPaul.get("Peter") > 0 && peterPaul.get("Paul") < 1000){
			int peterAmt = peterPaul.get("Peter");
			int paulAmt = peterPaul.get("Paul");
			double newPeterAmt = peterAmt/2.0;
			newPeterAmt = Math.ceil(newPeterAmt);
			int newPeterAmtAsInt = (int)newPeterAmt;
			int newPaulAmt = newPeterAmtAsInt + peterPaul.get("Paul");
			if(newPeterAmtAsInt + newPaulAmt > peterAmt + paulAmt){
				newPaulAmt = newPaulAmt - 1;

				peterPaul.replace("Peter", newPeterAmtAsInt);
				peterPaul.replace("Paul", newPaulAmt);

				return peterPaul;
			}


			peterPaul.replace("Peter", newPeterAmtAsInt);
			peterPaul.replace("Paul", newPaulAmt);

			return peterPaul;
		}
		return peterPaul;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {

		int peterAmt = peterPaul.get("Peter");
		int paulAmt = peterPaul.get("Paul");

		if(peterPaul.get("Peter") >= 5000 && peterPaul.get("Paul") >= 10000){
			int contributePeterAmt = peterAmt/4;
			int contributePaulAmt = paulAmt/4;

			double newPeterAmt = peterAmt * .75;
			double newPaulAmt = paulAmt * .75;
			int newPeterAmtAsInt = (int)newPeterAmt;
			int newPaulAmtAsInt = (int)newPaulAmt;

			peterPaul.put("PeterPaulPartnership", (contributePeterAmt + contributePaulAmt));
			peterPaul.replace("Peter", newPeterAmtAsInt);
			peterPaul.replace("Paul", newPaulAmtAsInt);

			return peterPaul;
		}

		return peterPaul;
	}

	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {

		Map<String, String> beginningAnEnding = new HashMap<String, String>();

		for(int i = 0; i < words.length; i++){
			String word = words[i];
			String firstChar = word.substring(0, 1);
			String lastChar = word.substring(word.length() - 1);

			beginningAnEnding.put(firstChar, lastChar);

		}

		return beginningAnEnding;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {

		Map<String, Integer> newWordCount = new HashMap<String, Integer>();
		for(String word : words){
			Integer val = newWordCount.get(word);
			if(val == null){
				val = 0;
			}
			newWordCount.put(word, val + 1);
		}

		return newWordCount;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {

		Map<Integer, Integer> newIntegerCount = new HashMap<Integer, Integer>();
		for(int num : ints){
			Integer val = newIntegerCount.get(num);
			if(val == null){
				val = 0;
			}
			newIntegerCount.put(num, val + 1);
		}

		return newIntegerCount;
	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {

		Map<String, Boolean> newWordMultiple = new HashMap<String, Boolean>();

		for (String word : words) {
			newWordMultiple.put(word, false);
		}
		for (int i = 0; i < words.length; i++) {
			int count = 0;

			for (int z = 0; z < words.length; z++) {


				if (words[i] == words[z]) {

					count++;

					if (count == 2) {

						newWordMultiple.replace(words[i], true);
						break;

					}
				}
			}




		}
		return newWordMultiple;
	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {


		Map<String, Integer> consolidatedInventory = new HashMap<String, Integer>();
		consolidatedInventory.putAll(mainWarehouse);




		return consolidatedInventory;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		return null;
	}

}
