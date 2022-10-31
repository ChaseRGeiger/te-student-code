package com.techelevator.service;

import com.techelevator.model.Product;
import com.techelevator.services.StoreService;
import org.junit.*;

import java.util.List;
import java.util.PropertyResourceBundle;

public class StoreServiceTest {

    private StoreService storeService;

    @Before
    public void setup(){
        storeService = new StoreService();
    }

    @Test
    public void service_returns_all_products(){
        List<Product> products = storeService.getAllProducts();
        Assert.assertTrue(products.size() > 0);
    }
}
