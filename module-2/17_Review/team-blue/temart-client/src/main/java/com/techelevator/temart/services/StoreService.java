package com.techelevator.temart.services;

import com.techelevator.temart.model.Product;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class StoreService {

    private String baseApiUrl;

    public StoreService(String baseApiUrl) {
        this.baseApiUrl = baseApiUrl;
    }

    RestTemplate restTemplate = new RestTemplate();

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

}
