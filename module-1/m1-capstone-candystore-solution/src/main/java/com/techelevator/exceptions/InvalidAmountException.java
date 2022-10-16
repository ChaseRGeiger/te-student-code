package com.techelevator.exceptions;

public class InvalidAmountException extends Exception {

    private int amount;

    public InvalidAmountException(String message, int amount) {
        super(message);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

}
