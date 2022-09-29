package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		/*
			FarmAnimal cannot be instantiated because it is abstract
		 */
		//FarmAnimal genericFarmAnimal = new FarmAnimal("", "");

		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), new Sheep(), new Horse() };

		Chicken chicken = new Chicken();
		chicken.wake();

		Cat farmCat = new Cat();
		//farmCat.sleep();

		TabbyCat tabbyCat = new TabbyCat();

		Singable[] singers = new Singable[] { new Cow(), chicken,
				new Sheep(), new Tractor(), new Horse(),
				new MusicBox(), farmCat };
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

			if (animal instanceof Chicken) {
				Chicken singerAsChicken = (Chicken) animal;
				((Chicken) animal).layEgg();
			}

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