package com.techelevator.temart.products;

public class HomeGood extends Product implements Taxable{

    public HomeGood(String sku){
        super(sku);
    }

    public HomeGood(String sku, String name, double price, String description, int weightInLbs){
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
