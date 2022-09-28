package com.techelevator.farm;

public class FarmAnimal {

    private String name;
    private String sound;

    public FarmAnimal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void showSound() {
        System.out.println( getSound() );
    }
}
