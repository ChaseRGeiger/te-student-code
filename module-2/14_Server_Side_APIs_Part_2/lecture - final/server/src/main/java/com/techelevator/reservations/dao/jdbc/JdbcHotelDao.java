package com.techelevator.reservations.dao.jdbc;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.model.Address;
import com.techelevator.reservations.model.Hotel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcHotelDao implements HotelDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcHotelDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Hotel> list() {
        List<Hotel> hotels = new ArrayList<Hotel>();
        String sql = "SELECT id, name, stars, rooms_available, cost_per_night FROM hotel";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while (rows.next()) {
            Hotel hotel = mapRowToHotel(rows);
            hotel.setAddress( getAddressForHotel(hotel.getId()));
            hotels.add(hotel);
        }
        return hotels;
    }


    @Override
    public Hotel get(int id) {
        Hotel hotel = null;
        String sql = "SELECT id, name, stars, rooms_available, cost_per_night FROM hotel WHERE id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, id);
        if (rows.next()) {
            hotel = mapRowToHotel(rows);
            hotel.setAddress( getAddressForHotel(hotel.getId()));
        }
        return hotel;
    }

    @Override
    public void create(Hotel hotel) {
        String sql = "INSERT INTO hotel (name, stars, rooms_available, cost_per_night) " +
                "VALUES (?, ?, ?, 2?) RETURNING id";
        Integer hotelId = jdbcTemplate.queryForObject(sql, Integer.class, hotel.getName(),
                hotel.getStars(), hotel.getRoomsAvailable(), hotel.getCostPerNight());
        hotel.setId(hotelId);
    }

    private Address getAddressForHotel(int hotelId) {
        Address address = null;

        String sql = "SELECT id, address, address2, city, state, zip FROM address WHERE hotel_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, hotelId);
        if (rows.next()) {
            address = new Address();
            address.setId( rows.getString("id") );
            address.setAddress( rows.getString("address"));
            address.setAddress2(rows.getString("address2"));
            address.setCity(rows.getString("city"));
            address.setState(rows.getString("state"));
            address.setZip(rows.getString("zip"));
        }


        return address;
    }


    private Hotel mapRowToHotel(SqlRowSet row) {
        Hotel hotel = new Hotel();
        hotel.setId( row.getInt("id"));
        hotel.setName(row.getString("name"));
        hotel.setStars(row.getInt("stars"));
        hotel.setRoomsAvailable(row.getInt("rooms_available"));
        hotel.setCostPerNight(row.getDouble("cost_per_night"));

        return hotel;
    }

}
