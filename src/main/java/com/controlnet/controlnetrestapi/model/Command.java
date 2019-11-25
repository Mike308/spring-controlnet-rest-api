package com.controlnet.controlnetrestapi.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "commands")
public class Command {
    @Id
    private int id;
    @Column(name = "module_id")
    private int moduleId;
    @Column(name = "command_order")
    private int commandOrder;
    private String command;
}

