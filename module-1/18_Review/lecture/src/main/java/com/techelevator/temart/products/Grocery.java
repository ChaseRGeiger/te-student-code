package com.techelevator.temart.products;

import java.time.LocalDate;

public class Grocery extends Product {

    private LocalDate expirationDate;
    private boolean isPerishable;

    public Grocery(String sku) {
        super(sku);
    }
    public Grocery (String sku, String name, double price, String description, int weightInLbs) {
        super (sku, name, price, description, weightInLbs);
    }

    @Override
    public String getProductType() {
        return "Grocery";
    }

    @Override
    public double getShippingCost() {
        if (isPerishable()) {
            return 2;
        }
        return 1;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isPerishable() {
        return isPerishable;
    }

    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
    }
}
