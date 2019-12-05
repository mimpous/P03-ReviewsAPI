package com.udacity.course3.reviews.mongo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.udacity.course3.reviews.domain.Review;
@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="comment_id")
	private Integer commentId;

	@Column(name="comment_text")
	private String commentText;
	
	
	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	
	@ManyToOne 
	@JoinColumn(name = "review_id")
	private Review review;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
 
	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
 
}
 
