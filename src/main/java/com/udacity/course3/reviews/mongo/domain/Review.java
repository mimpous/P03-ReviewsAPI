package com.udacity.course3.reviews.mongo.domain;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("reviews")
public class Review {
	
	@Id
	private Integer productId;
	
	@Id
	private Integer reviewId;
 
	private String reviewDescr;
  
//	private Product product;

//	@Transient
//	public void addComment(Comment aComment) {
//		if (comments == null) {
//			comments = new ArrayList<Comment>();
//		}
//		comments.add(aComment);
//	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getReviewDescr() {
		return reviewDescr;
	}

	public void setReviewDescr(String reviewDescr) {
		this.reviewDescr = reviewDescr;
	}

//	public List<Comment> getComments() {
//		return comments;
//	}
//
//	public void setComments(List<Comment> comments) {
//		this.comments = comments;
//	}

//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

 
	
}
 