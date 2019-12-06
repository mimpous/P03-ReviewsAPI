package com.udacity.course3.reviews.mongo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.udacity.course3.reviews.mongo.domain.ProductMongo;
import com.udacity.course3.reviews.mongo.domain.Review;
import com.udacity.course3.reviews.mongo.repository.ProductMongoRepository;
import com.udacity.course3.reviews.mongo.repository.ReviewsMongoRepository;
  

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsMongoController {
 
	@Autowired
	ReviewsMongoRepository reviewsRepository;

	@Autowired
	ProductMongoRepository productRepository;
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
    @RequestMapping(value = "/reviews/productsMongo/{productId}", method = RequestMethod.POST)
    public @Valid Review createReviewForProduct(@Valid @RequestBody Review review , @PathVariable("productId") Integer productId) {
    
    	ProductMongo product = productRepository.findById( productId ).orElse(null);
        if ( product == null ) {
        	throw     
    	 	new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else { 
        	review.setProductId( product.getProductId() );
        	product.addReview(review);
        	reviewsRepository.save( review ); 
    		return review; 
        }
    	 
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @RequestMapping(value = "/reviews/productsMongo/{productId}", method = RequestMethod.GET)
    public List<Review> listReviewsForProduct(@PathVariable("productId") Integer productId) {
 
    	ProductMongo product = productRepository.findById( productId ).get();
    	 return  product.getReviews();

    }
     
    
}