package com.techelevator.temart.services;

import com.techelevator.temart.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StoreServiceTests {

    private static final String API_BASE_URL = "http://localhost:8080/";
    private StoreService service;

    @Before
    public void setup() {
        service = new StoreService(API_BASE_URL);
    }

    @Test
    public void service_returns_all_products() {
        List<Product> products = service.getAllProducts();
        Assert.assertTrue(products.size() > 0);
    }
}
