package com.techelevator.temart.model;

public class Wishlist {

    private String name;

    public Wishlist(){

    }

    public Wishlist(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
