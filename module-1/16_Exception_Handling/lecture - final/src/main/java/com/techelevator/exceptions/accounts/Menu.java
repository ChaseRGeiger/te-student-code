package com.techelevator.exceptions.accounts;

import java.util.Scanner;

public class Menu {

    private final Scanner in = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("Welcome to the Java Blue bank");
    }

    public int getAmountFromUser() {

        System.out.print("Amount to withdraw >>> ");
        String userInput = in.nextLine();

        int amount = Integer.parseInt(userInput);

        return amount;

    }

    public void showBalance(Account account) {
        System.out.println("Current Balance: " + account.getBalance());
        System.out.println();
    }

    public void showWithdrawSucceessMessage(int amount) {
        System.out.println(amount + " was withdrawn");
    }



}
