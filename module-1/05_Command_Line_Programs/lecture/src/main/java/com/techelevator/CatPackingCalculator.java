package com.techelevator;

import java.util.Scanner;

public class CatPackingCalculator {
    public static void main(String[] args) {
        double avgVolumeOfHouseCat = 0.083;
        double estimatePackingDensityOfCat = 0.5;

        Scanner userInput = new Scanner(System.in);

        System.out.println("Please input the height of the box: ");
        String height = userInput.nextLine();
        System.out.println("Please input the width of the box: ");
        String width = userInput.nextLine();
        System.out.println("Please input the length of the box: ");
        String length = userInput.nextLine();

        double heightNum = Double.parseDouble(height);
        double widthNum = Double.parseDouble(width);
        double lengthNum = Double.parseDouble(length);

        double boxVolume = heightNum * widthNum * lengthNum;
        double catsByVolume = boxVolume / avgVolumeOfHouseCat;
        double packedCats = catsByVolume * estimatePackingDensityOfCat;

        System.out.printf("You can fit  %4.0f cats in the box", packedCats);




    }
}
