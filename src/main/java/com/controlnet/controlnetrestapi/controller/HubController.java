package com.controlnet.controlnetrestapi.controller;

import com.controlnet.controlnetrestapi.model.Module;
import com.controlnet.controlnetrestapi.model.ModuleHub;
import com.controlnet.controlnetrestapi.service.HubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hub")
public class HubController {
    @Autowired
    private HubService hubService;

    @GetMapping("/module/{moduleId}")
    public ModuleHub getModuleHub(@PathVariable int moduleId){
        return hubService.getSingleModuleHub(moduleId);
    }


}
