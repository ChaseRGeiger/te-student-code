package com.techelevator.salesreport.model;

import java.util.Objects;

public class SalesReportEntry {

    private String productId;
    private String productName;
    private int count;
    private double amount;

    public SalesReportEntry() {

    }

    public SalesReportEntry(String productId, String productName, int count, double amount) {
        this.productId = productId;
        this.productName = productName;
        this.count = count;
        this.amount = amount;
    }

    public void addToCount(int amountToAdd) {
        if (amountToAdd > 0) {
            count += amountToAdd;
        }
    }

    public void addToAmount(double amountToAdd) {
        if (amountToAdd > 0) {
            amount += amountToAdd;
        }
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesReportEntry that = (SalesReportEntry) o;
        return count == that.count && Double.compare(that.amount, amount) == 0 && Objects.equals(productId, that.productId) && Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, count, amount);
    }
}
