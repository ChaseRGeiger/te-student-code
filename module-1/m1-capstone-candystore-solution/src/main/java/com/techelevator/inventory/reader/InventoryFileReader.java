package com.techelevator.inventory.reader;

import com.techelevator.inventory.StockItem;
import com.techelevator.inventory.exceptions.InventoryNotFoundException;
import com.techelevator.inventory.items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
    This class should contain any and all details of access to the inventory file
 */
public class InventoryFileReader implements InventoryReader {

    private static final int STARTING_QUANTITY = 100;
    private static final String TYPE_CHOCOLATE = "CH";
    private static final String TYPE_SOUR = "SR";
    private static final String TYPE_LICORICE = "LI";
    private static final String TYPE_HARD_CANDY = "HC";

    private File inventoryFile;

    public InventoryFileReader(String inventoryFileName) {
        this.inventoryFile = new File(inventoryFileName);

    }

    @Override
    public Map<String, StockItem> read() throws InventoryNotFoundException {
        Map<String, StockItem> items = new TreeMap<String, StockItem>();

        try (Scanner fileReader = new Scanner(inventoryFile); ) {

            while (fileReader.hasNextLine()) {
                String lineFromFile = fileReader.nextLine();
                String[] parts = lineFromFile.split("\\|");
                CandyStoreItem candyItem = buildProductFromParts(parts);
                String id = parts[1];
                items.put(id, new StockItem(candyItem, STARTING_QUANTITY));
            }
        } catch (FileNotFoundException e) {
            String exceptionMessage = "Inventory File Not Found: " + inventoryFile.getAbsolutePath();
            throw new InventoryNotFoundException(exceptionMessage, e);
        }

        return items;
    }


    private CandyStoreItem buildProductFromParts(String[] parts) {
        CandyStoreItem candyItem = null;

        String candyType = parts[0];
        String name = parts[2];
        double price = Double.parseDouble(parts[3]);
        boolean isWrapped = parts[4].equals("T");

        if (candyType.equals(TYPE_CHOCOLATE)) {
            candyItem = new Chocolate(name,price,isWrapped);
        } else if (candyType.equals(TYPE_SOUR)) {
            candyItem = new Sour(name,price,isWrapped);
        } else if (candyType.equals(TYPE_HARD_CANDY)) {
            candyItem = new HardCandy(name,price,isWrapped);
        } else if (candyType.equals(TYPE_LICORICE)) {
            candyItem = new Licorice(name,price,isWrapped);
        }

        return candyItem;
    }
}
