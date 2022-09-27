package com.techelevator.farm;

public class Tractor implements Singable {

    @Override
    public String getSound() {
        return "rrrrrr";
    }

    @Override
    public String getName() {
        return "Tractor";
    }
}
