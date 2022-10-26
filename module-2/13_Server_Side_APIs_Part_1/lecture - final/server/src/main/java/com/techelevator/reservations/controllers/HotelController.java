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
    @RequestMapping(path="/hotels", method=RequestMethod.GET)
    public List<Hotel> listAllHotels(@RequestParam(required=false) String state,
                                     @RequestParam(required=false) String city,
                                     @RequestParam(required=false, defaultValue="0") int availableRooms) {
        List<Hotel> hotels = hotelDao.list();

        if (state == null && city == null && availableRooms == 0) {
            return hotels;
        }

        List<Hotel> filteredHotels = new ArrayList<Hotel>();

        /*
            For simplicity of the example the filters only filter on 1 thing, even if all are present.  If
            availableRooms is present then it filters only on that.  If availableRooms is not and city is present then
            it filters only on city.  If both availableRooms and city are not included, then it filters on state.
         */
        // If availableRooms has a value, filter only on available rooms
        if (availableRooms != 0) {
            for (Hotel hotel : hotels) {
                if (hotel.getRoomsAvailable() >= availableRooms) {
                    filteredHotels.add(hotel);
                }
            }
            return filteredHotels;
        }

        for (Hotel hotel : hotels) {
            if (city != null) {
                if ( hotel.getAddress().getCity().equalsIgnoreCase( city ) ) {
                    filteredHotels.add(hotel);
                }
            } else {
                if (hotel.getAddress().getState().equalsIgnoreCase( state ) ) {
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
    @RequestMapping(path="/hotels/{id}", method=RequestMethod.GET)
    public Hotel getHotel(@PathVariable int id) {
        return hotelDao.get( id );
    }

    /**
     * Return All Reservations
     *
     * @return a list of all reservations in the system
     */
    @RequestMapping(path="/reservations", method=RequestMethod.GET)
    public List<Reservation> getAllReservations() {
        return reservationDao.findAll();
    }

    /**
     * Return Reservation details
     *
     * @param reservationId (Path) the id of the reservation
     * @return return the details for a given reservation
     */
    @RequestMapping(path="/reservations/{reservationId}", method=RequestMethod.GET)
    public Reservation getReservation(@PathVariable int reservationId) {
        return reservationDao.get( reservationId );
    }

    /**
     * Return All Reservation for a given hotel
     *
     * @param hotelId (Path) the id of the hotel
     * @return return the details for a given reservation
     */
    @RequestMapping(path="/hotels/{id}/reservations", method=RequestMethod.GET)
    public List<Reservation> getReservationsForHotel(@PathVariable(name="id") int hotelId) {
        return reservationDao.findByHotel(hotelId);
    }

    /**
     * Add a reservation to a given hotel
     *
     * @param id (Path) the id of the hotel
     * @param reservation (RequestBody) the details of the new reservation
     * @return return the details for a given reservation
     */
    @RequestMapping(path="/hotels/{id}/reservations", method=RequestMethod.POST)
    public Reservation addNewReservation(@PathVariable int id, @RequestBody Reservation reservation) {
        return reservationDao.create(reservation, id);
    }

}
