package com.solvedex.BlogSolvedex.services;

import com.solvedex.BlogSolvedex.model.Comment;
import com.solvedex.BlogSolvedex.model.Post;

import java.util.List;
import java.util.Optional;


public interface ICommentService {
    public List<Comment> findAll();
    public Optional<Comment> save(Comment c);
    public Optional<Comment> findById(Long commentId);
    public void deleteById(Long commentId);
}
