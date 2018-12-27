package com.controlnet.controlnetrestapi.repository;

import org.springframework.data.repository.CrudRepository;
import com.controlnet.controlnetrestapi.model.Users;

import java.util.Optional;

public interface UserRepository extends CrudRepository <Users, Integer> {
   Optional<Users> findByName(String userName);
}


