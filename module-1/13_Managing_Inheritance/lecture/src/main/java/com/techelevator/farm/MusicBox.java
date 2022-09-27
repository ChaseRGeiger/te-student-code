package com.techelevator.farm;

public class MusicBox implements Sellable, Singable {

    @Override
    public String getName() {
        return "Music Box";
    }

    @Override
    public int getPrice() {
        return 5;
    }

    @Override
    public String getSound() {
        return "lalalala";
    }

}
