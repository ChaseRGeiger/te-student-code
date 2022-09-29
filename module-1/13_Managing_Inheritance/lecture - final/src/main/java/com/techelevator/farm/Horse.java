package com.techelevator.farm;

public class Horse extends FarmAnimal {

    public Horse() {
        super("Horse", "neigh");
    }

    @Override
    public void eat() {
        System.out.println("The horse eats");
    }
}
