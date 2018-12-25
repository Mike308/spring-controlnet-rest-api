package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.SensorView;
import com.controlnet.controlnetrestapi.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    private int getSizeOfIterable(Iterable<?> iterable){
        if (iterable instanceof Collection)
            return ((Collection<?>) iterable).size();
        int i = 0;
        for (Object object : iterable) i++;
        return i;
    }

    public Iterable<SensorView> getAllSensorByModuleId(int moduleId){
        return sensorRepository.getAllById(moduleId);
    }

    public int getSensorCount(int moduleId){
        return getSizeOfIterable(sensorRepository.getAllById(moduleId));
    }








}
