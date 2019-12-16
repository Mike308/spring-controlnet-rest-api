package com.controlnet.controlnetrestapi.controller;

import com.controlnet.controlnetrestapi.model.Module;
import com.controlnet.controlnetrestapi.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/modules")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @GetMapping("/all")
    public Iterable<Module> getAllModules(){
        return moduleService.getAllModules();
    }

    @GetMapping("/module/{moduleId}")
    public Module getModule(@PathVariable int moduleId) {
        return moduleService.getModuleById(moduleId);
    }

    @PostMapping("/add-new-module")
    public int addNewModule(@RequestBody Module module) { return moduleService.insertNewModule(module);}



}
