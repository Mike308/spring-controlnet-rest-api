package com.controlnet.controlnetrestapi.controller;

import com.controlnet.controlnetrestapi.model.Dictionary;
import com.controlnet.controlnetrestapi.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dictionary")
@CrossOrigin(value = "http://localhost:4200")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/modules-types")
    public List<Dictionary> getModulesType() {
        return dictionaryService.getModuleTypes();
    }
}
