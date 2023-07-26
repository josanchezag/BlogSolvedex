package com.solvedex.BlogSolvedex.services;

import com.solvedex.BlogSolvedex.model.Userg;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final Userg userg;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles= new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(userg.getRole().getDsShortName()));
        return roles;
    }

    @Override
    public String getPassword() {
        return userg.getPass();
    }

    @Override
    public String getUsername() {
        return userg.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return Objects.isNull(userg.getDateSignDown()) || userg.getDateSignDown().after(new Date(System.currentTimeMillis()));
    }
    /**
     * TODO: Method pending to develop
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * TODO: Method pending to develop
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userg.getSnActive().equalsIgnoreCase("S");
    }

    public String getName(){
        return userg.getDsCompleteName();
    }
}
