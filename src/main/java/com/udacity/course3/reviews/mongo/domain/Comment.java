package com.udacity.course3.reviews.mongo.domain;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("comments")
public class Comment {

	@Id
	protected String id;
	
	public Comment() {
		super();
	}
	
	public Comment( String comment) {
		this.commentText=comment;
	}
	  
	private String commentText;
	
	
	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
 
 
}
 
