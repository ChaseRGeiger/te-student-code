package com.techelevator.sale;

import com.techelevator.cart.CartItem;
import com.techelevator.money.ChangeTotal;

import java.util.List;

public class CompletedSale {

    private List<CartItem> items;
    private double totalSaleAmount;
    private ChangeTotal change;

    public CompletedSale(List<CartItem> items, double totalSaleAmount, ChangeTotal change) {
        this.items = items;
        this.totalSaleAmount = totalSaleAmount;
        this.change = change;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotalSaleAmount() {
        return totalSaleAmount;
    }

    public ChangeTotal getChange() {
        return change;
    }


}
