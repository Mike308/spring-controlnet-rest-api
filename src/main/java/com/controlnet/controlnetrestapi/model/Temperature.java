package com.controlnet.controlnetrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "temperatures")
public class Temperature {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;
    @Column(name = "sensor_id")
    private int sensorId;
    @Column(name = "temperature")
    private float temperature;
    @Column(name = "date")
    private String date;
}
