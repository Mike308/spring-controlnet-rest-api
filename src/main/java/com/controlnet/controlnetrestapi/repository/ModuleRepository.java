package com.controlnet.controlnetrestapi.repository;

import com.controlnet.controlnetrestapi.model.Module;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends CrudRepository<Module, Integer> {
     Module findByType(String type);
     Module findById(int id);
     Module findByAddress(String address);
}

