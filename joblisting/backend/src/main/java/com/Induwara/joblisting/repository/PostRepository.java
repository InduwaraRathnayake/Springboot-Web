package com.Induwara.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Induwara.joblisting.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {
    
}
