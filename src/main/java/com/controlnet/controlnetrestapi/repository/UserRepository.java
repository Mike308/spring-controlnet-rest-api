package com.controlnet.controlnetrestapi.repository;

import org.springframework.data.repository.CrudRepository;
import com.controlnet.controlnetrestapi.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository <User, Integer> {
   Optional<User> findByName(String userName);
}


