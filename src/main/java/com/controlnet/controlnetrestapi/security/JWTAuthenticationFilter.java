package com.controlnet.controlnetrestapi.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.controlnet.controlnetrestapi.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.controlnet.controlnetrestapi.security.SecurityConstants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        try{
            User user = new ObjectMapper().readValue(httpServletRequest.getInputStream(), User.class);
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword(), new ArrayList<>()));
            return authentication;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token = JWT.create()
                .withSubject(((User)(authResult.getPrincipal())).getName())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .withClaim("userId",((User)(authResult.getPrincipal())).getId())
                .sign(Algorithm.HMAC512(SECRET.getBytes()));
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
        response.setContentType("application/json");
        response.getWriter().write("{\"token\": " +"\""+ TOKEN_PREFIX + token +"\"" + "}");
    }
}
