package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		int x = 10;
		int y = 10;
		x = 30;

		int[] nums = { 10, 20, 30, 40 };
		int[] nums2 = nums;
		nums[3] = 43;
		nums2 = new int[5];
		int[] nums3 = new int[5];

		System.out.println("************************************");
		System.out.println("******    CREATING OBJECTS    ******");
		System.out.println("************************************");

		Cake vanillaCake = new Cake("Buttercream", true);
		Cake chocolateCake = new Cake("Chocolate", true);
		Cake strawberryCake = new Cake("Strawberry", false);

		vanillaCake.setHasSprinkles(false);
		strawberryCake.setIcingType("Whipped");



		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
		String name = "John";

		// create an instance of a string using the String class
		String newString = new String("John");
		

		// Can initialize a string with a char array
		char[] word = new char[] {'A', 'w', 'e','s','o','m','e'};
		String fromCharArray = new String(word);


		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}


		
		System.out.println();
		System.out.println("*******************************");
		System.out.println("**** STRING MEMBER METHODS ****");
		System.out.println("*******************************");
		System.out.println();

		String bootcampName = "Tech Elevator";

		System.out.println("Strings can show their length " + bootcampName.length() );

		System.out.println("Can get a character at an index: " + bootcampName.charAt(5) );

		for (int i = 0; i < bootcampName.length(); i++) {
			System.out.println( bootcampName.charAt(i) );
		}

		String bootcampUppercase = bootcampName.toUpperCase();

		bootcampUppercase = bootcampUppercase.toLowerCase();

		String middlePart = bootcampName.substring(5, 8);
		String elevator = bootcampName.substring(5);
		

		int indexOfE = bootcampName.indexOf("Ele");

		boolean startswithAbc = bootcampName.startsWith("abc");
		boolean startswithTech = bootcampName.startsWith("Tech");

		boolean hasEleInIt = bootcampName.contains("Ele");

		String replacedEwithZ = bootcampName.replace("e", "z");

		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		String valueOfDouble = String.valueOf(3.14);

		String countDown = String.join(" --> ", "Five", "Four", "Three", "2", "1");

		System.out.println(countDown);

	}
}
