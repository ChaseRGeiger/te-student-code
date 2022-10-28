package com.techelevator;

import com.techelevator.model.Product;
import com.techelevator.services.ConsoleService;
import com.techelevator.services.StoreService;

import java.util.List;

public class App {


    private ConsoleService consoleService = new ConsoleService();
    private StoreService storeService = new StoreService();

    /*
        The app starts here
     */
    public void run() {

        /*
            1) Calls the Service to get all the Products
         */
        List<Product> products = storeService.getAllProducts();
        /*
            7) When the List<Product> is returned from the StoreService (API)
               it is passed to the ConsoleService to be displayed to the user
         */
        consoleService.displayAllProducts(products);



    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
