package com.controlnet.controlnetrestapi.controller;

import com.controlnet.controlnetrestapi.model.Command;
import com.controlnet.controlnetrestapi.service.CommandService;
import com.controlnet.controlnetrestapi.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/commands")
@CrossOrigin(value = "http://localhost:4200")
public class CommandController {
    @Autowired
    private CommandService commandService;

    @Autowired
    private ModuleService moduleService;

    @GetMapping("/{moduleId}")
    public List<Command> getCommands(@PathVariable int moduleId) {
       return commandService.getCommands(moduleId);
    }

    @PostMapping("/add")
    public void addCommands(@PathVariable Map<Object, Object> body) {
        if (body.get("commands") instanceof  List) {

        }
    }
}
