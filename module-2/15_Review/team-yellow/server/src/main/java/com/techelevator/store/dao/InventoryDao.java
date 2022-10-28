package com.techelevator.store.dao;


import com.techelevator.store.model.Product;

import java.util.List;

public interface InventoryDao {

    public List<Product> getAllProducts();
}
