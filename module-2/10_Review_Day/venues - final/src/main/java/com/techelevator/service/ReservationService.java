package com.techelevator.service;

import com.techelevator.dao.JdbcVenueDao;
import com.techelevator.dao.VenueDao;
import com.techelevator.dao.model.Venue;

import javax.sql.DataSource;
import java.util.List;

public class ReservationService {

    private VenueDao venueDao;

    public ReservationService(DataSource dataSource) {
        venueDao = new JdbcVenueDao(dataSource);
    }

    public List<Venue> getListOfVenues() {
        return venueDao.getAllVenues();
    }

    public Venue getVenueById(int venueId) {
        return venueDao.getVenueById(venueId);
    }
}
