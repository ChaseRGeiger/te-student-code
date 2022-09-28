package com.techelevator;

import java.util.Scanner;

public class AssertingDoublesApp {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("What is the expected value?");
        String expectedValue = in.nextLine();
        double expected = Double.parseDouble(expectedValue);
        System.out.println("What is the actual value?");
        String actualValue = in.nextLine();
        double actual = Double.parseDouble(actualValue);
        System.out.println("How much difference is acceptable? Please enter a percentage as a decimal.");
        System.out.println("example: 1% would be .01. Or for 0.9% enter 0.009");
        String deltaValueAsPercentage = in.nextLine();
        double delta = Double.parseDouble(deltaValueAsPercentage);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        System.out.println("Delta:" + delta);
        boolean isAcceptableDifference = areTheseDoublesEqualEnough(expected, actual, delta);
        System.out.println("Are these doubles equal enough? " + isAcceptableDifference);
    }

    public static boolean areTheseDoublesEqualEnough(double expected, double actual, double delta){
        System.out.println("The difference between actual and expected is: " + Math.abs(expected - actual));
        if(Math.abs(expected - actual) > delta){
            return false;
        }
        return true;
    }
}
