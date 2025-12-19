package com.gabs.graphql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gabs.graphql.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    
}
