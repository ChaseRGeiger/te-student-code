package com.techelevator;

public class LoopsAndArrays {

    public static void main(String[] args) {
        int[] numbers = new int[5];

        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;


        int[] numbers2 = new int[]{10, 20, 30, 40, 50};
        int[] numbers3 = {10, 20, 30, 40, 50};

        int sum = numbers[2] + numbers[4];
        numbers[0] = sum;

        String[] instructors = new String[5];

        instructors[0] = "John";
        instructors[1] = "Matt";
        instructors[2] = "Steve";
        instructors[3] = "Laura";
        instructors[4] = "Scott";

        //System.out.println(instructors.length);

        /*
        for(int i = 0; i<numbers.length; i++)
        {
            System.out.println(numbers[i]);
        }
        */

        int[] arrayOfNumbers = new int[500];

        for(int i = 0; i<arrayOfNumbers.length; i++){
            arrayOfNumbers[i] = i + 1;

        }
        for(int i = 0; i < arrayOfNumbers.length; i++){

            if (arrayOfNumbers[i] % 7 == 0) {
                arrayOfNumbers[i] *= 2;
                System.out.println(arrayOfNumbers + " ");
                i++;

            }
            else{
                System.out.println(arrayOfNumbers + " ");
            }

        }

    }
}
