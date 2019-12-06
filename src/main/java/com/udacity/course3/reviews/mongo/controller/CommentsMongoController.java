package com.udacity.course3.reviews.mongo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.udacity.course3.reviews.mongo.domain.Comment;
import com.udacity.course3.reviews.mongo.domain.Review;
import com.udacity.course3.reviews.mongo.repository.CommentMongoRepository;
import com.udacity.course3.reviews.mongo.repository.ReviewsMongoRepository;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController 
@RequestMapping("/commentsMongo")
public class CommentsMongoController {
 
	@Autowired
	CommentMongoRepository commentMongoRepository;
	
	@Autowired
	ReviewsMongoRepository reviewsMongoRepository;
	
    /**
     * Creates a comment for a review.
     *
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<?> createCommentForReview(@Valid @RequestBody Comment comment ,@PathVariable("reviewId") String reviewId) {
    	Review reviewer = reviewsMongoRepository.findById(reviewId).orElse(null);
    
    	if ( reviewer == null ) {
    		return new ResponseEntity(HttpStatus.NOT_FOUND);
    	} else {
    		reviewer.addComment(comment);
    		commentMongoRepository.save(comment);
    		reviewsMongoRepository.save(reviewer);
    		return new ResponseEntity(HttpStatus.OK);
    	}
    	 
    }
       

    /**
     * List comments for a review.
     *
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public List<?> listCommentsForReview(@PathVariable("reviewId") String reviewId) {
    	Review reviewer = reviewsMongoRepository.findById(reviewId).orElse(null);
        
    	if ( reviewer == null ) {
    		throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
    	} else {
    		return reviewer.getComments();
    	} 
         
    }
}