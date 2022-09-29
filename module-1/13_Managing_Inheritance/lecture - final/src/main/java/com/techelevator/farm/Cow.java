package com.techelevator.farm;

public class Cow extends FarmAnimal implements Sellable {

	public Cow() {
		super("Cow", "moo!");
	}

	@Override
	public int getPrice() {
		return 2500;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Cow)) {
			return false;
		}
		Cow otherCow = (Cow) obj;
		if (this.getSound().equals(otherCow.getSound()) &&
				this.getName().equals(otherCow.getName()) &&
				this.getPrice() == otherCow.getPrice()) {
			return true;
		}
		return false;
	}

	@Override
	public void eat() {
		System.out.println("The cow eats");
	}

}