package com.controlnet.controlnetrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LightIntensityRequest {
    private int moduleId;
    private LightIntensity lightIntensity;
}
