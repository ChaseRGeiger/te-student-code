package com.techelevator.farm;

public class Cow extends FarmAnimal {

    public Cow(){
        super("Cow", "Moo");
    }

    public void giveMilk() {
        System.out.println("The Cow gives milk!");
    }
}