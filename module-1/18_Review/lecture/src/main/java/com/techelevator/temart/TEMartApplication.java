package com.techelevator.temart;


import com.techelevator.temart.products.Product;
import com.techelevator.temart.products.Taxable;

import java.util.List;
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
        ShoppingCart shoppingCart = new ShoppingCart();

        displayInventoryToUser(products);

        while (true) {
            System.out.print("Select an Item by Sku (Q to quit) >>> ");

            String skuSelectedByUser = userInput.nextLine().toUpperCase();

            if (skuSelectedByUser.equalsIgnoreCase("Q")) {
                break;
            }

            Product selectedProduct = products.get(skuSelectedByUser);

            if (selectedProduct != null) {
                shoppingCart.addToCart(selectedProduct);
                // Print the details
                System.out.println(selectedProduct.getName() + " was added to the cart");
            } else {
                System.out.println("Product not found");
            }
        }

        List<Product> currentCartItems = shoppingCart.getItemsInCart();

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
        System.out.printf("Total: $%1.2f %n", shoppingCart.getTotal());


    }

    private static void displayInventoryToUser(Map<String, Product> products) {

        for ( Map.Entry<String, Product> currentEntry : products.entrySet() ) {
            System.out.print( currentEntry.getKey() );
            System.out.print(" : ");
            System.out.println( currentEntry.getValue().getName() );
        }


    }
}
