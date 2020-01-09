package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.Sensor;
import com.controlnet.controlnetrestapi.model.SensorSlot;
import com.controlnet.controlnetrestapi.model.SensorView;
import com.controlnet.controlnetrestapi.repository.SensorRepository;
import com.controlnet.controlnetrestapi.repository.SensorViewRepository;
import com.controlnet.controlnetrestapi.repository.SensorSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

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

    public List<SensorView> getAllSensorByModuleId(int moduleId){
        return sensorViewRepository.getAllById(moduleId);
    }

    public Sensor getSensorBySensorCode(String code) {
        return sensorRepository.getSensorBySensorCode(code);
    }

    public List<Sensor> getSensorsBySensorCode(String sensorCode) {
        return sensorRepository.findAllBySensorCode(sensorCode);
    }

    public int getSensorCount(int moduleId){
        return getSizeOfIterable(sensorViewRepository.getAllById(moduleId));
    }

    public SensorSlot getLastAddedSensorSlot() {
        return sensorSlotRepository.findFirstByOrderByIdDesc();
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

    @Transactional
    public boolean addSensorSlot(SensorSlot sensorSlot) {
        try{
            sensorSlotRepository.save(sensorSlot);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    public void deleteSensors(int moduleId) {
        sensorRepository.deleteByModuleId(moduleId);
    }

    @Transactional
    public void deleteSensorSlot(int slotId) {
        sensorSlotRepository.deleteById(slotId);
    }



}
