package com.techelevator;

public class FlowerShopOrder {

    private String bouquet;
    private int numOfRoses;


    public FlowerShopOrder(String bouquet, int numOfRoses){
        this.bouquet = bouquet;
        this.numOfRoses = numOfRoses;
    }

    public FlowerShopOrder(){

    }

    public String getBouquet() {
        return bouquet;
    }

    public int getNumOfRoses() {
        return numOfRoses;
    }

    public void setBouquet(String bouquet) {
        this.bouquet = bouquet;
    }

    public void setNumOfRoses(int numOfRoses) {
        this.numOfRoses = numOfRoses;
    }

    public double subtotal(){
        return 19.99 + (numOfRoses * 2.99);
    }

    public double deliveryTotal(boolean sameDayDelivery, String zipCode){
        int zipCodeAsInt = Integer.parseInt(zipCode);
        double deliveryFee = 0.0;
        if(sameDayDelivery) {
           deliveryFee += 5.99;
        }
        if(zipCodeAsInt >= 20000 && zipCodeAsInt <= 29999){
                deliveryFee += 3.99;
        }
        if(zipCodeAsInt >= 30000 && zipCodeAsInt <= 39999){
                deliveryFee += 6.99;
        }
        if(zipCodeAsInt >= 10000 && zipCodeAsInt <= 19999){
            deliveryFee = 0;
        }

        return deliveryFee;
    }

    @Override
    public String toString(){
        return "Order - " + bouquet + " - " + numOfRoses + " roses - " + subtotal();
    }

}
