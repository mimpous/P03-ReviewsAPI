package com.udacity.course3.reviews;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.udacity.course3.reviews.domain.Product;
import com.udacity.course3.reviews.domain.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewsRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewsApplicationTests {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private TestEntityManager testEntityManager;
	@Autowired
	private ReviewsRepository reviewsRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CommentRepository commentRepository;

	@Test
	public void injectedComponentsAreNotNull() {
		assertThat(dataSource).isNotNull();
		assertThat(jdbcTemplate).isNotNull();
		assertThat(entityManager).isNotNull();
		assertThat(testEntityManager).isNotNull();
		assertThat(reviewsRepository).isNotNull();
		assertThat(productRepository).isNotNull();
		assertThat(commentRepository).isNotNull();
	}

	@Test
	public void contextLoads() {

		Review review = new Review();
		review.setReviewDescr("Rev desc");
		Product product = new Product();
		product.setProductName("Test Product");

		List<Review> reviewList = new ArrayList<Review>();
		reviewList.add(review);
		product.setReviews(reviewList);
		entityManager.persist(product);

		Product actual = productRepository.findByProductName("Test Product").orElse(null);
		assertThat(actual).isNotNull();
		assertEquals(product.getProductId(), actual.getProductId());

	}

}