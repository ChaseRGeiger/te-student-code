package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), new Sheep(), new Horse() };
		Singable[] singers = new Singable[] { new Cow(), new Chicken(),
				new Sheep(), new Tractor(), new Horse(), new MusicBox() };
		Sellable[] thingsWeCanSell = new Sellable[] { new Cow(), new Chicken(), new Sheep(),
				new Egg(), new MusicBox() };

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

		System.out.println("------------------------");
		System.out.println("Things for sale");
		System.out.println("------------------------");

		for (Sellable animalForSale : thingsWeCanSell) {
			System.out.println(animalForSale.getName()
					+ " : " + animalForSale.getPrice());
		}

	}
}