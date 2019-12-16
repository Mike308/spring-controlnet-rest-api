package com.controlnet.controlnetrestapi.repository;

import com.controlnet.controlnetrestapi.model.Command;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommandRepository extends CrudRepository<Command, Integer> {
    List<Command> getCommandByModuleIdOrderByCommandOrder(int moduleId);
    Command findFirstByOrderByIdDesc();
}
