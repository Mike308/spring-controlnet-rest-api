package com.controlnet.controlnetrestapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "sensor_slots")
public class SensorSlot {
    @Id
    private int id;
    private String name;
}
