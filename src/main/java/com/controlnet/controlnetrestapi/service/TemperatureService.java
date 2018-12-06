package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.TemperatureView;
import com.controlnet.controlnetrestapi.repository.TemperatureViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemperatureService {
    @Autowired
    private TemperatureViewRepository temperatureViewRepository;

    public Iterable<TemperatureView> getAllTemperaturesBySensorType(String sensorType){
        return temperatureViewRepository.findAllBySensorType(sensorType);
    }

    public Iterable<TemperatureView> getTemperaturesBySensorTypeAndDate(String sensorType, String startDate, String endDate){
        return temperatureViewRepository.findAllByDateAAndDateAndSensorType(startDate, endDate, sensorType);
    }

    public Iterable<TemperatureView> getLastTemperaturesByModuleId(int moduleId){
        return temperatureViewRepository.findByModuleId(moduleId);
    }



}
