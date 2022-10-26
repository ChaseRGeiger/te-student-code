package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
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

    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> listAllHotels(@RequestParam(required = false) String state,
                                     @RequestParam(required = false) String city,
                                     @RequestParam(required = false, defaultValue = "1") int availableRooms){
        List<Hotel> hotels = hotelDao.list();

        if(state == null && city == null && availableRooms == 0){
            return hotels;
        }

        List<Hotel> filteredHotels = new ArrayList<Hotel>();

        if(availableRooms != 0){
            for(Hotel hotel : hotels){
                if(hotel.getRoomsAvailable() >= availableRooms){
                    filteredHotels.add(hotel);
                }
            }
            return filteredHotels;
        }

        for(Hotel hotel : hotels){
            if(city != null){
                if(hotel.getAddress().getCity().equalsIgnoreCase(city)){
                    filteredHotels.add(hotel);
                }
            }
            else {
                if(hotel.getAddress().getState().equalsIgnoreCase(state)){
                    filteredHotels.add(hotel);
                }
            }
        }

        return filteredHotels;
    }



    /**
     * Return hotel information
     *
     * @param id (Path) the id of the hotel
     * @return all info for a given hotel
     */

    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel getHotel(@PathVariable int id){
        return hotelDao.get(id);
    }


    /**
     * Return All Reservations
     *
     * @return a list of all reservations in the system
     */

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> listAllReservations(){
        List<Reservation> reservations = reservationDao.findAll();
        return reservations;
    }


    /**
     * Return Reservation details
     *
     * @param id (Path) the id of the reservation
     * @return return the details for a given reservation
     */

    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable int id){
        return reservationDao.get(id);
    }


    /**
     * Return All Reservation for a given hotel
     *
     * @param id (Path) the id of the hotel
     * @return return the details for a given reservation
     */

    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservationsFromHotel(@PathVariable int id){
        return reservationDao.findByHotel(id);
    }

    /**
     * Add a reservation to a given hotel
     *
     * @param id (Path) the id of the hotel
     * @param reservation (RequestBody) the details of the new reservation
     * @return return the details for a given reservation
     */

    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.POST)
    public Reservation addReservation(@RequestBody Reservation reservation, @PathVariable int id){
        return reservationDao.create(reservation, id);
    }



}
