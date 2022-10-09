package com.techelevator.exceptions.accounts;

import java.util.Scanner;

public class BankApplication {

    private Menu menu = new Menu();

    public void run() {
        Account account = new CheckingAccount();

        menu.showWelcome();
        menu.showBalance(account);

        int amount = menu.getAmountFromUser();

        try {
            account.withdraw(amount);
            menu.showWithdrawSucceessMessage(amount);
        } catch(InsufficientFundsException e) {
            menu.showInsufficientFunds(e);
        }

        menu.showBalance(account);
    }

    public static void main(String[] args) {
        BankApplication app = new BankApplication();
        app.run();
    }



}
