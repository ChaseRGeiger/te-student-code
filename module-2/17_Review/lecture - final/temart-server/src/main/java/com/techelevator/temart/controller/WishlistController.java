package com.techelevator.temart.controller;

import com.techelevator.temart.dao.UserDao;
import com.techelevator.temart.dao.WishlistDao;
import com.techelevator.temart.model.ProductWishlist;
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

    public WishlistController(WishlistDao wishlistDao, UserDao userDao) {
        this.wishlistDao = wishlistDao;
        this.userDao = userDao;
    }

    @RequestMapping(path="/wishlists", method= RequestMethod.POST)
    public Wishlist create(@RequestBody Wishlist wishlist, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName() );
        wishlist.setUserId( userId );
        return wishlistDao.create( wishlist );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/wishlists/{id}/products", method= RequestMethod.POST)
    public void addProductToWishlist(@RequestBody ProductWishlist productWishlist,
                                     @PathVariable int id, Principal principal) {
        int userId = userDao.findIdByUsername( principal.getName() );
        if (!wishlistDao.doesUserOwnWishlist(userId, productWishlist.getWishlistId())
                || id != productWishlist.getWishlistId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access to wishlist denied");
        }
        wishlistDao.addProductToWishList(productWishlist);
    }

}
