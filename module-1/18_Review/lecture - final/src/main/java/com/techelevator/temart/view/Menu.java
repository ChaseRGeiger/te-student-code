package com.techelevator.temart.view;

import com.techelevator.temart.products.Product;
import com.techelevator.temart.products.Taxable;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private final Scanner userInput = new Scanner(System.in);

    public void displayWelcomeScreen() {
        System.out.println("**************************");
        System.out.println(" Welcome to TE Mart ");
        System.out.println("**************************");
        System.out.println();
    }

    public void displayInventoryToUser(Map<String, Product> products) {

        for ( Map.Entry<String, Product> currentEntry : products.entrySet() ) {
            System.out.print( currentEntry.getKey() );
            System.out.print(" : ");
            System.out.println( currentEntry.getValue().getName() );
        }
    }

    public String getSkuFromUser() {
        System.out.print("Select an Item by Sku (Q to quit) >>> ");
        String skuSelectedByUser = userInput.nextLine().toUpperCase();
        return skuSelectedByUser;
    }

    public void showItemAddedToCart(String productName) {
        System.out.println(productName + " was added to the cart");
    }

    public void showProductNotFound() {
        System.out.println("Product not found");
    }

    public void showItemsInCart( List<Product> currentCartItems, double shoppingCartTotal) {
        System.out.println();
        System.out.println("Items in your Cart:");

        for (Product product : currentCartItems) {
            System.out.println("Name: " + product.getName());
            System.out.println("Category: " + product.getProductType());
            System.out.printf("Item Price: $%1.2f %n", product.getPrice());

            if (product.isTaxable()) {
                Taxable productAsTaxable = (Taxable) product;
                System.out.printf("Tax: $%1.2f %n", productAsTaxable.getTaxAmount());
            }

            System.out.printf("Total Price: $%1.2f %n", product.getTotalCostWithShipping());
            System.out.println();
        }

        System.out.println("------------------------");
        System.out.printf("Total: $%1.2f %n", shoppingCartTotal);
    }

    public String getInventoryFilepathFromUser() {
        System.out.println("Path to inventory file >>>");
        return userInput.nextLine();
    }

    public void tellUserFileNotFound() {
        System.out.println("File Not Found");
    }
}
