package com.techelevator.farm;

public class Chicken extends FarmAnimal {

	public Chicken() {
		super("Chicken", "cluck!", 45);
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}