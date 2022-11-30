package com.techelevator.reviews.dao;

import com.techelevator.reviews.model.Review;

import java.util.List;

public interface ReviewsDao {

    List<Review> listByProductId(long productId);
    Review getById(long reviewId);
    Review add(Review review, long productId);
    Review update(Review review);
    void delete(long reviewId);
}
