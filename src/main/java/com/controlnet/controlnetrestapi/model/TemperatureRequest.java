package com.controlnet.controlnetrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemperatureRequest {
    private List<Temperature> temperatures;
    private int moduleId;
}
