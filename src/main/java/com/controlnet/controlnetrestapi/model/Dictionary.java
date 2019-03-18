package com.controlnet.controlnetrestapi.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "dictionary")
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "val")
    private String value;
    private String description;
}
