package com.controlnet.controlnetrestapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sensor_slots")
public class SensorSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
}
