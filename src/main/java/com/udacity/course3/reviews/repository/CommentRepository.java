package com.udacity.course3.reviews.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.udacity.course3.reviews.domain.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer>{
	
	Optional<Comment> findByCommentText( String productName );
	
}
