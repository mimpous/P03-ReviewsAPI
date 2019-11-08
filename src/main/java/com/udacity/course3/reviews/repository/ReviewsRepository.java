package com.udacity.course3.reviews.repository;

import org.springframework.data.repository.CrudRepository;

import com.udacity.course3.reviews.domain.Review;

public interface ReviewsRepository extends CrudRepository<Review, Integer>{

}
