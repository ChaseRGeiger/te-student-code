package com.techelevator.exceptions;

public class InsufficientStockException extends Exception {

    private int stockRemaining;

    public InsufficientStockException(int stockRemaining) {
        this("Insufficient Stock to fill request", stockRemaining);
    }

    public InsufficientStockException(String message, int stockRemaining) {
        super(message);
        this.stockRemaining = stockRemaining;
    }

    public int getStockRemaining() {
        return stockRemaining;
    }
}
