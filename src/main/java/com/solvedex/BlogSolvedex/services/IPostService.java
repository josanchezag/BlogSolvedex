package com.solvedex.BlogSolvedex.services;

import com.solvedex.BlogSolvedex.model.Post;

import java.util.List;
import java.util.Optional;


public interface IPostService {
    public List<Post> findAll();
    public Optional<Post> save(Post p);
    public Optional<Post> findById(Long postId);
    public void deleteById(Long postId);
}
