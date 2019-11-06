package com.udacity.course3.reviews.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="review_id")
	private Long reviewId;
	
	@Column(name="review_descr")
	private String reviewDescr;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
}
 