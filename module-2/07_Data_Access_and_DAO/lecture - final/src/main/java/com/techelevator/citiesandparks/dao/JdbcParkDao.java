package com.techelevator.citiesandparks.dao;

import com.techelevator.citiesandparks.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(int parkId) {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping FROM park WHERE park_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);

        if (results.next() ) {
            park = mapRowToPark(results);
        }

        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        List<Park> parks = new ArrayList<Park>();
        String sql = "SELECT park.park_id, park_name, date_established, area, has_camping FROM park " +
                "JOIN park_state ON park.park_id = park_state.park_id " +
                "WHERE park_state.state_abbreviation = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        while (results.next()) {
            parks.add( mapRowToPark(results) );
        }

        return parks;
    }

    @Override
    public Park createPark(Park park) {
        String sql = "INSERT INTO park (park_name, date_established, area, has_camping) " +
                "VALUES (?, ?, ?, ?) RETURNING park_id";
        int parkId = jdbcTemplate.queryForObject(sql, Integer.class, park.getParkName(), park.getDateEstablished(),
                park.getArea(), park.getHasCamping() );
        park.setParkId(parkId);
        return park;
    }

    @Override
    public void updatePark(Park park) {
        String sql = "UPDATE park " +
                " SET park_name=?, date_established=?, area=?, has_camping=?" +
                " WHERE park_id=?";
        jdbcTemplate.update(sql, park.getParkName(), park.getDateEstablished(), park.getArea(),
                park.getHasCamping(), park.getParkId());
    }

    @Override
    public void deletePark(int parkId) {
        // Must remove the park from all states before we can delete the park
        List<String> statesTheParkIsIn = getStateAbbreviationForPark(parkId);
        for (String stateAbbreviation : statesTheParkIsIn) {
            removeParkFromState(parkId, stateAbbreviation);
        }
        // Once it has been removed, delete the park
        String sql = "DELETE FROM park WHERE park_id = ?";
        jdbcTemplate.update(sql, parkId);
    }

    @Override
    public void addParkToState(int parkId, String stateAbbreviation) {
        String sql = "INSERT INTO park_state (park_id, state_abbreviation) VALUES (?,?)";
        jdbcTemplate.update(sql, parkId, stateAbbreviation);
    }

    @Override
    public void removeParkFromState(int parkId, String stateAbbreviation) {
        String sql = "DELETE FROM park_state WHERE park_id = ? AND state_abbreviation = ?";
        jdbcTemplate.update(sql, parkId, stateAbbreviation);
    }

    private List<String> getStateAbbreviationForPark(int parkId) {
        List<String> states = new ArrayList<String>();
        String sql = "SELECT state_abbreviation " +
                "FROM park " +
                "JOIN park_state ON park.park_id = park_state.park_id " +
                "WHERE park.park_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet( sql, parkId );
        while (results.next()) {
            states.add( results.getString("state_abbreviation") );
        }
        return states;
    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();

        park.setParkId( rowSet.getInt("park_id") );
        park.setParkName( rowSet.getString("park_name") );
        if (rowSet.getDate("date_established") != null) {
            park.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        }
        park.setArea( rowSet.getDouble("area") );
        park.setHasCamping( rowSet.getBoolean("has_camping") );

        return park;
    }
}
