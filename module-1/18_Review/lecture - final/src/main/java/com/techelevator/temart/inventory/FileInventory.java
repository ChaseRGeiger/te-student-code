package com.techelevator.temart.inventory;

import com.techelevator.temart.products.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileInventory implements Inventory {

    private Map<String, Product> products = new HashMap<String, Product>();
    private String pathToInventoryFile;

    public FileInventory(String pathToInventoryFile) throws FileNotFoundException {
        this.pathToInventoryFile = pathToInventoryFile;
        populateInventory();
    }

    @Override
    public Map<String, Product> getProducts() {
        return products;
    }

    private void populateInventory() throws FileNotFoundException {

        /*
            Read the file
            For each line
                break it into parts
                Use the parts to create a Product
                Add the product to the map
         */

        File inventoryFile = new File(this.pathToInventoryFile);

        try (Scanner fileReader = new Scanner(inventoryFile); ) {

            while (fileReader.hasNextLine()) {
                String lineFromFile = fileReader.nextLine();
                String[] parts = lineFromFile.split("\\|");
                Product productFromLine = buildProductFromParts(parts);
                products.put(parts[1], productFromLine);
            }
        }


    }

    private Product buildProductFromParts(String[] parts) {
        Product productFromLine = null;

        String productType = parts[0];
        String sku = parts[1];
        String name = parts[2];
        String description = parts[3];
        double price = Double.parseDouble(parts[4]);
        int weight = Integer.parseInt(parts[5]);

        if (productType.equals("G")) {
            productFromLine = new Grocery(sku);
        } else if (productType.equals("C")) {
            productFromLine = new Clothing(sku, 0.5);
        } else if (productType.equals("H")) {
            productFromLine = new Homegood(sku);
        } else if (productType.equals("E")) {
            productFromLine = new Electronic(sku);
        }

        productFromLine.setName(name);
        productFromLine.setDescription(description);
        productFromLine.setPrice(price);
        productFromLine.setWeightInLbs(weight);

        return productFromLine;
    }

}
