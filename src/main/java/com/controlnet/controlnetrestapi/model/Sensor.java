package com.controlnet.controlnetrestapi.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "sensors")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    int id;
    @Column(name = "module_id")
    int moduleId;
    @Column(name = "sensor_type")
    String sensorType;
    @Column(name = "sensor_code")
    String sensorCode;
    @Column(name = "sensor_slot")
    int sensorSlot;
}
