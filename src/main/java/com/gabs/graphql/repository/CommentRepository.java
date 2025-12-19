package com.gabs.graphql.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.gabs.graphql.model.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {  
    List<Comment> findByPostId(String postId); 
}
