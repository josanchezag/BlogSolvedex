package com.solvedex.BlogSolvedex.services;

import com.solvedex.BlogSolvedex.model.Comment;
import com.solvedex.BlogSolvedex.model.Post;
import com.solvedex.BlogSolvedex.repository.ICommentServiceRepository;
import com.solvedex.BlogSolvedex.repository.IPostServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements ICommentService{
    @Autowired
    ICommentServiceRepository repository;


    @Override
    public List<Comment> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Comment> save(Comment p) {
        return Optional.of(repository.save(p));
    }

    @Override
    public Optional<Comment> findById(Long commentId) {
        return repository.findById(commentId);
    }

    @Override
    public void deleteById(Long commentId) {
         repository.deleteById(commentId);
    }
}
