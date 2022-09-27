package com.techelevator.printer;

public class Animal {

    private String type;
    private String sound;

    public Animal(String type, String sound) {
        this.type = type;
        this.sound = sound;
    }

    public String getType() {
        return type;
    }

    public String getSound() {
        return sound;
    }

    public void displayWhatTheAnimalSays() {
        System.out.println("The " + type.toUpperCase() + " says " + sound.toUpperCase() + "!!");
    }
}
