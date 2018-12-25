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
@Table(name = "v_humidity")
public class HumidityView {
    @Id
    private int id;
    private String name;
    private float humidity;
    private String date;
    @Column(name = "sensor_type")
    private String sensorType;
}
