package com.controlnet.controlnetrestapi.controller;

import com.controlnet.controlnetrestapi.model.TemperatureView;
import com.controlnet.controlnetrestapi.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temperatures/")
public class TemperatureController {
    @Autowired
    private TemperatureService temperatureService;

    @GetMapping("/sensor-type/{sensorType}")
    public Iterable<TemperatureView> getTemperaturesBySensorType(@PathVariable String sensorType){
        return temperatureService.getAllTemperaturesBySensorType(sensorType);
    }

    @GetMapping("/sensor-type/{sensorType}/start-date/{startDate}/end-date/{endDate}")
    public Iterable<TemperatureView> getTemperaturesBySensorTypeAndDate(@PathVariable String sensorType, @PathVariable String startDate, @PathVariable String endDate){
        return temperatureService.getTemperaturesBySensorTypeAndDate(sensorType, startDate, endDate);
    }

    @GetMapping("/module-id/{moduleId}")
    public Iterable<TemperatureView> getLastTemperaturesByModuleId(@PathVariable int moduleId){
        return temperatureService.getLastTemperaturesByModuleId(moduleId);
    }
}


