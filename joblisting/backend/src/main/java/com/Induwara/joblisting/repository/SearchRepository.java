package com.Induwara.joblisting.repository;

import java.util.List;

import com.Induwara.joblisting.model.Post;

public interface SearchRepository {

    List<Post> findByText(String text);

}
