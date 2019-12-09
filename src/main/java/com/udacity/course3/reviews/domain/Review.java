package com.udacity.course3.reviews.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "reviews")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="review_id")
	private Integer reviewId;
	
	@Column(name="review_descr")
	private String reviewDescr; 
	 
	@OneToMany(mappedBy =  "review" ,fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Comment> comments;
	 
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn( name="product_id" )
	private Product product;

	
	@Column(name="review_mongo_id")
	private String id;
	
	
	@Transient
	public void addComment( Comment aComment ) {
		if ( comments == null ) {
			comments = new ArrayList<Comment>();
		}
		comments.add(aComment);
	}
	
	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
 
	
}
 