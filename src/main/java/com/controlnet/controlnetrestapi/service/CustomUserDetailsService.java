package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.CustomUserDetails;
import com.controlnet.controlnetrestapi.model.Users;
import com.controlnet.controlnetrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        return user.map(CustomUserDetails::new).get();
    }
}