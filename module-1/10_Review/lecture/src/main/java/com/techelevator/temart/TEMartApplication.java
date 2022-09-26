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
            Get inventory
            Display inventory
            ask user what product they want by SKU
            show details of the selected product
         */

        Inventory inventory = new Inventory();
        Map<String, Product> products = inventory.getProducts();


        displayInventoryToUser(products);

        System.out.print("Select an item by SKU >>> ");

        String skuSelectedByUser = userInput.nextLine().toUpperCase();

        Product selectedProduct = products.get(skuSelectedByUser);

        if(selectedProduct != null){
            System.out.println(selectedProduct);
        }
        else{
            System.out.println("Product not found");
        }

    }

    private static void displayInventoryToUser(Map<String, Product> products){

        for(Map.Entry<String, Product> currentEntry : products.entrySet()){
            System.out.print(currentEntry.getKey());
            System.out.print(" : ");
            System.out.println(currentEntry.getValue().getName());
        }

    }

}
