package com.techelevator.service;

import com.techelevator.model.Product;
import com.techelevator.services.StoreService;
import org.junit.*;

import java.util.List;

public class StoreServiceTests {

    private StoreService service;

    @Before
    public void setup() {
        service = new StoreService();
    }

    @Test
    public void service_returns_all_products() {
        List<Product> products = service.getAllProducts();
        Assert.assertTrue(products.size() > 0);
    }
}
