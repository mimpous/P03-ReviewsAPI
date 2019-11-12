package com.udacity.course3.reviews.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.udacity.course3.reviews.domain.Review;

public interface ReviewsRepository extends CrudRepository<Review, Integer>{
	Optional<Review> findByReviewDescr( String reviewDescription );
}
