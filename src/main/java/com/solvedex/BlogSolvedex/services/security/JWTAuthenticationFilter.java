package com.solvedex.BlogSolvedex.services.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvedex.BlogSolvedex.services.UserDetailsImpl;
import com.solvedex.BlogSolvedex.util.Encrypt;
import com.solvedex.BlogSolvedex.util.TokenUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collections;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        AuthCredentials authCredentials;
        UsernamePasswordAuthenticationToken usernamePAT = null;

        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
            usernamePAT = new UsernamePasswordAuthenticationToken(
                    authCredentials.getUserName(),
                    Encrypt.decrypt(authCredentials.getPassword()),
                    Collections.emptyList()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getAuthenticationManager().authenticate(usernamePAT);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        UserDetailsImpl userDetails=(UserDetailsImpl)authResult.getPrincipal();
        String token= TokenUtils.createToken(userDetails.getName(),userDetails.getUsername());

        response.addHeader("Authorization","Bearer "+token);
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }
}
