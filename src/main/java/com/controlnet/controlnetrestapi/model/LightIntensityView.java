package com.controlnet.controlnetrestapi.model;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Immutable
@Table(name = "v_light_intensity")
public class LightIntensityView {
    @Id
    private int id;
    @Column(name = "light_intensity")
    private double lightIntensity;
    private String date;
    @Column(name = "sensor_type")
    private String sensorType;
    @Column(name = "name")
    private String slotName;
    @Column(name = "sensor_id")
    private int sensorId;
}


