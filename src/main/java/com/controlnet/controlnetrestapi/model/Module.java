package com.controlnet.controlnetrestapi.model;

import lombok.Data;

import javax.persistence.*;
import java.io.InputStream;
import java.sql.Blob;
@Data
@Entity
@Table(name = "modules")
public class Module {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "icon")
    @Lob
    private Blob icon;
    @Column(name = "address")
    private String address;
}
