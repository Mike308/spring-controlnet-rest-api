package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.Command;
import com.controlnet.controlnetrestapi.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandService {
    @Autowired
    private CommandRepository commandRepository;

    public List<Command> getCommands(int moduleId) {
        return commandRepository.getCommandByModuleIdOrderByCommandOrder(moduleId);
    }

    public Command addCommand(Command command) {
        commandRepository.save(command);
        return commandRepository.findFirstByOrderByIdDesc();
    }

    public void addCommands(List<Command> commands) {
        commands.forEach(this::addCommand);
    }

}
