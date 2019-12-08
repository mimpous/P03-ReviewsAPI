package com.udacity.course3.reviews;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.udacity.course3.reviews.domain.Product;
import com.udacity.course3.reviews.domain.Review;
import com.udacity.course3.reviews.repository.ReviewsMongoRepository;
 
 
@DataMongoTest
@ExtendWith(SpringExtension.class)
public class ReviewsApplicationMongodbTests {

	
	@Autowired
	private ReviewsMongoRepository reviewMongoRepository;
	 
	
	@Test
	public void reviewMongoTest() {
		Product product = new Product();
		product.setProductId(1);
		
 		Review review = new Review();
		review.setReviewDescr("Rev desc"); 
		
		review.setProduct( product ); 
 
		Review saved = reviewMongoRepository.save( review );  
		
		Review actual = reviewMongoRepository.findById( saved.getReviewDescr() ).orElse(null);
		assertThat(actual).isNotNull();
		assertEquals(saved.getReviewDescr(), actual.getReviewDescr());
	}	
	
//	@Test
//	public void commentsMongoTest() {
// 		Review review = new Review();
//		review.setReviewDescr("Rev desc"); 
//		review.setProductId( 1 ); 
//  
//		
//		Comment  comment = new Comment();
//		comment.setCommentText("This is a Mongo Comment"); 
//		
//		Comment savedComment = commentMongoRepository.save(comment);
//		
//		review.addComment(comment);
//
//		Review saved = reviewMongoRepository.save( review ); 
//		
//		
//		System.out.println( saved.getId());
//		
//		Review actual = reviewMongoRepository.findById( saved.getId()).orElse(null);
//		assertThat(actual).isNotNull();
//		
//		assertEquals(saved.getComments().get(0).getId(), savedComment.getId());
//	}
	 
}
