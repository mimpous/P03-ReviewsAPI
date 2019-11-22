package com.udacity.course3.reviews.controller;

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

import com.udacity.course3.reviews.domain.Comment;
import com.udacity.course3.reviews.domain.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ReviewsRepository;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {
 
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	ReviewsRepository reviewsRepository;
	
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
    public ResponseEntity<?> createCommentForReview(@Valid @RequestBody Comment comment ,@PathVariable("reviewId") Integer reviewId) {
    	Review reviewer = reviewsRepository.findById(reviewId).orElse(null);
    
    	if ( reviewer == null ) {
    		return new ResponseEntity(HttpStatus.NOT_FOUND);
    	} else {
    		reviewer.addComment(comment);
    		commentRepository.save(comment);
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
    public List<?> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
    	Review reviewer = reviewsRepository.findById(reviewId).orElse(null);
        
    	if ( reviewer == null ) {
    		throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
    	} else {
    		return reviewer.getComments();
    	} 
         
    }
}