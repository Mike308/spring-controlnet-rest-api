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
@Table(name = "v_temperatures")
public class TemperatureView {
    @Id
    @Column(name = "temperature_id")
    private int temperatureId;
    @Column(name = "id")
    private int sensorId;
    @Column(name = "name")
    private String slotName;
    @Column(name = "temperature")
    private float temperature;
    private String date;
    @Column(name = "sensor_type")
    private String sensorType;

}