package com.techelevator.temart.dao;


import com.techelevator.temart.model.Product;

import java.util.List;

public interface InventoryDao {

    public List<Product> getAllProducts();
}
