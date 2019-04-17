package com.controlnet.controlnetrestapi.model;

import lombok.Data;

@Data
public class SensorSlotRequest {
    int sensorId;
    String newName;
}
