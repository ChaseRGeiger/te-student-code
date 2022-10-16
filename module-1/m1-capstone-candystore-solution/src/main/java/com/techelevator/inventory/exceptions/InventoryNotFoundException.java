package com.techelevator.inventory.exceptions;

public class InventoryNotFoundException extends Exception {

    public InventoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
