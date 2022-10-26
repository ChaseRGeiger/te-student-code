package com.techelevator.auctions.services;

import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions/";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction add(Auction newAuction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Auction> requestEntity = new HttpEntity<Auction>(newAuction, headers);

        Auction returnedAuction = null;

        try{
            returnedAuction = restTemplate.postForObject(API_BASE_URL, requestEntity, Auction.class);
        } catch (ResourceAccessException e){
            BasicLogger.log(e.getMessage());
        } catch (RestClientResponseException e){
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        }
        return returnedAuction;
    }

    public boolean update(Auction updatedAuction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Auction> requestEntity = new HttpEntity<Auction>(updatedAuction, headers);

        try {
            restTemplate.put(API_BASE_URL + updatedAuction.getId(), requestEntity);
            return true;
        } catch (ResourceAccessException e){
            BasicLogger.log(e.getMessage());
        } catch (RestClientResponseException e){
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        }
        return false;
    }

    public boolean delete(int auctionId) {
        try {
            restTemplate.delete(API_BASE_URL + auctionId);
            return true;
        } catch (ResourceAccessException e){
            BasicLogger.log(e.getMessage());
        } catch (RestClientResponseException e){
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        }
        return false;
    }

    public Auction[] getAllAuctions() {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction getAuction(int id) {
        Auction auction = null;
        try {
            auction = restTemplate.getForObject(API_BASE_URL + id, Auction.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auction;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?title_like=" + title, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?currentBid_lte=" + price, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    private HttpEntity<Auction> makeEntity(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(auction, headers);
    }

}
