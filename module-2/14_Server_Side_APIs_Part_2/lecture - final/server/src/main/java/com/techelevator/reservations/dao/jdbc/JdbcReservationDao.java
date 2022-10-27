package com.techelevator.reservations.dao.jdbc;

import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


public class JdbcReservationDao implements ReservationDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcReservationDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Reservation> findAll() {
        List<Reservation> reservations = new ArrayList<Reservation>();
        String sql = "SELECT id, hotel_id, fullname, checkin_date, checkout_date, guests FROM reservation";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while (rows.next()) {
            reservations.add( mapRowToReservation(rows) );
        }
        return reservations;
    }

    @Override
    public List<Reservation> findByHotel(int hotelID) {
        List<Reservation> reservations = new ArrayList<Reservation>();
        String sql = "SELECT id, hotel_id, fullname, checkin_date, checkout_date, guests FROM reservation WHERE hotel_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, hotelID);
        while (rows.next()) {
            reservations.add( mapRowToReservation(rows) );
        }
        return reservations;
    }

    @Override
    public Reservation get(int reservationID) {
        Reservation reservation = null;
        String sql = "SELECT id, hotel_id, fullname, checkin_date, checkout_date, guests FROM reservation WHERE id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, reservationID);
        if (rows.next()) {
            reservation = mapRowToReservation(rows);
        }
        return reservation;
    }

    @Override
    public Reservation create(Reservation reservation, int hotelID) {
        String sql = "INSERT INTO reservation (hotel_id, fullname, checkin_date, checkout_date, guests) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING id";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, hotelID, reservation.getFullName(),
                reservation.getCheckinDate(), reservation.getCheckoutDate(), reservation.getGuests());
        reservation.setId(id);
        return reservation;
    }

    @Override
    public Reservation update(Reservation reservation, int id) {
        String sql = "UPDATE reservation " +
                "SET fullname = ?, checkin_date = ?, checkout_date = ?, guests = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql, reservation.getFullName(), reservation.getCheckinDate(), reservation.getCheckoutDate(),
                reservation.getGuests(), id);
        return get(id);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM reservation WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


    private Reservation mapRowToReservation(SqlRowSet row) {
        Reservation reservation = new Reservation();
        reservation.setId( row.getInt("id"));
        reservation.setHotelID( row.getInt("hotel_id"));
        reservation.setFullName( row.getString("fullname"));
        reservation.setCheckinDate(row.getString("checkin_date"));
        reservation.setCheckoutDate(row.getString("checkout_date"));
        reservation.setGuests(row.getInt("guests"));
        return reservation;
    }
}
