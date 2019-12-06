package com.udacity.course3.reviews.mongo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.udacity.course3.reviews.mongo.domain.ProductMongo;

public interface ProductMongoRepository extends CrudRepository<ProductMongo, Integer>{
	
	Optional<ProductMongo> findByProductName( String productName );

}
