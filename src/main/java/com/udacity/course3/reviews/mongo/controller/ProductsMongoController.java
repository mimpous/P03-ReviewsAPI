package com.udacity.course3.reviews.mongo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udacity.course3.reviews.mongo.domain.ProductMongo;
import com.udacity.course3.reviews.mongo.repository.ProductMongoRepository;
import com.udacity.course3.reviews.mongo.repository.ReviewsMongoRepository; 

/**
 * Spring REST controller for working with product entity.
 */
@RestController
@RequestMapping("/productsMongo")
public class ProductsMongoController {
	 
		@Autowired
		ProductMongoRepository productMongoRepository;

		@Autowired
		ReviewsMongoRepository  reviewsMongoRepository;
		
	    /**
	     * Creates a product.
	     *
	     * 1. Accept product as argument. Use {@link RequestBody} annotation.
	     * 2. Save product.
	     */
	    @RequestMapping(value = "/", method = RequestMethod.POST)
	    @ResponseStatus(HttpStatus.CREATED)
	    public void createProduct(@Valid @RequestBody ProductMongo product ) {
	    	productMongoRepository.save( product ); 
	    }

	    /**
	     * Finds a product by id.
	     *
	     * @param id The id of the product.
	     * @return The product if found, or a 404 not found.
	     */
	    @JsonIgnore
	    @RequestMapping(value = "/{id}")
	    public ProductMongo findById(@PathVariable("id") Integer id) {
	        ProductMongo product = productMongoRepository.findById( id ).orElse(null);
	        if ( product == null ) {
	        	throw     
	    	 	new ResponseStatusException(HttpStatus.NOT_FOUND);
	        }
	        product.setReviews( reviewsMongoRepository.findByProductId(product.getProductId()).orElse(null));
	        return product;
	    }
	 

	    /**
	     * Lists all products.
	     *
	     * @return The list of products.
	     */
	    @RequestMapping(value = "/", method = RequestMethod.GET)
	    public List<?> listProducts() {
	    	List<ProductMongo> result = new ArrayList<ProductMongo>();
	    	productMongoRepository.findAll().forEach( result::add);
	        		
	        result.forEach(review -> review.setReviews( reviewsMongoRepository.findByProductId(review.getProductId()).orElse(null)));
	 
	        
	        return result;
	    }
}