package com.techelevator.temart.dao.mock;

import com.techelevator.temart.dao.InventoryDao;
import com.techelevator.temart.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MockInventoryDao implements InventoryDao {

    private static final Product CLOTHING_PRODUCT_1 = new Product("C01", "Clothing", "Test Clothing 1",
            "Test Clothing 1 Description", false, 24.98, 6, true);
    private static final Product GROCERY_PRODUCT_1 = new Product("G01", "Grocery", "Test Grocery 1",
            "Test Grocery 1 Description",true, 8.99, 1, false);
    private static final Product HOMEGOOD_PRODUCT_1 = new Product("H01", "Home Goods", "Test Home Goods 1",
            "Test Home Goods 1 Description", false, 5.55, 1, true);
    private static final Product BOOK_PRODUCT_1 = new Product("B01", "Book", "Test Book 1",
            "Test Book 1 Description - taxable", false, 19.95, 11, true);
    private static final Product BOOK_PRODUCT_2 = new Product("B02", "Book", "Test Book 2",
            "Test Book 2 Description - nontaxable", false, 39.95, 5, false);

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(CLOTHING_PRODUCT_1);
        products.add(GROCERY_PRODUCT_1);
        products.add(HOMEGOOD_PRODUCT_1);
        products.add(BOOK_PRODUCT_1);
        products.add(BOOK_PRODUCT_2);
        return products;
    }
}
