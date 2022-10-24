package com.techelevator.auctions.services;

import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions/";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction[] getAllAuctions() {
        // call api here
        String url = API_BASE_URL;
        Auction[] auctions = restTemplate.getForObject(url, Auction[].class);
        return auctions;
    }

    public Auction getAuction(int id) {
        // call api here
        String url = API_BASE_URL + id;
        Auction auction = restTemplate.getForObject(url, Auction.class);
        return auction;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        // call api here
        String url = API_BASE_URL + "?title_like=" + title;
        Auction[] auctions = restTemplate.getForObject(url, Auction[].class);
        return auctions;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        // call api here
        String url = API_BASE_URL + "?currentBid_lte=" + price;
        Auction[] auctions = restTemplate.getForObject(url, Auction[].class);
        return auctions;
    }

}
