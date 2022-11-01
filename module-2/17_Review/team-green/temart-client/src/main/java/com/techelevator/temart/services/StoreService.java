package com.techelevator.temart.services;

import com.techelevator.temart.model.AuthenticatedUser;
import com.techelevator.temart.model.Product;
import com.techelevator.temart.model.Wishlist;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class StoreService {

    private String baseApiUrl;
    private AuthenticatedUser currentUser;
    public StoreService(String baseApiUrl) {
        this.baseApiUrl = baseApiUrl;
    }

    RestTemplate restTemplate = new RestTemplate();

    public void setCurrentUser(AuthenticatedUser currentUser) {
        this.currentUser = currentUser;
    }

    /*
            The only connection between the client and the server is the
            endpoint (/products) and the web method (GET) and JSON request/response
         */
    public List<Product> getAllProducts() {
        String url = baseApiUrl + "products";
        /*
            2) Makes an HTTP Request to the API Server to get all the products
         */
        Product[] products = restTemplate.getForObject(url, Product[].class);
        /*
            6) The client receives the JSON response from the server and deserializes
               the JSON into an array of Products.
               The Array is then converted into a List<Product> and returned
         */
        return List.of(products);
    }

    public Wishlist addNewWishlist(String wishlistName) {
        Wishlist returnedWishlist = null;

        String url = baseApiUrl + "wishlists";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(currentUser.getToken());
        HttpEntity<Wishlist> requestEntity = new HttpEntity<Wishlist>(
                new Wishlist(wishlistName), headers);

        ResponseEntity<Wishlist> response = restTemplate.exchange(url, HttpMethod.POST,
                requestEntity, Wishlist.class);

        returnedWishlist = response.getBody();

        return returnedWishlist;
    }

    public Wishlist[] getWishlists() {
        Wishlist[] returnedWishlist = null;
        String url = baseApiUrl + "wishlists";
        HttpHeaders headers = new HttpHeaders();
       // headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(currentUser.getToken() );
        HttpEntity<Void> entityWithNoMessageBody=new HttpEntity<>(headers);
        ResponseEntity<Wishlist[]> response = restTemplate.exchange(url, HttpMethod.GET,entityWithNoMessageBody, Wishlist[].class );

        returnedWishlist = response.getBody();
        return returnedWishlist;
    }

    public String addProductToWishlist(String productSku, int wishlistId) {
        String returnSku= null;
        String url = baseApiUrl + "wishlists/" + wishlistId + "/products";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(currentUser.getToken());
        HttpEntity<String> requestEntity = new HttpEntity<String>(productSku, headers);
        ResponseEntity<Product> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Product.class);
        returnSku = response.toString();

        return returnSku;
    }

}
