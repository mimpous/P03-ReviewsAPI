package com.udacity.course3.reviews;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.udacity.course3.reviews.mongo.domain.Comment;
import com.udacity.course3.reviews.mongo.domain.Review;
import com.udacity.course3.reviews.mongo.repository.CommentMongoRepository;
import com.udacity.course3.reviews.mongo.repository.ReviewsMongoRepository;
 
 
@DataMongoTest
@ExtendWith(SpringExtension.class)
public class ReviewsApplicationMongodbTests {

	
	@Autowired
	private ReviewsMongoRepository reviewMongoRepository;
	
	@Autowired
	private CommentMongoRepository  commentMongoRepository;
	
	@Test
	public void reviewMongoTest() {
 		Review review = new Review();
		review.setReviewDescr("Rev desc"); 
		review.setProductId( 1 ); 
 
		Review saved = reviewMongoRepository.save( review );  
		
		Review actual = reviewMongoRepository.findById( saved.getId()).orElse(null);
		assertThat(actual).isNotNull();
		assertEquals(saved.getReviewDescr(), actual.getReviewDescr());
	}	
	
	@Test
	public void commentsMongoTest() {
 		Review review = new Review();
		review.setReviewDescr("Rev desc"); 
		review.setProductId( 1 ); 
  
		
		Comment  comment = new Comment();
		comment.setCommentText("This is a Mongo Comment"); 
		
		Comment savedComment = commentMongoRepository.save(comment);
		
		review.addComment(comment);

		Review saved = reviewMongoRepository.save( review ); 
		
		
		System.out.println( saved.getId());
		
		Review actual = reviewMongoRepository.findById( saved.getId()).orElse(null);
		assertThat(actual).isNotNull();
		
		assertEquals(saved.getComments().get(0).getId(), savedComment.getId());
	}
	 
}
