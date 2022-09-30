package com.techelevator.temart.products;

public class Electronic extends Product implements Taxable{

    public Electronic(String sku){
        super(sku);
    }

    public Electronic(String sku, String name, double price, String description, int weightInLbs){
        super(sku, name, price, description, weightInLbs);
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
    public double getTotalCostWithShipping(){
        return super.getTotalCostWithShipping() + getTaxAmount();
    }
}
