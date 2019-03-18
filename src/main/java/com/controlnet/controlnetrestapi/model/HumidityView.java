package com.controlnet.controlnetrestapi.model;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//TODO: add id for humidity

@Data
@Entity
@Immutable
@Table(name = "v_humidity")
public class HumidityView {
    @Id
    @Column(name = "humidity_id")
    private int id;
    @Column(name = "sensor_id")
    private int sensorId;
    @Column(name = "name")
    private String slotName;
    private float humidity;
    private String date;
    @Column(name = "sensor_type")
    private String sensorType;
}
