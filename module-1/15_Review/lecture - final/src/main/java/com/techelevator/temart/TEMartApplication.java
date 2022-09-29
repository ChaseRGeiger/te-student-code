package com.techelevator.temart;


import java.util.Map;
import java.util.Scanner;

public class TEMartApplication {

    private final static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("**************************");
        System.out.println(" Welcome to TE Mart ");
        System.out.println("**************************");
        System.out.println();

        /*
            1) Get the inventory
            2) Display the inventory to the user
            3) Ask the user what product the want by sku
            4) Show the details of the selected product
         */

        Inventory inventoryBuilder = new Inventory();
        Map<String, Product> products = inventoryBuilder.getProducts();

        displayInventoryToUser(products);

        System.out.print("Select an Item by Sku >>> ");

        String skuSelectedByUser = userInput.nextLine().toUpperCase();

        Product selectedProduct = products.get( skuSelectedByUser );

        if (selectedProduct != null) {
            // Print the details
            System.out.println( selectedProduct );
        } else {
            System.out.println("Product not found");
        }
    }

    private static void displayInventoryToUser(Map<String, Product> products) {

        for ( Map.Entry<String, Product> currentEntry : products.entrySet() ) {
            System.out.print( currentEntry.getKey() );
            System.out.print(" : ");
            System.out.println( currentEntry.getValue().getName() );
        }


    }
}
