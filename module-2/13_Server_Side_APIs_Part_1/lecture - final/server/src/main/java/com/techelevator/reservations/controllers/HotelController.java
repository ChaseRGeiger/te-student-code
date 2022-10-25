package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */


    /**
     * Return hotel information
     *
     * @param id (Path) the id of the hotel
     * @return all info for a given hotel
     */


    /**
     * Return All Reservations
     *
     * @return a list of all reservations in the system
     */


    /**
     * Return Reservation details
     *
     * @param id (Path) the id of the reservation
     * @return return the details for a given reservation
     */


    /**
     * Return All Reservation for a given hotel
     *
     * @param id (Path) the id of the hotel
     * @return return the details for a given reservation
     */


    /**
     * Add a reservation to a given hotel
     *
     * @param id (Path) the id of the hotel
     * @param reservation (RequestBody) the details of the new reservation
     * @return return the details for a given reservation
     */


}
