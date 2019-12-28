package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.Module;
import com.controlnet.controlnetrestapi.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;

    public Iterable<Module> getAllModules(){
        return moduleRepository.findAll();
    }

    public Module getModuleByType(String type){
        return moduleRepository.findByType(type);
    }

    public Module getModuleById(int id){
        return moduleRepository.findById(id);
    }

    public Module getModuleByAddress(String address){
        return moduleRepository.findByAddress(address);
    }

    public int insertNewModule(Module module){
        try {
            moduleRepository.save(module);
            return moduleRepository.findFirstByOrderByIdDesc().getId();
        }catch (Exception e) {
            return -1;
        }
    }

    @Transactional
    public void deleteModule(int moduleId) {
        moduleRepository.deleteById(moduleId);
    }




}
