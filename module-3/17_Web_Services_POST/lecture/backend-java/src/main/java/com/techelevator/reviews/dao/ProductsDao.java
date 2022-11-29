package com.techelevator.reviews.dao;

import com.techelevator.reviews.model.Product;

import java.util.List;

public interface ProductsDao {

    List<Product> list();
    Product getById(long productId);
    Product add(Product product);
    Product update(Product product);
    void delete(long productId);

}
