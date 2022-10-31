package com.techelevator;

import com.techelevator.model.Product;
import com.techelevator.services.ConsoleService;
import com.techelevator.services.StoreService;

import java.util.List;

public class App {


    private ConsoleService consoleService = new ConsoleService();
    private StoreService storeService = new StoreService();

    public void run() {
        List<Product> products = storeService.getAllProducts();
        consoleService.displayAllProducts(products);



    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
