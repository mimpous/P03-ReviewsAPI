package com.udacity.course3.reviews.repository;
 
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.udacity.course3.reviews.domain.Review;
 
 

public interface ReviewsMongoRepository extends MongoRepository<Review, String>{ 
	Optional<List<Review>> findByProductId( Integer productId );
}