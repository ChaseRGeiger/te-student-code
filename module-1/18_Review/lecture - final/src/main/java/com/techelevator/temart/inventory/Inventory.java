package com.techelevator.temart.inventory;

import com.techelevator.temart.products.Product;

import java.util.Map;

public interface Inventory {

    Map<String, Product> getProducts();
}
