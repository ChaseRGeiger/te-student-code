package com.techelevator.temart;

import com.techelevator.temart.products.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> cart = new ArrayList<Product>();

    public void addToCart(Product productToAdd) {
        cart.add(productToAdd);
    }

    public double getTotal() {
        double totalPrice = 0;
        for (Product product : cart) {
            totalPrice += product.getTotalCostWithShipping();
        }
        return totalPrice;
    }

    public List<Product> getItemsInCart() {
        return cart;
    }

}
