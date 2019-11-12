package com.controlnet.controlnetrestapi.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "humidity_table")
public class Humidity {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "sensor_id")
    private int sensorId;
    @Column(name = "humidity")
    private double humidity;
    @Column(name = "date")
    private String date;
}


