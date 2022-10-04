package com.techelevator.temart.products;

public class Clothing extends Product implements Taxable {

    private double taxRate;


    public Clothing(String sku, double taxRate) {
        super(sku);
        this.taxRate = taxRate;
        super.setTaxable(true);
    }

    public Clothing (String sku, String name, double price, String description, int weightInLbs, double taxRate) {
        super (sku, name, price, description, weightInLbs);
        this.taxRate = taxRate;
        super.setTaxable(true);
    }

    @Override
    public double getShippingCost() {
        double cost = super.getShippingCost();
        return cost * .75;
    }

    public String getProductType() {
        return "Clothing";
    }

    @Override
    public double getTaxRate() {
        return taxRate;
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
