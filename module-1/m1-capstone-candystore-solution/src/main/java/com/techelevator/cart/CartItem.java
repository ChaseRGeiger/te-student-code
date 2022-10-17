package com.techelevator.cart;

import com.techelevator.inventory.items.CandyStoreItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class CartItem {

    private CandyStoreItem item;
    private int count = 0;

    public CartItem(CandyStoreItem item, int count) {
        this.item = item;
        if (count > 0) {
            this.count = count;
        }
    }

    public CandyStoreItem getItem() {
        return item;
    }

    public int getCount() {
        return count;
    }

    public double getTotalCost() {
        return new BigDecimal(item.getPrice()).multiply(new BigDecimal(count)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return count == cartItem.count && Objects.equals(item, cartItem.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, count);
    }
}
