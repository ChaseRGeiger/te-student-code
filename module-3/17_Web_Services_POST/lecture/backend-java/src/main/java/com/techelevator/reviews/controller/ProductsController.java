package com.techelevator.reviews.controller;

import com.techelevator.reviews.dao.ProductsDao;
import com.techelevator.reviews.dao.ReviewsDao;
import com.techelevator.reviews.model.Product;
import com.techelevator.reviews.model.Review;
import com.techelevator.reviews.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ProductsController {

    private ProductService productService;

    private ProductsDao productsDao;
    private ReviewsDao reviewsDao;

    public ProductsController(ProductsDao productsDao, ReviewsDao reviewsDao, ProductService productService) {
        this.productsDao = productsDao;
        this.reviewsDao = reviewsDao;

        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> listProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable long id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
        }
        return product;
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        return productsDao.add(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody Product product) {
        if (id != product.getId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Product not for requested id");
        }
        verifyProductExists(product.getId());
        return productsDao.update(product);
    }


    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable long id) {
        verifyProductExists(id);
        productsDao.delete(id);
    }

    @GetMapping("/products/{id}/reviews")
    public List<Review> listReviewsForProduct(@PathVariable("id") long productId) {
        verifyProductExists(productId);
        return reviewsDao.listByProductId(productId);
    }

    @GetMapping("/reviews/{id}")
    public Review getReview(@PathVariable("id") long reviewId) {
        Review review = reviewsDao.getById(reviewId);
        if (review == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review Not Found");
        }
        return reviewsDao.getById(reviewId);
    }

    @PostMapping("/products/{id}/reviews")
    @ResponseStatus(HttpStatus.CREATED)
    public Review addReviewToProduct(@PathVariable("id") long productId, @RequestBody Review review) {
        verifyProductExists(productId);
        return reviewsDao.add(review, productId);
    }

    @PutMapping("/reviews/{id}")
    public Review updateReview(@PathVariable("id") long reviewId, @RequestBody Review review) {
        if (reviewId != review.getId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Review not for requested id");
        }
        verifyReviewExists(review.getId());
        return reviewsDao.update(review);
    }

    @DeleteMapping("/reviews/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable("id") long reviewId) {
        verifyReviewExists(reviewId);
        reviewsDao.delete(reviewId);
    }


    private void verifyReviewExists(long reviewId) {
        if (reviewsDao.getById(reviewId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review Not Found");
        }
    }

    private void verifyProductExists(long productId) {
        if (productsDao.getById(productId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
        }
    }
}
