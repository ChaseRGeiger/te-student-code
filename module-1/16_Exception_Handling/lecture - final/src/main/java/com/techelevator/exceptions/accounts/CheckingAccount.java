package com.techelevator.exceptions.accounts;

public class CheckingAccount implements Account {

    private int balance = 500;

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int withdraw(int amount) throws InsufficientFundsException {

        // If the balance goes below the $500 minimum add a $10 fee
        balance -= amount;
        if (balance < 500) {
            balance -= 10;
            throw new InsufficientFundsException("Balance is below minimum.  Fee Charged.", 10);
        }

        return balance;
    }
}
