package com.udacity.course3.reviews.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="review_id")
	private Long reviewId;
	
	@Column(name="review_descr")
	private String reviewDescr;
 
	
	@OneToMany(mappedBy =  "review", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Comment> comments;
	
	@ManyToOne
	@JoinColumn( name="product_id")
	private Product product;

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviewDescr() {
		return reviewDescr;
	}

	public void setReviewDescr(String reviewDescr) {
		this.reviewDescr = reviewDescr;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
 