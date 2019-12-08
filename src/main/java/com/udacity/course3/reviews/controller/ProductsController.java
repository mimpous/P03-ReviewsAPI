package com.udacity.course3.reviews.controller;

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
import com.udacity.course3.reviews.domain.Product;
import com.udacity.course3.reviews.repository.ProductRepository; 

/**
 * Spring REST controller for working with product entity.
 */
@RestController
@RequestMapping("/products")
public class ProductsController {
 
	@Autowired
	ProductRepository productRepository;
	


    /**
     * Creates a product.
     *
     * 1. Accept product as argument. Use {@link RequestBody} annotation.
     * 2. Save product.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@Valid @RequestBody Product product ) {
    	productRepository.save( product ); 
    }

    /**
     * Finds a product by id.
     *
     * @param id The id of the product.
     * @return The product if found, or a 404 not found.
     */
    @JsonIgnore
    @RequestMapping(value = "/{id}")
    public Product findById(@PathVariable("id") Integer id) {
        Product product = productRepository.findById( id ).orElse(null);
        if ( product == null ) {
        	throw     
    	 	new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return product;
    }
  

    /**
     * Lists all products.
     *
     * @return The list of products.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<?> listProducts() {
    	List<Product> result = new ArrayList<Product>();
        productRepository.findAll().forEach(result::add);
        return result;
    }
}