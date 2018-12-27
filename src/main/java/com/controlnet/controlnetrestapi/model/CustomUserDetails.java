package com.controlnet.controlnetrestapi.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

import java.util.stream.Collectors;

public class CustomUserDetails extends Users implements UserDetails {

    public CustomUserDetails(Users users) {
        super(users);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<String> roles = new ArrayList<>();
        roles.add(super.getRole());
       return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_".concat(role))).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return super.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
