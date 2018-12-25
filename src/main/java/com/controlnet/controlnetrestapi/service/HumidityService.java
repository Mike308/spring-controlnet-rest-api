package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.HumidityView;
import com.controlnet.controlnetrestapi.repository.HumidityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HumidityService {
    @Autowired
    private HumidityRepository humidityRepository;

    public Iterable<HumidityView> getHumidityMeasurementsBySensorType(String sensorType){
        return humidityRepository.findAllBySensorType(sensorType);
    }

    public Iterable<HumidityView> getHumidityMeasurementsBySensorTypeAndDate(String sensorType, String start, String end){
        return humidityRepository.findAllBySensorTypeAndDate(sensorType, start, end);
    }

    public Iterable<HumidityView> getHumidityMeasurementsByModuleId(int moduleId, int sensorCnt){
        return humidityRepository.findByModuleId(moduleId, sensorCnt);
    }
}
