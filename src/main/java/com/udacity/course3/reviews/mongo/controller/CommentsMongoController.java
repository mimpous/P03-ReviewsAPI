package com.udacity.course3.reviews.mongo.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController 
public class CommentsMongoController {
 
//	@Autowired
//	CommentRepository commentRepository;
//	
//	@Autowired
//	ReviewsRepository reviewsRepository;
//	
//    /**
//     * Creates a comment for a review.
//     *
//     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
//     * 2. Check for existence of review.
//     * 3. If review not found, return NOT_FOUND.
//     * 4. If found, save comment.
//     *
//     * @param reviewId The id of the review.
//     */
//    @SuppressWarnings("rawtypes")
//	@RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
//    public ResponseEntity<?> createCommentForReview(@Valid @RequestBody Comment comment ,@PathVariable("reviewId") Integer reviewId) {
//    	Review reviewer = reviewsRepository.findById(reviewId).orElse(null);
//    
//    	if ( reviewer == null ) {
//    		return new ResponseEntity(HttpStatus.NOT_FOUND);
//    	} else {
//    		reviewer.addComment(comment);
//    		commentRepository.save(comment);
//    		return new ResponseEntity(HttpStatus.OK);
//    	}
//    	 
//    }
//       
//
//    /**
//     * List comments for a review.
//     *
//     * 2. Check for existence of review.
//     * 3. If review not found, return NOT_FOUND.
//     * 4. If found, return list of comments.
//     *
//     * @param reviewId The id of the review.
//     */
//    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
//    public List<?> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
//    	Review reviewer = reviewsRepository.findById(reviewId).orElse(null);
//        
//    	if ( reviewer == null ) {
//    		throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
//    	} else {
//    		return reviewer.getComments();
//    	} 
//         
//    }
}