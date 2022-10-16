package com.techelevator.salesreport;

import com.techelevator.salesreport.model.SalesReportEntry;
import com.techelevator.salesreport.exception.SalesReportWriteException;

public interface SalesReport {

    void updateSalesReport(SalesReportEntry lineItem) throws SalesReportWriteException;
}
