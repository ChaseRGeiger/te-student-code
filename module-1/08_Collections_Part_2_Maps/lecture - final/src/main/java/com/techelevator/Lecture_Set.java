package com.techelevator;

import java.util.*;

public class Lecture_Set {

    public static void main(String[] args) {

       /*
            Set are a Collections Data Structure that holds data unordered
            and removes duplicate entries.

            Items in a set cannot be accessed by index and can only be accessed
            by looping over the set, usually for a forEach.
         */
        System.out.println("####################");
        System.out.println("        SET");
        System.out.println("####################");
        System.out.println();

        /*
            Set is declared with the Set interface.
            The implementation class used determines how the Set orders data

            HashSet - most common and fastest implementation class does not order data
            LinkedHasSet - orders data by maintaining the order the items where added to the Set
            TreeSet - orders data in the natural order for the Data Type  (numeric 0-9, strings 0-9A-Z)
         */
        Set<Integer> setOfNumbers = new HashSet<Integer>();
        //Set<Integer> setOfNumbers = new LinkedHashSet<Integer>();
//        Set<Integer> setOfNumbers = new TreeSet<Integer>();

        // Elements are added to the Set with add()
        setOfNumbers.add(1);
        setOfNumbers.add(10);
        setOfNumbers.add(30);
        setOfNumbers.add(301);
        // Duplicates will be ignored and no error returned
        setOfNumbers.add(301);
        setOfNumbers.add(42);
        setOfNumbers.add(5708);


        for (Integer number : setOfNumbers) {
            System.out.println(number);
        }




        System.out.println("\n------------------------------------");
        System.out.println(" SET USE CASE - REMOVING DUPLICATES");
        System.out.println("------------------------------------");
        /*
            A common use case for Set is to remove duplicate entries from a list.
            For example, if we had an array of workers name from tasks they completed for the week, they
            can be added to a Set and then retrieve to get a list of unique entries.
         */
        String[] instructorsArray = {"Rachelle", "John", "Matt", "John", "Dan", "Rachelle", "Rachelle", "John", "Steve", "Rachelle"};

        // Using TreeSet here will return our final list in alphabetic order
        Set<String> instructorSet = new TreeSet<String>();

        /*
            Add each name in the array the Set
         */
        for (String instructor : instructorsArray) {
            instructorSet.add(instructor);
        }

        /*
            The Array can be looped over to add it to the Set.

            An alternate way would be to convert the Array to a List and then
            use the Set's addAll method to add the entire array at once:

                instructorSet.addAll(Arrays.asList(instructorsArray));
         */

        /*
            Show the results, with the duplicates removed and ordered in a-z order by the TreeSet
         */
        for (String instructor: instructorSet) {
            System.out.println(instructor);
        }

    }


}
