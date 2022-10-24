package com.techelevator.dao;

import com.techelevator.dao.model.State;
import com.techelevator.dao.model.Venue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcVenueDao implements VenueDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcVenueDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    public List<Venue> getAllVenues() {
        List<Venue> venues = new ArrayList<Venue>();

        String sql = "SELECT venue.id, venue.name AS venue_name, city.name AS city_name, venue.description, state.name AS state_name, " +
                "state.abbreviation FROM venue " +
                "JOIN city ON venue.city_id = city.id " +
                "JOIN state ON city.state_abbreviation = state.abbreviation " +
                "ORDER BY venue.id";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            Venue venue = mapRowToVenue(results);
            venue.setCategories(getCategoriesForVenue(venue.getId()));
            venues.add(venue);
        }
        return venues;
    }

    private List<String> getCategoriesForVenue(long venueId){
        List<String> categories = new ArrayList<String>();
        String sql = "SELECT category.name FROM venue " +
                "JOIN category_venue ON venue.id = category_venue.venue_id " +
                "JOIN category ON category_venue.category_id = category.id " +
                "WHERE venue.id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, venueId);

        while (results.next()){
            categories.add(results.getString("name"));
        }

        return categories;
    }

    private Venue mapRowToVenue(SqlRowSet sqlRowSet){

        Venue venue = new Venue();
        venue.setId(sqlRowSet.getLong("id"));
        venue.setName(sqlRowSet.getString("venue_name"));
        venue.setDescription(sqlRowSet.getString("description"));
        venue.setCityName(sqlRowSet.getString("city_name"));

        State state = new State();
        state.setName(sqlRowSet.getString("state_name"));
        state.setAbbreviation(sqlRowSet.getString("abbreviation"));

        venue.setState(state);

        return venue;
    }



}