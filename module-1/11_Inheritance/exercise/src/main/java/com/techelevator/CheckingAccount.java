package com.techelevator;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }


    @Override
    public int withdraw(int amountToWithdraw) {

        int overDraftFee = 10;
        int withdrawCheckAmt = getBalance() - amountToWithdraw;

        if (withdrawCheckAmt <= 0 && withdrawCheckAmt > -100) {
            amountToWithdraw += overDraftFee;

            return super.withdraw(amountToWithdraw);

        }
        else if(withdrawCheckAmt > 0){
            return super.withdraw(amountToWithdraw);
        }

        return getBalance();
    }
}

