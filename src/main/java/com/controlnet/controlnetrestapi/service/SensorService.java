package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.Sensor;
import com.controlnet.controlnetrestapi.model.SensorView;
import com.controlnet.controlnetrestapi.repository.SensorRepository;
import com.controlnet.controlnetrestapi.repository.SensorViewRepository;
import com.controlnet.controlnetrestapi.repository.SensorSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class SensorService {
    @Autowired
    private SensorViewRepository sensorViewRepository;

    @Autowired
    private SensorSlotRepository sensorSlotRepository;

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
        return sensorViewRepository.getAllById(moduleId);
    }

    public Sensor getSensorBySensorCode(String code) {
        return sensorRepository.getSensorBySensorCode(code);
    }

    public int getSensorCount(int moduleId){
        return getSizeOfIterable(sensorViewRepository.getAllById(moduleId));
    }

    @Transactional
    public boolean setSlotName(int sensorId, String newSlotName){
        try {
            int slotId = sensorViewRepository.getAllBySensorId(sensorId).getSensorSlotId();
            sensorSlotRepository.setSlotName(slotId, newSlotName);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    public boolean addNewSensor(Sensor sensor) {
        try {
            sensorRepository.save(sensor);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }




}
