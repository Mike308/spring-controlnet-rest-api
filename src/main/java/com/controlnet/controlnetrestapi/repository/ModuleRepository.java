package com.controlnet.controlnetrestapi.repository;

import com.controlnet.controlnetrestapi.model.Module;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends CrudRepository<Module, Integer> {
    public Module findByType(String type);
    public Module findById(int id);
    public Module findByAddress(String address);
}

