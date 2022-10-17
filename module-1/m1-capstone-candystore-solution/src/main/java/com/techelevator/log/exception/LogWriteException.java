package com.techelevator.log.exception;

public class LogWriteException extends Exception {

    public LogWriteException(Throwable t) {
        super("Error writing to log", t);
    }

}
