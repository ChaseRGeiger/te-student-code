package com.techelevator;

import java.util.Scanner;


/*
    1. Get the User input and output filenames
    2. Read the input file
    3. For each word in the input file lines
        - If the word length is 3 change it to FIZZ
        - If the word length is 5 change it to BUZZ
        - If the word length is 7 change it to RAZZ
        - otherwise don't change the word
    4. Write the new lines to the output file
    5. Tell the User the Process is finished
 */
public class FizzBuzzRazz {

    private final static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Input file: ");
        String inputFileName = userInput.nextLine();

        System.out.print("Output file: ");
        String outputFileName = userInput.nextLine();




    }



}
