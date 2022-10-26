package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * List all hotels in the system
     */
    public Hotel[] listHotels() {
        Hotel[] hotels = null;

        String url = API_BASE_URL + "hotels";

        try {
            hotels = restTemplate.getForObject(url, Hotel[].class);
        } catch (RestClientResponseException e) {
            // Is thrown when the server responds with a 4xx or 5xx status code
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            // Unable to connect to the server
            BasicLogger.log(e.getMessage());
        }
        return hotels;
    }

    /**
     * Create a new reservation in the hotel reservation system
     */
    public Reservation addReservation(Reservation newReservation) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Reservation> requestEntity = new HttpEntity<Reservation>(newReservation, headers);

        Reservation returnedReservation = null;

        try {
            returnedReservation = restTemplate.postForObject(API_BASE_URL + "reservations",
                    requestEntity, Reservation.class);
        } catch (ResourceAccessException e) {
            // Occurs when the server cannot be reached (connection error)
            BasicLogger.log( e.getMessage() );
        } catch (RestClientResponseException e) {
            BasicLogger.log( e.getRawStatusCode() + " : " + e.getStatusText() );
        }

        return returnedReservation;
    }

    /**
     * Updates an existing reservation by replacing the old one with a new
     * reservation
     */
    public boolean updateReservation(Reservation updatedReservation) {
        // 1. Set the Content-Type Header to application JSON
        // 2. Set the message body to be serialized from the Reservation object
        // 3. Build the URL with the reservation id - http://localhost:3000/reservations/707
        // 4. Send the PUT request
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Reservation> updateEntity = new HttpEntity<Reservation>(updatedReservation, httpHeaders);

        String url = API_BASE_URL + "reservations/" + updatedReservation.getId();

        try {
            restTemplate.put(url, updateEntity);
            return true;
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return false;
    }

    /**
     * Delete an existing reservation
     */
    public boolean deleteReservation(int id) {
        String url = API_BASE_URL + "reservations/" + id;
        try {
            restTemplate.delete(url);
            return true;
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return false;
    }


    /* DON'T MODIFY ANY METHODS BELOW */

    /**
     * List all reservations in the hotel reservation system
     */
    public Reservation[] listReservations() {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * List all reservations by hotel id.
     */
    public Reservation[] listReservationsByHotel(int hotelId) {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
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
            reservation = restTemplate.getForObject(API_BASE_URL + "reservations/" + reservationId, Reservation.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservation;
    }

}