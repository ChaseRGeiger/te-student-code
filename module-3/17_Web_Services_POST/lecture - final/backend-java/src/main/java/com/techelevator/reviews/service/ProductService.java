package com.techelevator.reviews.service;

import com.techelevator.reviews.dao.ProductsDao;
import com.techelevator.reviews.dao.ReviewsDao;
import com.techelevator.reviews.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    private ProductsDao productsDao;
    private ReviewsDao reviewsDao;

    public ProductService(ProductsDao productsDao, ReviewsDao reviewsDao) {
        this.productsDao = productsDao;
        this.reviewsDao = reviewsDao;
    }

    public List<Product> getAllProducts() {
        List<Product> products = productsDao.list();
        for (Product product : products) {
            product.setReviews( reviewsDao.listByProductId(product.getId()) );
        }
        return products;
    }

    public Product getProductById(long productId) {
        Product product = productsDao.getById(productId);
        if (product != null) {
            product.setReviews(reviewsDao.listByProductId(productId) );
        }
        try {
            // This creates a "fake delay" before the API returns to simulate a remote API.
            Thread.sleep(750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return product;
    }
}
