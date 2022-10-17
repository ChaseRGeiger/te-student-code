package com.techelevator.salesreport;

import com.techelevator.salesreport.model.SalesReportEntry;
import com.techelevator.salesreport.model.SalesReportLineItems;
import com.techelevator.salesreport.exception.SalesReportWriteException;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class FileSalesReport implements SalesReport {

    private static final String TEXT_TOTAL_SALES = "**TOTAL SALES**";

    private File salesReportFile;

    public FileSalesReport(String salesReportFileName) throws SalesReportWriteException {
        salesReportFile = new File(salesReportFileName);
    }

    @Override
    public void updateSalesReport(SalesReportEntry newReportEntry) throws SalesReportWriteException {
        SalesReportLineItems currentReportItems = readCurrentSalesReport();

        if (!currentReportItems.doesProductEntryExistInReport(newReportEntry.getProductId())) {
            currentReportItems.addSalesReportEntry(newReportEntry);
        } else {
            SalesReportEntry currentReportEntry = currentReportItems.getProductEntry(newReportEntry.getProductId() );
            currentReportEntry.addToAmount( newReportEntry.getAmount() );
            currentReportEntry.addToCount(newReportEntry.getCount() );
        }
        currentReportItems.addToTotalSales(newReportEntry.getAmount() );
        writeUpdatedSalesReport( currentReportItems );
    }

    private void writeUpdatedSalesReport(SalesReportLineItems newReport) throws SalesReportWriteException {
        try (PrintWriter printWriter = new PrintWriter(salesReportFile);
             BufferedWriter writer = new BufferedWriter(printWriter)) {
            for (Map.Entry<String, SalesReportEntry> mapEntry : newReport.getCurrentSalesReport().entrySet()) {
                writer.write(createReportLineFromEntry(mapEntry.getValue()));
            }
            writer.newLine();
            writer.write(createTotalSalesLine(newReport.getTotalSales()));
        } catch (IOException e) {
            throw new SalesReportWriteException("Failed to write updated sales report", e);
        }
    }

    private String createTotalSalesLine(double totalSales) {
        return String.format(TEXT_TOTAL_SALES + " $%1.2f", totalSales);
    }

    private String createReportLineFromEntry(SalesReportEntry reportEntry) {
        String lineToWrite = String.format("%-1s|%-1s|%-1s|$%-1.2f%n",
                reportEntry.getProductId(), reportEntry.getProductName(), reportEntry.getCount(), reportEntry.getAmount());
        return lineToWrite;
    }

    private SalesReportLineItems readCurrentSalesReport() throws SalesReportWriteException {
        SalesReportLineItems lineItems = new SalesReportLineItems();
        if (!salesReportFile.exists()) {
            return lineItems;
        }
        try (Scanner reader = new Scanner(salesReportFile)) {
            while (reader.hasNextLine()) {
                String lineFromFile = reader.nextLine();
                if (lineFromFile.trim().length() > 0) {
                    if (lineFromFile.startsWith(TEXT_TOTAL_SALES)) {
                        lineItems.setTotalSales(getTotalSalesFromLine(lineFromFile));
                    } else {
                        lineItems.addSalesReportEntry(buildSalesReportEntryFromLine(lineFromFile));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new SalesReportWriteException("Sales report file not found", e);
        }
        return lineItems;
    }

    private SalesReportEntry buildSalesReportEntryFromLine(String line) throws SalesReportWriteException {
        SalesReportEntry entry = new SalesReportEntry();
        String[] lineParts = line.split("\\|");

        if (lineParts.length != 4) {
            throw new SalesReportWriteException("Invalid line in sales report: " + line);
        }

        entry.setProductId( lineParts[0] );
        entry.setProductName( lineParts[1] );

        try {
            entry.setCount( Integer.parseInt(lineParts[2]) );
        } catch (NumberFormatException e) {
            throw new SalesReportWriteException("Unable to parse item count from line: " + line, e);
        }

        try {
            String amountWithoutDollarSign = lineParts[3].substring(1);
            entry.setAmount( Double.parseDouble(amountWithoutDollarSign));
        } catch (NumberFormatException e) {
            throw new SalesReportWriteException("Unable to parse item amount from line: " + line, e);
        }

        return entry;
    }

    private double getTotalSalesFromLine(String line) throws SalesReportWriteException {
        double totalSales = 0;
        String[] splitTotalLine = line.split("\\$");
        String totalSalesText = splitTotalLine[1];
        try {
            totalSales = Double.parseDouble(totalSalesText);
        } catch (NumberFormatException e) {
            throw new SalesReportWriteException("Failed to parse total sales: " + totalSalesText, e);
        }

        return totalSales;
    }

}
