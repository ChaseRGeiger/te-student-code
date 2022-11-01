package com.techelevator.temart.model;

public class ProductWishlist {

    private String productId;
    private int wishlistId;

    public ProductWishlist() {

    }

    public ProductWishlist(String productId, int wishlistId) {
        this.productId = productId;
        this.wishlistId = wishlistId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }
}
