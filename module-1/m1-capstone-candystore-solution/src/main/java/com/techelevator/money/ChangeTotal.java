package com.techelevator.money;

import com.techelevator.money.change.Change;

import java.util.ArrayList;
import java.util.List;

public class ChangeTotal {

    private List<Change> change = new ArrayList<Change>();
    private double totalAmount = 0;


    public void setChange(List<Change> change) {
        this.change = change;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Change> getChange() {
        return change;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
