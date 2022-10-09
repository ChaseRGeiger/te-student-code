package com.techelevator.exceptions.accounts;

public class InsufficientFundsException extends Exception {

    private int fee;

    public InsufficientFundsException(String message, int fee) {
        super(message);
        this.fee = fee;
    }

    public int getFee() {
        return this.fee;
    }
}
