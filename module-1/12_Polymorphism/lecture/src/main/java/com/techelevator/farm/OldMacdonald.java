package com.techelevator.farm;

import java.net.ProtocolFamily;

public class OldMacdonald {
	public static void main(String[] args) {

		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), new Sheep() };
		Singable[] singers = new Singable[] { new Cow(), new Chicken(), new Sheep(), new Tractor() };

		for (Singable animal : singers) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}
		System.out.println("_______________________");
		System.out.println("Things for sale");
		System.out.println("-----------------------");

		for(FarmAnimal animalsForSale : farmAnimals){

			System.out.println(animalsForSale.getName() + " : " + animalsForSale.getPrice());

		}
	}
}