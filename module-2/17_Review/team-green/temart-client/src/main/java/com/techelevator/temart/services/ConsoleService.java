package com.techelevator.temart.services;


import com.techelevator.temart.model.Product;
import com.techelevator.temart.model.UserCredentials;
import com.techelevator.temart.model.Wishlist;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printGreeting() {
        System.out.println("**********************");
        System.out.println("* Welcome to TEMart! *");
        System.out.println("**********************");
    }

    public void printLoginMenu() {
        System.out.println();
        System.out.println("1: Register");
        System.out.println("2: Login");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println("1: List Products");
        System.out.println("2: Create a Wishlist");
        System.out.println("3: View Your Wishlists");
        System.out.println("4: Add a Product to a Wishlist");
        System.out.println("0: Exit");
        System.out.println();
    }

    public UserCredentials promptForCredentials() {
        String username = promptForString("Username: ");
        String password = promptForString("Password: ");
        return new UserCredentials(username, password);
    }

    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int promptForInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public BigDecimal promptForBigDecimal(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a decimal number.");
            }
        }
    }

    public void addProductToWishlistResponse() {
        System.out.println("Product was added successfully");
    }

    public void addProductToWishlistResponseFail() {
        System.out.println("Product was not added successfully");
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void printInvalidSelection() {
        System.out.println("Invalid Selection");
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

    public void displayAllProducts(List<Product> products) {
    /*
      8) The List<Product> is passed here and then displayed to the user in the console
     */

        displayProductsHeader();
        for (Product product : products) {
            displaySingleProductLine(product);
        }
    }
    public String askUserForWishlistName() {
        System.out.print("Wishlist name >>>");
        return scanner.nextLine();
    }

    public void wishlistCreatedSuccessfully(Wishlist wishlist) {
        System.out.println("Wishlist, " + wishlist.getName() + " created " +
                "successfully!");
    }

    public void displayWishlist(List<Wishlist> wishlists) {
        for(Wishlist wishlist : wishlists) {
            System.out.println(wishlist.getId() + " " + wishlist.getName() );

        }
    }
    public String askUserForProductId() {
        System.out.println("product id to add to wishlist " );
        String idString = scanner.nextLine();
        return idString;
    }


    public int askUserForWishlistId() {
        System.out.println("wishlist id to add product to " );
        String idString = scanner.nextLine();
        return Integer.parseInt(idString);
    }

    private void displaySingleProductLine(Product product) {
        System.out.printf("%-10s %-15s %-25s $%-7.2f%n", product.getSku(), product.getProductType(),
                product.getName(), product.getPrice());
    }

    private void displayProductsHeader() {
        System.out.printf("%-10s %-15s %-25s %-7s%n", "Sku", "Type", "Name", "Price");
        System.out.println("-".repeat(60));
    }
}
