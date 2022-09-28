package com.techelevator.farm;

/*
The final keyword when applied to a class prevents it from
being a superclass
 */
public final class Cat extends FarmAnimal {

    public Cat() {
        super("Cat", "Meow");
    }

    /*
    getSound() cannot be Overridden because it is
    final in the superclass
     */
//    @Override
//    public String getSound() {
//        return "MEOW!!!";
//    }

    @Override
    public void eat() {
        System.out.println("The cat eats");
    }

}
