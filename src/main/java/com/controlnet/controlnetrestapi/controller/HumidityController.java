package com.controlnet.controlnetrestapi.controller;

import com.controlnet.controlnetrestapi.model.HumidityView;
import com.controlnet.controlnetrestapi.service.HumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/humidity")
public class HumidityController {
    @Autowired
    private HumidityService humidityService;

    @GetMapping("/sensor-type/{sensorType}")
    public Iterable<HumidityView> getHumidityMeasurementsBySensorType(@PathVariable String sensorType){
        return humidityService.getHumidityMeasurementsBySensorType(sensorType);
    }

    @GetMapping("/sensor-type/{sensorType}/start-date/{startDate}/end-date/{endDate}")
    public Iterable<HumidityView> getHumidityMeasurementsBySensorTypeAndDate(@PathVariable String sensorType, @PathVariable String startDate, @PathVariable String endDate){
        return humidityService.getHumidityMeasurementsBySensorTypeAndDate(sensorType, startDate, endDate);
    }

    @GetMapping("/module-id/{moduleId}/{sensorCnt}")
    public Iterable<HumidityView> getHumidityMeasurementsByModuleId(@PathVariable String moduleId, @PathVariable int sensorCnt){
        return humidityService.getHumidityMeasurementsByModuleId(Integer.parseInt(moduleId), sensorCnt);
    }

    @GetMapping("/module-id/{moduleId}/start-date/{startDate}/end-date/{endDate}")
    public Iterable<HumidityView> getHumidityMeasurementsByModuleIdAndDate(@PathVariable int moduleId, @PathVariable String startDate, @PathVariable String endDate){
        return humidityService.getHumidityMeasurementByModuleIdAndDate(moduleId, startDate, endDate);
    }
}
