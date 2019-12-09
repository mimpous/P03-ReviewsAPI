package com.udacity.course3.reviews.mongo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.udacity.course3.reviews.mongo.domain.Comment;
 

public interface CommentMongoRepository extends  MongoRepository<Comment, String>{
	
	Optional<Comment> findByCommentText( String productName );
	
}