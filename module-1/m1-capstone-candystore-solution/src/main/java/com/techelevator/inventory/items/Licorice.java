package com.techelevator.inventory.items;

public class Licorice extends CandyStoreItem {

    private static final String DESCRIPTION = "Licorce and Jellies";

    public Licorice(String name, double price, boolean isWrapped) {
        super(name, price, isWrapped);
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
