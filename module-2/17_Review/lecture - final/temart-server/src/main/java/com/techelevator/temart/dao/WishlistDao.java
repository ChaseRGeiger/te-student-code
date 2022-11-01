package com.techelevator.temart.dao;

import com.techelevator.temart.model.ProductWishlist;
import com.techelevator.temart.model.Wishlist;

public interface WishlistDao {

    Wishlist create(Wishlist wishlist);
    void addProductToWishList(ProductWishlist productWishlist);
    boolean doesUserOwnWishlist(int userId, int wishlistId);
}
