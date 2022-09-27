package com.techelevator.farm;

public class Chicken extends FarmAnimal {

    private static final String ANIMAL_NAME = "Chicken";

    public Chicken() {
        super(ANIMAL_NAME, "cluck");
    }

    public void layEgg() {
        System.out.println("The Chicken an egg!");
    }

    @Override
    public String getSound() {
        return "This is an override " + super.getSound();
    }
}
