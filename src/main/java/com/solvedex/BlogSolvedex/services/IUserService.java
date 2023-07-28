package com.solvedex.BlogSolvedex.services;

import com.solvedex.BlogSolvedex.model.Post;
import com.solvedex.BlogSolvedex.model.Userg;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<Userg> findAll();
    public Userg save(Userg p);
    public Optional<Userg> findById(Integer id);
    public Optional<Userg> findOneByuserName(String userName);
}
