package com.techelevator.exceptions;

public class IncorrectStringValueException extends Exception {

    private String originalString;

    public IncorrectStringValueException(String message, String originalValue) {
        super(message);
        this.originalString = originalValue;
    }

    public String getOriginalString() {
        return this.originalString;
    }
}
