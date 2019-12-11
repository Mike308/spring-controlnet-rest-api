package com.controlnet.controlnetrestapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "commands")
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Column(name = "module_id")
    private int moduleId;
    @Column(name = "command_order")
    private int commandOrder;
    private String command;
}

