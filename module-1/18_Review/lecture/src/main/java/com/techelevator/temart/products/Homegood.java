package com.techelevator.temart.products;

public class Homegood extends Product implements Taxable {

    public Homegood(String sku) {
        super(sku);
        super.setTaxable(true);
    }
    public Homegood (String sku, String name, double price, String description, int weightInLbs) {
        super (sku, name, price, description, weightInLbs);
        super.setTaxable(true);
    }

    @Override
    public String getProductType() {
        return "Home Goods";
    }

    @Override
    public double getTaxRate() {
        return 0.07;
    }

    @Override
    public double getTaxAmount() {
        return getPrice() * getTaxRate();
    }

    @Override
    public double getTotalCostWithShipping() {
        return super.getTotalCostWithShipping() + getTaxAmount();
    }
}
