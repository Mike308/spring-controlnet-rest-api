package com.controlnet.controlnetrestapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "light_intensity")
public class LightIntensity {
    @Id
    int id;
    @Column(name = "sensor_id")
    private int sensorId;
    private float lightIntensity;
    private String date;
    @Transient
    private String sensorCode;
}


