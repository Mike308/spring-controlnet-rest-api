package com.controlnet.controlnetrestapi.model;

import lombok.Data;
import lombok.Getter;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    private int id;
    private String name;
    private String password;
    private String role;

    public Users(){

    }

    public Users(Users users){
        this.id = users.getId();
        this.name = users.getName();
        this.password = users.getPassword();
        this.role = users.getRole();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


