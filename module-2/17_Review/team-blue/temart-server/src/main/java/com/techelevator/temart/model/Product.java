package com.techelevator.temart.model;

import java.util.Objects;

public class Product {

    private String sku;
    private String productType;
    private String name;
    private String description;
    private boolean perishable;
    private double price;
    private int weight;
    private boolean taxable;

    public Product() {

    }

    public Product(String sku, String productType, String name, String description,
                   boolean perishable, double price, int weight, boolean taxable) {
        this.sku = sku;
        this.productType = productType;
        this.name = name;
        this.description = description;
        this.perishable = perishable;
        this.price = price;
        this.weight = weight;
        this.taxable = taxable;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return perishable == product.perishable && Double.compare(product.price, price) == 0 && weight == product.weight && taxable == product.taxable && Objects.equals(sku, product.sku) && Objects.equals(productType, product.productType) && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, productType, name, description, perishable, price, weight, taxable);
    }
}
