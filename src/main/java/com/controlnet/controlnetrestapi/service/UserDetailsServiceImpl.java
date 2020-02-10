package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.User;
import com.controlnet.controlnetrestapi.repository.UserRepository;
import org.hibernate.exception.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;


    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        System.out.println("User: " + user.get().toString());
        return user.get();
    }

    public ResponseEntity insertNewUser(User user) {
        Map<String, String> message = new HashMap<>();
        try {
            loadUserByUsername(user.getName());
            message.put("message", "User already exists");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        } catch (UsernameNotFoundException e) {
            try {
                PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                userRepository.save(user);
                message.put("message", "User inserted");
                return ResponseEntity.ok(message);
            } catch (DataException de) {
                message.put("message", "Problem with user inserting");
                return ResponseEntity.status(HttpStatus.OK).body(message);
            }
        }
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
          user.setPassword(passwordEncoder.encode("code8989"));
          try {
              userRepository.save(user);
          } catch (DataException ex) {
              ex.printStackTrace();
          }
        }
    }
}
