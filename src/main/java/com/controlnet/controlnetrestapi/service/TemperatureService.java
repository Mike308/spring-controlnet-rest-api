package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.Temperature;
import com.controlnet.controlnetrestapi.model.TemperatureView;
import com.controlnet.controlnetrestapi.repository.TemperatureRepository;
import com.controlnet.controlnetrestapi.repository.TemperatureViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TemperatureService {
    @Autowired
    private TemperatureViewRepository temperatureViewRepository;

    @Autowired
    private TemperatureRepository temperatureRepository;

    public Iterable<TemperatureView> getAllTemperaturesBySensorType(String sensorType){
        return temperatureViewRepository.findAllBySensorType(sensorType);
    }

    public Iterable<TemperatureView> getTemperaturesBySensorTypeAndDate(String sensorType, String startDate, String endDate){
        return temperatureViewRepository.findAllByDateAAndDateAndSensorType(startDate, endDate, sensorType);
    }

    public Iterable<TemperatureView> getLastTemperaturesByModuleId(int moduleId, int sensorCnt){
        return temperatureViewRepository.findByModuleId(moduleId, sensorCnt);
    }

    public Iterable<TemperatureView> getTemperatureByModuleIdAndDate(int moduleId, String start, String end) {
        return temperatureViewRepository.findByModuleIdAndDate(moduleId, start, end);
    }
    @Transactional
    public void insertTemperature(Temperature temperature) {
        temperatureRepository.save(temperature);
    }

    @Transactional
    public void deleteTemperature(int sensorId) {
        temperatureRepository.deleteBySensorId(sensorId);
    }








}
