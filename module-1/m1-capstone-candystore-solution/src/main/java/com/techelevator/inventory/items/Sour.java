package com.techelevator.inventory.items;

public class Sour extends CandyStoreItem {

    private static final String DESCRIPTION = "Sour Flavored Candies";

    public Sour(String name, double price, boolean isWrapped) {
        super(name, price, isWrapped);
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
