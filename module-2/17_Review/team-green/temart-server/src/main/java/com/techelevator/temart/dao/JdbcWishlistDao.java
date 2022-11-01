package com.techelevator.temart.dao;

import com.techelevator.temart.model.Wishlist;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcWishlistDao implements WishlistDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcWishlistDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Wishlist create(Wishlist wishlist) {
        String sql = "INSERT INTO wish_list(id, user_id, name, date_created) " +
                "VALUES (DEFAULT, ?, ?, CURRENT_DATE) RETURNING id";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, wishlist.getUserId(), wishlist.getName());
        wishlist.setId(id);
        return wishlist;
    }

}


