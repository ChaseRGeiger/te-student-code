package com.techelevator.exceptions;

public class ThrowingExceptionExample {

    public static void main(String[] args) {
        handlesTheCheckedException();

        try {
            passesOnTheCheckedException();
        } catch (IncorrectStringValueException e) {
            System.out.println("Checked exception was caught");
        }

    }

    /*
    When a method calls a method with a checked exception.  That method
    can handle it with a try-catch
     */
    public static void handlesTheCheckedException() {
        try {
            throwsCustomException("abc");
        } catch (IncorrectStringValueException e) {
            System.out.println(e.getMessage());
        }

    }


    /*
    When a method calls a method with a checked exception.  If it does not want to handle
    the exception it can add throws to throw it to the next method in the call stack.
     */
    public static void passesOnTheCheckedException() throws IncorrectStringValueException {
        throwsCustomException("abc");
    }



    /*
    The Throws keyword indicates that this method may throw a checked exception
     */
    private static void throwsCustomException(String str) throws IncorrectStringValueException {
        if (str.equals("abc")) {
            // Throw the IncorrectStringValueException
            // throw ExceptionOejct  throws an exception
            throw new IncorrectStringValueException("Value may not be abc", str);
        }
        System.out.println("This line only runs if there is no exception thrown");
    }





}
