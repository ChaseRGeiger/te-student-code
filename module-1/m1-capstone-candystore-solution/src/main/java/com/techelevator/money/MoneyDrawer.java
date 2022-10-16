package com.techelevator.money;

import com.techelevator.money.change.Change;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class MoneyDrawer {

    private ChangeMaker changeMaker = new ChangeMaker();

    private double currentBalance = 0;

    public double getCurrentBalance() {
        return currentBalance;
    }


    public double addMoney(double amountToAdd) {
        if (amountToAdd > 0) {
            currentBalance += amountToAdd;
        }
        return currentBalance;
    }

    public double removeMoney(double amountToRemove) {
        currentBalance -= amountToRemove;
        return currentBalance;
    }

    public ChangeTotal makeChange() {
        ChangeTotal changeTotal = new ChangeTotal();
        if (currentBalance > 0) {
            changeTotal.setChange(changeMaker.makeChange(currentBalance));
            changeTotal.setTotalAmount(currentBalance);
        }
        currentBalance = 0;
        return changeTotal;
    }
}
