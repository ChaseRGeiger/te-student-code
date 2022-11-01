package com.techelevator.temart.services;


import com.techelevator.temart.model.Product;
import com.techelevator.temart.model.UserCredentials;

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


    private void displaySingleProductLine(Product product) {
        System.out.printf("%-10s %-15s %-25s $%-7.2f%n", product.getSku(), product.getProductType(),
                product.getName(), product.getPrice());
    }

    private void displayProductsHeader() {
        System.out.printf("%-10s %-15s %-25s %-7s%n", "Sku", "Type", "Name", "Price");
        System.out.println("-".repeat(60));
    }
}
