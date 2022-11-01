package com.techelevator.temart.controller;


import com.techelevator.temart.dao.InventoryDao;
import com.techelevator.temart.dao.UserDao;
import com.techelevator.temart.dao.WishlistDao;
import com.techelevator.temart.model.Product;
import com.techelevator.temart.model.Wishlist;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@PreAuthorize("isAuthenticated()")
@RestController
public class WishlistController {

    private WishlistDao wishlistDao;
    private UserDao userDao;
    private InventoryDao inventoryDao;


    public WishlistController(WishlistDao wishlistDao, UserDao userDao) {
        this.wishlistDao = wishlistDao;
        this.userDao = userDao;
    }

    @PostMapping("/wishlists")
    public Wishlist create(@RequestBody Wishlist wishlist, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        wishlist.setUserId(userId);
        return wishlistDao.create(wishlist);
    }


    @PostMapping("/wishlists/{id}/products")
    public Product addProductToWishlist(@PathVariable int id, String sku, Principal principal){

        Product product = inventoryDao.getProductBySku(sku);
        if(verifyUserWishlist(id, principal)){
            return product;
        }
        else{
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Current Wishlist ID doesn't match");
        }

    }

    private boolean verifyUserWishlist(int id, Principal principal){
        int usersId = userDao.findIdByUsername(principal.getName());

        if(id == usersId){
            return true;
        }
        return false;
    }
}
