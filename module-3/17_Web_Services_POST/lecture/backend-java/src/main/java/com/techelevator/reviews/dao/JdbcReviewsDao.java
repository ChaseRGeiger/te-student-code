package com.techelevator.reviews.dao;

import com.techelevator.reviews.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReviewsDao implements ReviewsDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcReviewsDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Review> listByProductId(long productId) {
        List<Review> reviews = new ArrayList<Review>();
        String sql = "SELECT id, product_id, reviewer, title, review, rating, favorited FROM reviews WHERE product_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, productId);
        while(rows.next()) {
            reviews.add( mapRowToReview(rows) );
        }
        return reviews;
    }


    @Override
    public Review getById(long reviewId) {
        Review review = null;
        String sql = "SELECT id, product_id, reviewer, title, review, rating, favorited FROM reviews WHERE id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, reviewId);
        if (rows.next()) {
            review = mapRowToReview(rows);
        }
        return review;
    }

    @Override
    public Review add(Review review, long productId) {
        String sql = "INSERT INTO reviews (product_id, reviewer, title, review, rating, favorited) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING id";
        Long reviewId = jdbcTemplate.queryForObject(sql, Long.class, productId, review.getReviewer(), review.getTitle(),
                review.getReview(), review.getRating(), review.isFavorited());
        review.setId(reviewId);
        review.setProductId(productId);
        return review;
    }

    @Override
    public Review update(Review review) {
        String sql = "UPDATE reviews " +
                "SET reviewer = ?, title = ?, review = ?, rating = ?, favorited = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql, review.getReviewer(), review.getTitle(), review.getReview(),
                review.getRating(), review.isFavorited(), review.getId());
        return getById(review.getId());
    }

    @Override
    public void delete(long reviewId) {
        String sql = "DELETE FROM reviews WHERE id = ?";
        jdbcTemplate.update(sql, reviewId);
    }

    private Review mapRowToReview(SqlRowSet row) {
        Review review = new Review();
        review.setId(row.getLong("id"));
        review.setProductId(row.getLong("product_id"));
        review.setReviewer(row.getString("reviewer"));
        review.setTitle(row.getString("title"));
        review.setReview(row.getString("review"));
        review.setRating(row.getInt("rating"));
        review.setFavorited(row.getBoolean("favorited"));
        return review;
    }
}
