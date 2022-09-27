package com.techelevator.farm;

public class Chicken extends FarmAnimal {

    public Chicken() {
        super("Chicken", "cluck");
    }

    public void layEgg() {
        System.out.println("The Chicken an egg!");
    }
}
