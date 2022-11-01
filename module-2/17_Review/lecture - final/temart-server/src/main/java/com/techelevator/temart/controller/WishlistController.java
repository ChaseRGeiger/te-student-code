package com.techelevator.temart.controller;

import com.techelevator.temart.dao.UserDao;
import com.techelevator.temart.dao.WishlistDao;
import com.techelevator.temart.model.Wishlist;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
