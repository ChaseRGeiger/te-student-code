package com.techelevator.temart.products;

import java.util.Objects;

public class Product {

    private final static double BASE_SHIPPING_COST = 5.00;

    private String productTypeCode;
    private double price;
    private String name;
    private String description;
    private int weightInLbs;
    private String sku;
    private boolean isPerishable = false;
    private boolean isTaxable = false;

    public Product() {

    }


    public Product(String productTypeCode, String sku, String name, String description, boolean isPerishable, double price, int weightInLbs,  boolean isTaxable) {
        this.productTypeCode = productTypeCode;
        this.price = price;
        this.name = name;
        this.description = description;
        this.weightInLbs = weightInLbs;
        this.sku = sku;
        this.isPerishable = isPerishable;
        this.isTaxable = isTaxable;
    }


    // derived Properties
    public double getShippingCost() {

        double shippingCost = BASE_SHIPPING_COST;
        if (weightInLbs > 5 && weightInLbs <= 10) {
            shippingCost *= 2;
        } else if (weightInLbs > 10) {
            shippingCost *= 4;
        }

        if (isPerishable) {
            shippingCost *= 2;
        }

        return shippingCost;
    }

    public double getTotalCostWithShipping() {
        return price + getShippingCost();
    }


    // Getter and Setter
    public String getSku() {
        return sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public int getWeightInLbs() {
        return weightInLbs;
    }

    public void setWeightInLbs(int weight) {
        this.weightInLbs = weight;
    }

    public boolean isPerishable() {
        return isPerishable;
    }

    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public boolean isTaxable() {
        return isTaxable;
    }

    public void setTaxable(boolean taxable) {
        isTaxable = taxable;
    }

    public String getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && weightInLbs == product.weightInLbs && isPerishable == product.isPerishable && isTaxable == product.isTaxable && Objects.equals(productTypeCode, product.productTypeCode) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(sku, product.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productTypeCode, price, name, description, weightInLbs, sku, isPerishable, isTaxable);
    }
}
