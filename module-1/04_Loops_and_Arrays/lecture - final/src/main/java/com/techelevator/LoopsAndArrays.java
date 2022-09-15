package com.techelevator;

public class LoopsAndArrays {

    // psvm
    public static void main(String[] args) {

        int[] numbers = new int[5];

        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        // Can be declared, created, sized, and populated in
        // one step using static initialization
        int[] numbers2 = new int[] { 10, 20, 30, 40, 50 };
        int[] numbers3 = { 10, 20, 30, 40 ,50 };

        int sum = numbers[2] + numbers[4];
        numbers[0] = sum;

        String[] instructors = new String[5];

        instructors[2] = "Steve";
        instructors[4] = "Scott";
        instructors[0] = "John";
        instructors[3] = "Laura";
        instructors[1] = "Matt";

        // The next line will cause an ArrayIndexOutOfBoundsException error
        //instructors[5] = "Vinny";

        int sizeOfTheArray = instructors.length;
        System.out.println("The Array has this number of elements: " + sizeOfTheArray);

        numbers = new int[50];

        System.out.println( instructors[ instructors.length - 1] );


        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);

        /*
            for ( declare a variable ; boolean condition ; change the variable )
         */
        for (int i = 0 ; i < 10 ; i++ ) {
            System.out.println(i);
        }

        for (int i = 5; i > 0; i--) {
            System.out.println(i);
        }

        for (int n = 1; n <= 100; n += 3) {
            System.out.println(n);
        }

        for (int i = 0; i < instructors.length; i++) {
            System.out.println( instructors[i] );
        }

        /*
            Print every even number from 523 to 307
         */
        for (int i = 523; i > 307; i--) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        for (int i = 522; i > 307; i -= 2) {
            System.out.println(i);
        }


        /*
            Create an array of numbers 1 - 500
            In the array double every number that is divisible by 7
            Then print the numbers out, except don't print any number that immediately a number
            that id divisible by 7
         */
        int[] arrayOfNumbers = new int[500];

        for (int i = 0; i < arrayOfNumbers.length; i++) {
            arrayOfNumbers[i] = i + 1;
        }

        for (int i =0; i < arrayOfNumbers.length; i++) {

            if (arrayOfNumbers[i] % 7 ==0) {
                arrayOfNumbers[i] *= 2;
                System.out.print(arrayOfNumbers[i] + " ");
                i++;
            } else {
                System.out.print(arrayOfNumbers[i] + " ");
            }
        }


        /*
            break ends the loop immediately
         */
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;
            }
        }

        /*
            continue ends the iteration of the loop immediately and goes the next
         */
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue;
            }
            System.out.println(i);
        }






    }

}
