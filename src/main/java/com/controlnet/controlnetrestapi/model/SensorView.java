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
@Table(name = "v_sensors")
public class SensorView {
    private int id;
    @Column(name = "module_name")
    private String moduleName;
    @Column(name = "sensor_code")
    private String sensorCode;
    private String description;
    @Column(name = "sensor_slot_name")
    private String sensorSlotName;
    @Column(name = "sensor_type")
    private String sensorType;
    @Column(name = "sensor_slot_id")
    private int sensorSlotId;
    @Id
    @Column(name = "sensor_id")
    private int sensorId;
}
