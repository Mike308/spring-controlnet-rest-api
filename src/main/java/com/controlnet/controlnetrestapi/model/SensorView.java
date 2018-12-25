package com.controlnet.controlnetrestapi.model;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "v_sensors")
public class SensorView {
    @Id
    private int id;
    @Column(name = "module_name")
    private String moduleName;
    @Column(name = "sensor_code")
    private String sensorCode;
    private String description;
    @Column(name = "sensor_slot_name")
    private String sensorSlotName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getSensorCode() {
        return sensorCode;
    }

    public void setSensorCode(String sensorCode) {
        this.sensorCode = sensorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSensorSlotName() {
        return sensorSlotName;
    }

    public void setSensorSlotName(String sensorSlotName) {
        this.sensorSlotName = sensorSlotName;
    }
}
