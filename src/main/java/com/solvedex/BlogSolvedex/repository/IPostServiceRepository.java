package com.solvedex.BlogSolvedex.repository;

import com.solvedex.BlogSolvedex.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostServiceRepository  extends JpaRepository<Post, Long> {
}
