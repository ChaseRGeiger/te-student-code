package com.techelevator;

public class SavingsAccount extends BankAccount{

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    @Override
    public int withdraw(int amountToWithdraw){

        int remainingBalance = getBalance() - amountToWithdraw;
        int lowestBalanceAllowed = 150;
        int serviceCharge = 2;
        if(remainingBalance >= 150){
            return super.withdraw(amountToWithdraw);
        }
        else if(remainingBalance - serviceCharge < 0){
            return getBalance();
        }
        else if(remainingBalance < lowestBalanceAllowed){
            amountToWithdraw += serviceCharge;
            return super.withdraw(amountToWithdraw);
        }



        return getBalance();
    }


}
