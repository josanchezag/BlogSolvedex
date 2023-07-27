package com.solvedex.BlogSolvedex.services;

import com.solvedex.BlogSolvedex.model.Post;
import com.solvedex.BlogSolvedex.repository.IPostServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements IPostService{
    @Autowired
    IPostServiceRepository repository;


    @Override
    public Post save(Post p) {
        return repository.save(p);
    }
}
