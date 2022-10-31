package com.techelevator.temart.controller;

import com.techelevator.temart.dao.InventoryDao;
import com.techelevator.temart.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class InventoryController {

    private InventoryDao inventoryDao;

    public InventoryController(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    @RequestMapping(path="/products", method=RequestMethod.GET)
    public List<Product> listProducts() {
        /*
            3) The Controller method receives the HTTP request
              and calls the DAO method to get all the products
         */

        /*
            5) When the controller method receives the List<Product>
               from the DAO it returns it to be used in the HTTP response.
               The View (part of Spring) then serializes the List<Product>
               into a JSON array of objects.
               The JSON is then returned as the response to the client.
         */
        return inventoryDao.getAllProducts();
    }

}
