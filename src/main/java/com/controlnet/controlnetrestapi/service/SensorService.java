package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.SensorView;
import com.controlnet.controlnetrestapi.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    public Iterable<SensorView> getAllSensorByModuleId(int moduleId){
        return sensorRepository.getAllById(moduleId);
    }
}
