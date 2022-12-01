package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    private int id;
    private String category;
    private String name;
    @JsonProperty("image_name")
    private String imageName;
    private int rating;
    @JsonProperty("is_top_seller")
    private boolean topSeller;
    private int quantity;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isTopSeller() {
        return topSeller;
    }

    public void setTopSeller(boolean topSeller) {
        this.topSeller = topSeller;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
