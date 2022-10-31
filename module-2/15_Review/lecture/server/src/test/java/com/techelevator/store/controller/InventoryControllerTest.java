package com.techelevator.store.controller;


import com.techelevator.store.dao.mock.MockInventoryDao;
import com.techelevator.store.model.Product;
import org.junit.*;

import java.util.List;

public class InventoryControllerTest {

    private InventoryController inventoryController;

    @Before
    public void setup(){
        inventoryController = new InventoryController((new MockInventoryDao()));
    }

    @Test
    public void list_all_products(){
        List<Product> productsReturned = inventoryController.listProducts();
        Assert.assertEquals(5, productsReturned.size());
    }

}
