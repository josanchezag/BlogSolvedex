package com.solvedex.BlogSolvedex.repository;

import com.solvedex.BlogSolvedex.model.Userg;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface IUserRepository  extends JpaRepository<Userg, Integer> {
    public Optional<Userg> findOneByuserName(String userName);
}