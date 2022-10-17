package com.techelevator.inventory.items;

public class HardCandy extends CandyStoreItem {

    private static final String DESCRIPTION = "Hard Tack Confectionery";

    public HardCandy(String name, double price, boolean isWrapped) {
        super(name, price, isWrapped);
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
