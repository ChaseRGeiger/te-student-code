package com.techelevator.cart;

import com.techelevator.inventory.items.CandyStoreItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<CartItem> cart = new ArrayList<CartItem>();

    public List<CartItem> getCart() {
        return cart;
    }

    public CartItem addItemToCart(CandyStoreItem item, int quantity) {
        CartItem cartItem = new CartItem(item, quantity);
        cart.add(cartItem);
        return cartItem;
    }

    public void clearCart() {
        cart = new ArrayList<CartItem>();
    }

    public double getCartTotalAmount() {
        BigDecimal total = BigDecimal.ZERO;
        for (CartItem cartItem : cart) {
            total = total.add( new BigDecimal(cartItem.getTotalCost()) );
        }
        return total.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
