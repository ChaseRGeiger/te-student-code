package com.techelevator.temart;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String, Product> products = new HashMap<String, Product>();

    public Inventory(){
        populateInventory();

    }

    public Map<String, Product> getProducts(){
        return products;
    }

    private void populateInventory(){
        Product eggs = new Product("G01");
        eggs.setName("Eggs");
        eggs.setDescription("They're eggs");
        eggs.setPerishable(true);
        eggs.setExpirationDate(LocalDate.now().plusMonths(1));
        eggs.setPrice(5.99);
        eggs.setWeightInLbs(1);

        products.put("G01", eggs);

        Product underwear = new Product("C12", "Underwear", "For wearing under your clothes", 9.98, 6);
        products.put("C12", underwear);

        Product rubberDuck = new Product("H05", "Rubberduck", "Great for talking to", 1.99, 12);
        products.put("H05", rubberDuck);

        Product laptop = new Product("E14", "Laptop", "RuberDuck not included.", 149.95, 2);
        products.put("E14", laptop);

    }
}
