package com.techelevator.salesreport.exception;

import java.io.IOException;

public class SalesReportWriteException extends IOException {

    public SalesReportWriteException(String message) {
        super(message);
    }
    public SalesReportWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
