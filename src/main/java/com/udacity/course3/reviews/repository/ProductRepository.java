package com.udacity.course3.reviews.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.udacity.course3.reviews.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	Optional<Product> findByProductName( String productName );

}
