package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();

    private String authToken = null;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     * List all reservations in the hotel reservation system
     */
    public Reservation[] listReservations() {
        Reservation[] reservations = null;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        HttpEntity<Void> entityWithNoMessageBody = new HttpEntity<Void>(headers);
        try {
            /*
                Exchange returns a ResponseEntity with the body being set to the expected return type

                exchange( url, httpMethod, httpEntity, class to deserialize the response as )
             */
            ResponseEntity<Reservation[]> responseEntity = restTemplate.exchange(API_BASE_URL + "reservations",
                    HttpMethod.GET, entityWithNoMessageBody, Reservation[].class);
            /*
                getBody() retrieves the deserialized response object from the ResponseEntity
             */
            reservations = responseEntity.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * Create a new reservation in the hotel reservation system
     */
    public Reservation addReservation(Reservation newReservation) {
        Reservation returnedReservation = null;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        HttpEntity<Reservation> entityWithMessageBody = new HttpEntity<Reservation>(newReservation, headers);

        ResponseEntity<Reservation> response = restTemplate.exchange(API_BASE_URL + "reservations", HttpMethod.POST,
                entityWithMessageBody, Reservation.class);

        returnedReservation = response.getBody();

        return returnedReservation;
    }

    
    /**
     * Updates an existing reservation by replacing the old one with a new reservation
     */
    public boolean updateReservation(Reservation updatedReservation) {
        boolean success = false;
        try {
            restTemplate.put(API_BASE_URL + "reservations/" + updatedReservation.getId(),
                    makeReservationEntity(updatedReservation));
            success = true;
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return success;
    }

    /**
     * Delete an existing reservation
     */
    public boolean deleteReservation(int id) {
        boolean success = false;
        try {
            restTemplate.exchange(API_BASE_URL + "reservations/" + id, HttpMethod.DELETE,
                    makeAuthEntity(), Void.class);
            success = true;
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return success;
    }

    /**
     * List all hotels in the system
     */
    public Hotel[] listHotels() {
        Hotel[] hotels = null;
        try {
            ResponseEntity<Hotel[]> response = restTemplate.exchange(API_BASE_URL + "hotels", HttpMethod.GET,
                            makeAuthEntity(), Hotel[].class);
            hotels = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return hotels;
    }


    /**
     * List all reservations by hotel id.
     */
    public Reservation[] listReservationsByHotel(int hotelId) {
        Reservation[] reservations = null;
        try {
            ResponseEntity<Reservation[]> response =
                    restTemplate.exchange(API_BASE_URL + "hotels/" + hotelId + "/reservations",
                            HttpMethod.GET, makeAuthEntity(), Reservation[].class);
            reservations = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * Find a single reservation by the reservationId
     */
    public Reservation getReservation(int reservationId) {
        Reservation reservation = null;
        try {
            ResponseEntity<Reservation> response =
                    restTemplate.exchange(API_BASE_URL + "reservations/" + reservationId,
                            HttpMethod.GET, makeAuthEntity(), Reservation.class);
            reservation = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservation;
    }

    /**
     * Creates a new HttpEntity with the `Authorization: Bearer:` header and a reservation request body
     */
    private HttpEntity<Reservation> makeReservationEntity(Reservation reservation) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(reservation, headers);
    }

    /**
     * Returns an HttpEntity with the `Authorization: Bearer:` header
     */
    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }

}
