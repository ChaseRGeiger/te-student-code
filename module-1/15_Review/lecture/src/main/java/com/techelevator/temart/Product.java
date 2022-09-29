package com.techelevator.temart;

import java.time.LocalDate;
import java.util.Objects;

public class Product {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && weightInLbs == product.weightInLbs && isPerishable == product.isPerishable && Objects.equals(sku, product.sku) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(expirationDate, product.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, name, price, description, weightInLbs, expirationDate, isPerishable);
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", weightInLbs=" + weightInLbs +
                ", expirationDate=" + expirationDate +
                ", isPerishable=" + isPerishable +
                '}';
    }
}
