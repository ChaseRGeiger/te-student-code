package com.techelevator.chucknorris;

import org.springframework.web.client.RestTemplate;

public class JokeApp {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.chucknorris.io/jokes/random?category=dev";
        ApiResponse response = restTemplate.getForObject(url, ApiResponse.class);

        System.out.println(response.getValue());
        System.out.println();
        System.out.println("URL: " + response.getUrl());
    }
}
