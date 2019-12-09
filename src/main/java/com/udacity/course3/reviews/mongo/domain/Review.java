package com.udacity.course3.reviews.mongo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
 

@Document("reviews")
public class Review {
	
	public Review( Integer productId, String reviewDescr , List<Comment> comments  ) {
		this.productId = productId;
		this.reviewDescr = reviewDescr;
		this.comments = comments;
	}

	@Id
	protected String id;
	
	protected Integer productId;
	
	protected String reviewDescr;
   
	protected List<Comment> comments;
 
	public void addComment(Comment aComment) {
		if (comments == null) {
			comments = new ArrayList<Comment>();
		}
		comments.add(aComment);
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


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

 
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
 

 
	
}
 