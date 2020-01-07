package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.Command;
import com.controlnet.controlnetrestapi.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommandService {
    @Autowired
    private CommandRepository commandRepository;

    public List<Command> getCommands(int moduleId) {
        return commandRepository.getCommandByModuleIdOrderByCommandOrder(moduleId);
    }

    public List<Command> getCommands() {
        return  commandRepository.findAll();
    }

    public Command addCommand(Command command) {
        commandRepository.save(command);
        return commandRepository.findFirstByOrderByIdDesc();
    }

    @Transactional
    public void deleteCommand(int id) {
        commandRepository.deleteById(id);
    }

    @Transactional
    public void deleteCommands(int moduleId) {
        commandRepository.deleteByModuleId(moduleId);
    }
}
