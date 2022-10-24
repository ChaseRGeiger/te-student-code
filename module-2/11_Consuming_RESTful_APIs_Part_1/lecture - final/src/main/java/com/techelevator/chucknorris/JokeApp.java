package com.techelevator.chucknorris;

import org.springframework.web.client.RestTemplate;

public class JokeApp {

    public static void main(String[] args) {

        // STEP 0: Instantiate a RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // STEP 1: Build the URL as a String
        String url = "https://api.chucknorris.io/jokes/random?category=dev";

        // STEP 2: Call the API with the RestTemplate
        ApiResponse response = restTemplate.getForObject(url, ApiResponse.class);


        System.out.println(response.getValue());
        System.out.println();
        System.out.println("URL: " + response.getUrl());


    }
}
