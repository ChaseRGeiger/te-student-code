package com.techelevator;

import java.util.Scanner;

public class CatPackingCalculator {

    public static void main(String[] args) {

        double averageVolumeOfHouseCat = 0.083;
        double estimatePackingDensityOfCat = 0.5;
        Scanner userInput = new Scanner(System.in);

        System.out.println("What is the height of the box?");
        String heightOfBox = userInput.nextLine();
        double height = Double.parseDouble(heightOfBox);

        System.out.println("What is the width of the box?");
        String widthOfBox = userInput.nextLine();
        double width = Double.parseDouble(widthOfBox);

        System.out.println("What is the length of the box?");
        String lengthOfBox = userInput.nextLine();
        double length = Double.parseDouble(lengthOfBox);

        double volumeOfBox = height * width * length;
        double catsByVolumne = volumeOfBox / averageVolumeOfHouseCat;
        double packedCats = catsByVolumne * estimatePackingDensityOfCat;

        System.out.printf("You can fit %4.0f cats in the box", packedCats);
    }
}
