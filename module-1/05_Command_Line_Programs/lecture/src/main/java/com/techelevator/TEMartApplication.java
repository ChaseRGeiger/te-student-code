package com.techelevator;

import java.util.Scanner;

public class TEMartApplication {

    public static void main(String[] args) {

        double shippingCost = 5.25;
        Scanner userInput = new Scanner(System.in);

        String[] products = new String[4];
        products[0] = "Milk,2.97";
        products[1] = "t-bone steak,24.58";
        products[2] = "potatoes,8.99";
        products[3] = "Surviving TE: The Book,19.25";

        System.out.println("Welcome to TE Mart!");
        System.out.println();
        System.out.print("What is your name? ");
        String name = userInput.nextLine();
        System.out.println("Thank you for shopping with us " + name + "!");

        System.out.println();

        System.out.println("Here is what is available");
        for(int i = 0; i < products.length; i++){
            System.out.println((i+1) + ") " + products[i]);
        }
        System.out.println("Which product would you like to purchase " + name + "?");
        String numberSelected = userInput.nextLine();

        int menuNumber = Integer.parseInt(numberSelected);
        String selectedProduct = "";

        if(menuNumber <= products.length && menuNumber > 0) {
            selectedProduct = products[menuNumber - 1];
            System.out.println("You have selected " + selectedProduct);
        }
        else{
            System.out.println("Product not found");
        }

        System.out.println("Is this the correct item? (Y/N)");
        String userChoice = userInput.nextLine();

        if(userChoice.equalsIgnoreCase("N")){
            System.out.println("Sorry we couldn't help :(");
        }
        else if(userChoice.equalsIgnoreCase("Y")){
            String[] parts = selectedProduct.split(",");
            String productName = parts[0];
            String priceFromString = parts[1];
            double price = Double.parseDouble(priceFromString);
            double priceWithShipping = price + shippingCost;

            System.out.println("Thank you for your purchase! You have paid " + priceWithShipping);

            System.out.println("Your Order");
            System.out.printf("%-20s Price: %-10s ", productName, price);
            System.out.printf("Shipping: %-10s Total: $%6.2f %n", shippingCost, priceWithShipping);
        }
        else{
            System.out.println("Invalid input");
        }
        System.out.println();
        System.out.println("Have a Great Day and Please Come Again!");



    }

}
