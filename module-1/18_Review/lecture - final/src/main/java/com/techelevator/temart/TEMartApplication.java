package com.techelevator.temart;


import com.techelevator.temart.inventory.FileInventory;
import com.techelevator.temart.inventory.Inventory;
import com.techelevator.temart.inventory.MemoryInventory;
import com.techelevator.temart.products.Product;
import com.techelevator.temart.view.Menu;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TEMartApplication {

    private final static Scanner userInput = new Scanner(System.in);
    private Menu menu = new Menu();
    private ShoppingCart shoppingCart = new ShoppingCart();

    public static void main(String[] args) {
        TEMartApplication app = new TEMartApplication();
        app.run();
    }

    public void run() {

        Inventory inventoryBuilder = getInventoryBuilder();
        //Inventory inventoryBuilder = new MemoryInventory();

        Map<String, Product> products = inventoryBuilder.getProducts();

        menu.displayWelcomeScreen();
        menu.displayInventoryToUser(products);

        productSelectionProcess(products);
        showShoppingCart();

    }

    private Inventory getInventoryBuilder() {
        Inventory inventoryBuilder = null;

        while (true) {
            String pathToInventoryFile = menu.getInventoryFilepathFromUser();
            //Inventory inventoryBuilder = new MemoryInventory();
            try {
                inventoryBuilder = new FileInventory(pathToInventoryFile);
                break;
            } catch (FileNotFoundException e) {
                menu.tellUserFileNotFound();
            }
        }
        return inventoryBuilder;
    }

    private void showShoppingCart() {
        List<Product> currentCartItems = shoppingCart.getItemsInCart();
        double shoppingCartTotal = shoppingCart.getTotal();
        menu.showItemsInCart(currentCartItems, shoppingCartTotal);
    }

    private void productSelectionProcess(Map<String, Product> products) {
        while (true) {

            String skuSelectedByUser = menu.getSkuFromUser();
            if (skuSelectedByUser.equalsIgnoreCase("Q")) {
                break;
            }
            Product selectedProduct = products.get(skuSelectedByUser);

            if (selectedProduct != null) {
                shoppingCart.addToCart(selectedProduct);
                menu.showItemAddedToCart(selectedProduct.getName());
            } else {
                menu.showProductNotFound();
            }
        }
    }


}
