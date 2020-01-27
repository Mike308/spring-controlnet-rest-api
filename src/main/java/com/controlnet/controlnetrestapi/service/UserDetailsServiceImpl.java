package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.User;
import com.controlnet.controlnetrestapi.repository.UserRepository;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Optional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;


    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        return new org.springframework.security.core.userdetails.User(user.get().getName(), user.get().getPassword(), Collections.emptyList());
    }

    @PostConstruct
    private void isUserAdminExisting() {
        try {
            loadUserByUsername("admin");
        } catch (UsernameNotFoundException e) {
            System.out.println("User admin not exists. Inserting....");
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
          User user = new User();
          user.setName("admin");
          user.setPassword(passwordEncoder.encode("xxxxx"));
          try {
              userRepository.save(user);
          } catch (DataException ex) {
              ex.printStackTrace();
          }
        }
    }
}
