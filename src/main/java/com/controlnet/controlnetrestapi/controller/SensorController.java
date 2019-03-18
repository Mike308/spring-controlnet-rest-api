package com.controlnet.controlnetrestapi.controller;

import com.controlnet.controlnetrestapi.model.SensorSlot;
import com.controlnet.controlnetrestapi.model.SensorSlotRequest;
import com.controlnet.controlnetrestapi.model.SensorView;
import com.controlnet.controlnetrestapi.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensor")
public class SensorController {
    @Autowired
    private SensorService sensorService;

    @GetMapping("/module-id/{moduleId}")
    public Iterable<SensorView> getSensorsOfModule(@PathVariable int moduleId){
        return sensorService.getAllSensorByModuleId(moduleId);
    }

    @PostMapping("/set-slot-name")
    public boolean setSlotName(@RequestBody SensorSlotRequest sensorSlotRequest){
        return sensorService.setSlotName(sensorSlotRequest.getOldName(), sensorSlotRequest.getNewName());
    }


}
