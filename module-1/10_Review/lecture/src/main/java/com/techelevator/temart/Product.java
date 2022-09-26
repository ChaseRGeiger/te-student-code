package com.techelevator.temart;

import java.time.LocalDate;
import java.util.Objects;

public class Product {

    private final static double BASE_COST = 5.00;
    private String name;
    private double price;
    private String sku;
    private String description;
    private int weightInLbs;
    private LocalDate expirationDate;
    private boolean isPerishable;


    public Product(String sku){
        this.sku = sku;
    }

    public Product(String sku, String name, String description, double price, int weightInLbs){
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.description = description;
        this.weightInLbs = weightInLbs;
    }

    //If weight <= 5 base cost of 5.00
    //weight between 5 and 10 double base cost
    //if > 10 then triple base cost
    //if perishable then everything is doubled in cost
    public double getShippingCost(){

        double totalCost = BASE_COST;

        if(weightInLbs > 5 && weightInLbs <= 10){
            totalCost *= 2;
        }
        if(weightInLbs > 10){
            weightInLbs *= 3;
        }
        if(isPerishable){
            totalCost*=2;
        }

        return totalCost;

    }

    public double getTotalCostWithShipping(){

        return getShippingCost() + price;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSku() {
        return sku;
    }

    public String getDescription() {
        return description;
    }

    public int getWeightInLbs() {
        return weightInLbs;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public boolean isPerishable() {
        return isPerishable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeightInLbs(int weightInLbs) {
        this.weightInLbs = weightInLbs;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && weightInLbs == product.weightInLbs && isPerishable == product.isPerishable && Objects.equals(name, product.name) && Objects.equals(sku, product.sku) && Objects.equals(description, product.description) && Objects.equals(expirationDate, product.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, sku, description, weightInLbs, expirationDate, isPerishable);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", sku='" + sku + '\'' +
                ", description='" + description + '\'' +
                ", weightInLbs=" + weightInLbs +
                ", expirationDate=" + expirationDate +
                ", isPerishable=" + isPerishable +
                '}';
    }
}
