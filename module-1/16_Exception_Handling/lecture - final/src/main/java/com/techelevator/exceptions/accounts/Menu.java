package com.techelevator.exceptions.accounts;

import java.util.Scanner;

public class Menu {

    private final Scanner in = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("Welcome to the Java Blue bank");
    }

    public int getAmountFromUser() {

        while (true) {
            System.out.print("Amount to withdraw >>> ");
            String userInput = in.nextLine();

            try {
                int amount = Integer.parseInt(userInput);
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }

    }

    public void showBalance(Account account) {
        System.out.println("Current Balance: " + account.getBalance());
        System.out.println();
    }

    public void showWithdrawSucceessMessage(int amount) {
        System.out.println(amount + " was withdrawn");
    }

    public void showInsufficientFunds(InsufficientFundsException e) {
        System.out.println(e.getMessage());
        System.out.printf("$%2s Fee Charged%n", e.getFee());
    }


}
