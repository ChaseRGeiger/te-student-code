package com.techelevator.dao;

import com.techelevator.model.Product;

import java.util.List;

public interface ProductDao {

     List<Product> list();
     Product get(int productId);
     Product add(Product product);
     void update(Product product);
     void delete(int productId);
     List<String> listCategories();
}
