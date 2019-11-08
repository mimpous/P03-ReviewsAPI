package com.udacity.course3.reviews.repository;

import org.springframework.data.repository.CrudRepository;

import com.udacity.course3.reviews.domain.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer>{

}
