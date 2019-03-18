package com.controlnet.controlnetrestapi.controller;

import com.controlnet.controlnetrestapi.model.Module;
import com.controlnet.controlnetrestapi.repository.DictionaryRepository;
import com.controlnet.controlnetrestapi.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modules")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @GetMapping("/all")
    public Iterable<Module> getAllModules(){
        return moduleService.getAllModules();
    }



}
