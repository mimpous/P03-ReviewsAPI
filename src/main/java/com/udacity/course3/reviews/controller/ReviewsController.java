package com.udacity.course3.reviews.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.udacity.course3.reviews.domain.Product;
import com.udacity.course3.reviews.domain.Review;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewsRepository;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {
 
	@Autowired
	ReviewsRepository reviewsRepository;

	@Autowired
	ProductRepository productRepository;
    /**
     * Creates a review for a product.
     * <p>
     * 1. Add argument for review entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of product.
     * 3. If product not found, return NOT_FOUND.
     * 4. If found, save review.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public @Valid Review createReviewForProduct(@Valid @RequestBody Review review , @PathVariable("productId") Integer productId) {
    
    	Product product = productRepository.findById( productId ).orElse(null);
        if ( product == null ) {
        	throw     
    	 	new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
        	review.setProduct(product); 
        	reviewsRepository.save(review); 
        	productRepository.save(product);
    		return review; 
        }
    	 
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public List<Review> listReviewsForProduct(@PathVariable("productId") Integer productId) {
 
    	Product product = productRepository.findById( productId ).get();
    	 return  product.getReviews();

    }
     
    
}