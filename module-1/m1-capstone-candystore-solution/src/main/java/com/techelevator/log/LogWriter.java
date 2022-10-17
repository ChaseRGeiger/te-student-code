package com.techelevator.log;

import com.techelevator.cart.CartItem;
import com.techelevator.inventory.items.CandyStoreItem;
import com.techelevator.log.exception.LogWriteException;

import java.io.IOException;


public interface LogWriter {

    void logMoneyReceived(double amount, double newBalance) throws LogWriteException;
    void logChangeGiven(double amount, double newBalance) throws LogWriteException;
    void logItemSold(String itemId, CartItem cartItem, double newBalance) throws LogWriteException;
}
