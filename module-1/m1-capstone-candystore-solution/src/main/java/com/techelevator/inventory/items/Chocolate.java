package com.techelevator.inventory.items;

public class Chocolate extends CandyStoreItem {

    private static final String DESCRIPTION = "Chocolate Confectionery";

    public Chocolate(String name, double price, boolean isWrapped) {
        super(name, price, isWrapped);
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

}
