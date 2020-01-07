package com.controlnet.controlnetrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HumidityRequest {
    private Humidity humidity;
    private int moduleId;
}
