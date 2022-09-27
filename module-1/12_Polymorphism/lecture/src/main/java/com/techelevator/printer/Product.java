package com.techelevator.printer;

import java.time.LocalDate;


public class Product implements Printable {

    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLACK = "\u001B[30m";

    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    private final static double BASE_COST = 5.00;

    private String sku;
    private String name;
    private double price;
    private String description;
    private int weightInLbs;
    private LocalDate expirationDate;
    private boolean isPerishable;

    public Product(String sku) {
        this.sku = sku;
    }

    public Product(String sku, String name, double price, String description, int weightInLbs) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.description = description;
        this.weightInLbs = weightInLbs;
    }

    /*
        If weight <= 5 will be a base cost 5.00
        If the weight  5 and 10 the double the base cost
        If > 10 then triple the base cost
        If perishable then every is double the cost
     */
    public double getShippingCost() {

        double totalCost = BASE_COST;
        if (weightInLbs > 5 && weightInLbs <= 10) {
            totalCost *= 2;
        }
        if (weightInLbs > 10) {
            totalCost *= 3;
        }

        if (isPerishable) {
            totalCost *= 2;
        }

        return totalCost;
    }

    public double getTotalCostWithShipping() {
        return getShippingCost() + price;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeightInLbs() {
        return weightInLbs;
    }

    public void setWeightInLbs(int weightInLbs) {
        this.weightInLbs = weightInLbs;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isPerishable() {
        return isPerishable;
    }

    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
    }



    /*
        This is BAD code as a data class should never use System.out
     */
    public void displayProductDetails() {
        System.out.print("Name: ");
        System.out.println(ANSI_RED + this.name + ANSI_RESET);
        System.out.printf("Price: " + ANSI_YELLOW + "$%2.2f%n"  + ANSI_RESET, this.price);
        System.out.printf("Weight: " + ANSI_YELLOW + "%-2s%n"  + ANSI_RESET, this.weightInLbs);
        System.out.printf("Shipping Cost: " + ANSI_YELLOW + "$%2.2f%n"  + ANSI_RESET, getShippingCost());
        System.out.printf(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + " Total Cost: $%2.2f%n" + ANSI_RESET,
                (this.price + getShippingCost()));

    }

    public void print(){
        displayProductDetails();
    }

}
