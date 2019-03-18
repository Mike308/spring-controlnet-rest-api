package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.SensorView;
import com.controlnet.controlnetrestapi.repository.SensorRepository;
import com.controlnet.controlnetrestapi.repository.SensorSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private SensorSlotRepository sensorSlotRepository;


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

    @Transactional
    public boolean setSlotName(String oldSlotName, String newSlotName){
        try {
            int slotId = sensorRepository.getAllBySensorSlotName(oldSlotName).getSensorSlotId();
            System.out.println("Slot id: " + slotId);
            sensorSlotRepository.setSlotName(slotId, newSlotName);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }










}
