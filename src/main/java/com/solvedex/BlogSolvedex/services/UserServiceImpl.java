package com.solvedex.BlogSolvedex.services;

import com.solvedex.BlogSolvedex.model.Userg;
import com.solvedex.BlogSolvedex.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    IUserRepository repository;

    @Override
    public List<Userg> findAll() {
        return repository.findAll();
    }

    @Override
    public Userg save(Userg user) {
        return repository.save(user);
    }

    @Override
    public Optional<Userg> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Userg> findOneByuserName(String userName) {
        return repository.findOneByuserName(userName);
    }
}
