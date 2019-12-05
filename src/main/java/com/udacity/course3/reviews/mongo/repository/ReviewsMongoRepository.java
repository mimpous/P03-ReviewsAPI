package com.udacity.course3.reviews.mongo.repository;
 
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.udacity.course3.reviews.mongo.domain.Review;
 

public interface ReviewsMongoRepository extends MongoRepository<Review, String>{
	Optional<Review> findByReviewDescr( String reviewDescription );
	Optional<List<Review>> findByProductId( Integer productId );
}