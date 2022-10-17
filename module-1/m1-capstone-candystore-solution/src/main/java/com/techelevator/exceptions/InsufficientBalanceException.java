package com.techelevator.exceptions;

public class InsufficientBalanceException extends Exception {

    private double totalCostOfItems;

    public InsufficientBalanceException(double totalCostOfItems) {
        this("Insufficient Balance to fulfill request", totalCostOfItems);
    }

    public InsufficientBalanceException(String message, double totalCostOfItems) {
        super(message);
        this.totalCostOfItems = totalCostOfItems;
    }

    public double getTotalCostOfItems() {
        return totalCostOfItems;
    }
}
