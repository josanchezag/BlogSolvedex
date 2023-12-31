package com.solvedex.BlogSolvedex.services;

import com.solvedex.BlogSolvedex.model.Post;
import com.solvedex.BlogSolvedex.repository.IPostServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService{
    @Autowired
    IPostServiceRepository repository;


    @Override
    public List<Post> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Post> save(Post p) {
        return Optional.of(repository.save(p));
    }

    @Override
    public Optional<Post> findById(Long postId) {
        return repository.findById(postId);
    }

    @Override
    public void deleteById(Long postId) {
         repository.deleteById(postId);
    }
}
