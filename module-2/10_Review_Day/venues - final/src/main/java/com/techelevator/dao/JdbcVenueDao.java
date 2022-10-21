package com.techelevator.dao;

import com.techelevator.dao.model.State;
import com.techelevator.dao.model.Venue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcVenueDao implements VenueDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcVenueDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Venue> getAllVenues() {
        List<Venue> venues = new ArrayList<Venue>();
        String sql = "SELECT venue.id, venue.name AS venue_name, city.name AS city_name, " +
                "venue.description, state.name AS state_name, state.abbreviation " +
                "FROM venue " +
                "JOIN city ON venue.city_id = city.id " +
                "JOIN state ON city.state_abbreviation = state.abbreviation " +
                "ORDER BY venue.id";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        while(rows.next()) {
            Venue venue = mapRowToVenue(rows);
            venue.setCategories( getCategoriesForVenue(venue.getId()) );
            venues.add( venue );
        }

        return venues;
    }

    private List<String> getCategoriesForVenue(long venueId) {
        List<String> categories = new ArrayList<String>();

        String sql = "SELECT category.name " +
                "FROM venue " +
                "JOIN category_venue ON venue.id = category_venue.venue_id " +
                "JOIN category ON category_venue.category_id = category.id " +
                "WHERE venue.id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, venueId);

        while(rows.next()) {
            categories.add( rows.getString("name") );
        }

        return categories;
    }

    private Venue mapRowToVenue(SqlRowSet rows) {
        Venue venue = new Venue();
        venue.setId( rows.getLong("id") );
        venue.setName( rows.getString("venue_name") );
        venue.setDescription( rows.getString("description") );
        venue.setCity( rows.getString("city_name") );

        State state = new State();
        state.setName( rows.getString("state_name") );
        state.setAbbreviation( rows.getString("abbreviation") );
        venue.setState( state );

        return venue;
    }
}
