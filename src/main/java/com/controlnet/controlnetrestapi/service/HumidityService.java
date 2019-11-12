package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.Humidity;
import com.controlnet.controlnetrestapi.model.HumidityView;
import com.controlnet.controlnetrestapi.repository.HumidityRepository;
import com.controlnet.controlnetrestapi.repository.HumidityViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HumidityService {
    @Autowired
    private HumidityViewRepository humidityViewRepository;

    @Autowired
    private HumidityRepository humidityRepository;

    public Iterable<HumidityView> getHumidityMeasurementsBySensorType(String sensorType){
        return humidityViewRepository.findAllBySensorType(sensorType);
    }

    public Iterable<HumidityView> getHumidityMeasurementsBySensorTypeAndDate(String sensorType, String start, String end){
        return humidityViewRepository.findAllBySensorTypeAndDate(sensorType, start, end);
    }

    public Iterable<HumidityView> getHumidityMeasurementsByModuleId(int moduleId, int sensorCnt){
        return humidityViewRepository.findByModuleId(moduleId, sensorCnt);
    }

    public Iterable<HumidityView> getHumidityMeasurementByModuleIdAndDate(int moduleId, String start, String end){
        return humidityViewRepository.findByModuleIdAndDate(moduleId, start, end);
    }

    private void insertHumidity(Humidity humidity) {
        humidityRepository.save(humidity);
    }
}
