package com.solvedex.BlogSolvedex.services;

import com.solvedex.BlogSolvedex.model.Userg;
import com.solvedex.BlogSolvedex.repository.IRole;
import com.solvedex.BlogSolvedex.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String userName){
        Userg us=repo.findOneByuserName(userName)
                .orElseThrow(()-> new UsernameNotFoundException("Usuario No encontrado"))
                ;
        return new UserDetailsImpl(us);
    }

}
