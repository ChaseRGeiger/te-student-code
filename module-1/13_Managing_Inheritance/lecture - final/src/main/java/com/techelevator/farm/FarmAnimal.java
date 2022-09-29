package com.techelevator.farm;

/*
	An abstract class cannot be instantiated and exists only
	to be used as a superclass
 */
public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private boolean sleeping;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	/*
		An abstract method signature in an abstract class
		forces any subclass to override the method and provide
		an implementation (like an interface does)
	 */
	public abstract void eat();

	public void sleep() {
		sleeping = true;
	}

	public void wake() {
		sleeping = false;
	}

	public boolean isSleeping() {
		return sleeping;
	}

	@Override
	public String getName() {
		return name;
	}

	/*
	final when applied to a method prevents the
	method from being overridden in a subclass
	 */
	@Override
	public final String getSound() {
		if (sleeping) {
			return "Zzzzzzzzz...";
		}
		return sound;
	}


}