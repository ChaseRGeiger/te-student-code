package com.techelevator.temart.inventory;

import com.techelevator.temart.products.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MemoryInventory implements Inventory {

    private Map<String, Product> products = new HashMap<String, Product>();

    public MemoryInventory() {
        populateInventory();
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    private void populateInventory() {

        Grocery eggs = new Grocery("G01");
        eggs.setName("Eggs");
        eggs.setDescription("They're eggs");
        eggs.setPerishable(true);
        eggs.setExpirationDate(LocalDate.now().plusMonths(1));
        eggs.setPrice(5.99);
        eggs.setWeightInLbs(1);

        products.put("G01", eggs);

        Product underwear = new Clothing("C12", "Underwear",
                9.98, "For wearing under your clothes", 6, .05);

        products.put("C12", underwear);

        Product rubberDuck = new Homegood("H05", "Rubber duck",
                1.99, "For when coding is not going well", 12);

        products.put("H05", rubberDuck);

        Product laptop = new Electronic("E14", "Laptop",
                149.95, "Rubber duck not included", 2);

        products.put("E14", laptop);
    }

}
