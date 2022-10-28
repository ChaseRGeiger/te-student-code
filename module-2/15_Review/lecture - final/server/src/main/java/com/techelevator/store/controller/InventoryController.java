package com.techelevator.store.controller;

import com.techelevator.store.dao.InventoryDao;
import com.techelevator.store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class InventoryController {

    private InventoryDao inventoryDao;

    public InventoryController(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    @RequestMapping(path="/products", method=RequestMethod.GET)
    public List<Product> listProducts() {
        return inventoryDao.getAllProducts();
    }

}
