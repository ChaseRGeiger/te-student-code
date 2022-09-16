package com.techelevator;

import java.util.Scanner;

public class TEMartApplication {

    public static void main(String[] args) {

        double shippingCost = 5.25;

        String[] products = new String[4];
        products[0] = "Milk,2.97";
        products[1] = "t-bone steak,24.58";
        products[2] = "potatoes,8.99";
        products[3] = "Surviving TE: The Book,19.25";

        System.out.println("***********************");
        System.out.println("Welcome to TE Mart");
        System.out.println("***********************");
        System.out.println();

        System.out.print("What is your name? ");

        Scanner userInput = new Scanner(System.in);
        String usersName = userInput.nextLine();

        System.out.print("Hello ");
        System.out.println(usersName);

        System.out.println();

        System.out.println("Here is what is available");

        for (int i = 0; i < products.length; i++) {
            System.out.println( (i + 1) + ") " + products[i] );
        }

        System.out.println();
        System.out.print("Please select an item >> ");
        String numberSelected = userInput.nextLine();

        /*
            Can also use the next() method on Scanner, but when nextInt() is used
            nextLine() must be called immediately after it to cleanup the leftover
            return in the stream.

            int numberSelected = userInput.nextInt();
            userInput.nextLine();
         */


        int productNumber = Integer.parseInt(numberSelected);

        String selectedProduct = "";
        if (productNumber <= products.length && productNumber > 0) {
            selectedProduct = products[productNumber - 1];
            System.out.print("You selected ");
            System.out.println(selectedProduct);
        } else {
            System.out.println("Product not found!");
        }

        System.out.print("Is this correct? (Y/N)");
        String userChoice = userInput.nextLine();

        if (userChoice.equals("N")) {
            System.out.println("Sorry we couldn't help you");
        } else {
            String[] parts = selectedProduct.split(",");
            String productName = parts[0];
            String priceFromString = parts[1];
            double price = Double.parseDouble(priceFromString);
            double priceWithShipping = price + shippingCost;

            System.out.println("Your order");
            System.out.printf("%-20s Price: %-10s ", productName, price);
            System.out.printf("Shipping: %-10s Total: $%6.2f %n", shippingCost, priceWithShipping);
        }

        System.out.println();
        System.out.println("Thank you!  Please shop with us again.");


    }

}
