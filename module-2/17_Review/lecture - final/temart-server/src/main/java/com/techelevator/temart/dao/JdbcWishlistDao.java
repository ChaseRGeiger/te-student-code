package com.techelevator.temart.dao;

import com.techelevator.temart.model.ProductWishlist;
import com.techelevator.temart.model.Wishlist;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcWishlistDao implements WishlistDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcWishlistDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Wishlist create(Wishlist wishlist) {
        String sql = "INSERT INTO wish_list (id, user_id, name, date_created) VALUES (DEFAULT, ?, ?, CURRENT_TIMESTAMP) RETURNING id";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, wishlist.getUserId(), wishlist.getName());
        wishlist.setId(id);
        return wishlist;
    }

    @Override
    public void addProductToWishList(ProductWishlist productWishlist) {
        String sql = "INSERT INTO product_wish_list (product_sku, wish_list_id, date_added) " +
                "VALUES (?, ?, CURRENT_TIMESTAMP)";
        jdbcTemplate.update(sql, productWishlist.getProductId(), productWishlist.getWishlistId());
    }

    @Override
    public boolean doesUserOwnWishlist(int userId, int wishlistId) {
        String sql = "SELECT * FROM wish_list WHERE user_id = ? AND id = ?";
        SqlRowSet rows  = jdbcTemplate.queryForRowSet(sql, userId, wishlistId);
        return rows.next();
    }

}
