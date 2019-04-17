package com.controlnet.controlnetrestapi.controller;

import com.controlnet.controlnetrestapi.model.SensorSlot;
import com.controlnet.controlnetrestapi.model.SensorSlotRequest;
import com.controlnet.controlnetrestapi.model.SensorView;
import com.controlnet.controlnetrestapi.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<SensorSlotRequest> setSlotName(@RequestBody SensorSlotRequest sensorSlotRequest){
        boolean result = sensorService.setSlotName(sensorSlotRequest.getSensorId(), sensorSlotRequest.getNewName());
        return new ResponseEntity<>(sensorSlotRequest, HttpStatus.OK);
    }


}
