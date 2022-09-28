package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        Chicken chicken = new Chicken();
        FarmAnimal anotherChicken = new Chicken();
        FarmAnimal genericFarmAnimal = new FarmAnimal("", "");
        anotherChicken.getSound();
        anotherChicken.showSound();


        Chicken anotherChickenAsChicken = (Chicken) anotherChicken;

        FarmAnimal cow = new Cow();

        List<FarmAnimal> farmAnimals = new ArrayList<FarmAnimal>();
        farmAnimals.add(chicken);
        farmAnimals.add(cow);

        for (FarmAnimal animal : farmAnimals) {
            System.out.println("The " + animal.getName()
                    + " says " + animal.getSound());
        }



    }
}
