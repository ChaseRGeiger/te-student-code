package com.techelevator.exceptions;

import java.util.Locale;

/*
    This class exists as a sandbox to look at how different things change the way the call stack
    and method propagation work.  It is not quality code and should not be used an example of
    how to.

 */


public class ExceptionStackExamples {

    public static void main(String[] args) {
       try {
            methodA();
        } catch (NullPointerException e) {
            System.out.println("String was null");
        }
    }


    private static void methodA() throws IllegalArgumentException, NullPointerException, ClassCastException {
           methodB();
    }

    /*
        The throws keyword declares that the method is a high risk
        of throwing a specific type of exception
     */
    private static void methodB() throws IllegalArgumentException {

        methodC();

        /*
            This line will throw an IllegalArgumentException
            The throw keyword raises a new exception
         */
        throw new IllegalArgumentException();

    }

    /*
    Exceptions when thrown can be caught in any method in the current
    call stack.  They do not need to be caught here, but can be caught in methods
    that call this method.
     */
    private static void methodC() {
        try {
            String str = null;
            str.toUpperCase(); // This line throws a NullPointerException
        } catch (NullPointerException e) {
            System.out.println("This is only so IllegalArgumentException can be thrown in methodB as an example");
        }
    }

}
