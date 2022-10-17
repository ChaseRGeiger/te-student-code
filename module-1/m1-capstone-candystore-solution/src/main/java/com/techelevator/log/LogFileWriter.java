package com.techelevator.log;

import com.techelevator.cart.CartItem;
import com.techelevator.inventory.items.CandyStoreItem;
import com.techelevator.log.exception.LogWriteException;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
    This class should contain any and all details of access to the log file
 */
public class LogFileWriter implements LogWriter {

    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");

    private String logFileName;

    public LogFileWriter(String logFileName) {
        this.logFileName = logFileName;
    }

    @Override
    public void logMoneyReceived(double amount, double newBalance) throws LogWriteException {
        writeToLog(createLogLine(String.format("MONEY RECEIVED: $%1.2f", amount), newBalance));
    }

    @Override
    public void logChangeGiven(double amount, double newBalance) throws LogWriteException {
        writeToLog(createLogLine(String.format("CHANGE GIVEN: $%1.2f", amount), newBalance));
    }

    @Override
    public void logItemSold(String itemId, CartItem cartItem, double newBalance) throws LogWriteException {
        writeToLog(createLogLine(String.format("%-1s %-1s %-1s $%1.2f",
                cartItem.getCount(), cartItem.getItem().getName(), itemId, cartItem.getTotalCost()), newBalance));
    }

    private String createLogLine(String action, double newBalance) {
        String lineToLog = LocalDateTime.now().format(DATE_TIME_FORMATTER);
        lineToLog += " " + action;
        lineToLog += " " + String.format("$%1.2f", newBalance);
        lineToLog += String.format("%n");
        return lineToLog;

    }

    private void writeToLog(String lineToLog) throws LogWriteException {
        try (FileWriter fileWriter = new FileWriter(logFileName, true)) {
            fileWriter.write(lineToLog);
        } catch (IOException e) {
            throw new LogWriteException((e));
        }
    }

}
