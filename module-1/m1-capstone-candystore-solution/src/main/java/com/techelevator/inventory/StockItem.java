package com.techelevator.inventory;

import com.techelevator.inventory.items.CandyStoreItem;

import java.util.Objects;

public class StockItem {

    private CandyStoreItem item;
    private int quantity;

    public StockItem(CandyStoreItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public CandyStoreItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void removeQuantity(int amountToRemove) {
        quantity -= amountToRemove;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockItem stockItem = (StockItem) o;
        return quantity == stockItem.quantity && item.equals(stockItem.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, quantity);
    }
}
