package com.udacity.course3.reviews.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="comment_id")
	private Long commentId;
	 
	
	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	private String commentText;
	
	@ManyToOne
	@JoinColumn(name = "review_id")
	private Review review;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
 
	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
 
}
 
