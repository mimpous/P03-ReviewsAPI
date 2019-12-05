package com.udacity.course3.reviews.mongo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.udacity.course3.reviews.mongo.domain.Product;

public interface ProductMongoRepository extends CrudRepository<Product, Integer>{
	
	Optional<Product> findByProductName( String productName );

}
