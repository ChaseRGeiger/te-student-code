package com.techelevator.salesreport.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class SalesReportLineItems {

    private Map<String, SalesReportEntry> currentSalesReport = new LinkedHashMap<String, SalesReportEntry>();
    private double totalSales = 0;

    public void addSalesReportEntry(SalesReportEntry entry) {
        if (entry == null) {
            return;
        }
        currentSalesReport.put(entry.getProductId(), entry);
    }

    public void addToTotalSales(double amountToAdd) {
        if (amountToAdd > 0) {
            totalSales += amountToAdd;
        }
    }

    public boolean doesProductEntryExistInReport(String id) {
        return currentSalesReport.containsKey(id);
    }

    public SalesReportEntry getProductEntry(String id) {
        return currentSalesReport.get(id);
    }

    public Map<String, SalesReportEntry> getCurrentSalesReport() {
        return currentSalesReport;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        if (totalSales > 0) {
            this.totalSales = totalSales;
        }
    }

}
