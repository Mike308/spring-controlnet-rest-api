package com.controlnet.controlnetrestapi.controller;

import com.controlnet.controlnetrestapi.model.Command;
import com.controlnet.controlnetrestapi.service.CommandService;
import com.controlnet.controlnetrestapi.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Command addCommands(@RequestBody Command command) {
        return commandService.addCommand(command);
    }

    @GetMapping("/delete/{id}")
    public void deleteCommand(@PathVariable int id) {
        commandService.deleteCommand(id);
    }

    @GetMapping("/delete-all/{moduleId}")
    public void deleteAllCommands(@PathVariable int moduleId) {
        commandService.deleteCommands(moduleId);
    }

    @GetMapping("/all")
    public List<Command> getAll() {
        return commandService.getCommands();
    }
}
