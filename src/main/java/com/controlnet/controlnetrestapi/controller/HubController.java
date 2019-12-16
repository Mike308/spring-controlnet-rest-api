package com.controlnet.controlnetrestapi.controller;

import com.controlnet.controlnetrestapi.model.Humidity;
import com.controlnet.controlnetrestapi.model.ModuleHub;
import com.controlnet.controlnetrestapi.model.Sensor;
import com.controlnet.controlnetrestapi.model.Temperature;
import com.controlnet.controlnetrestapi.service.HubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hub")
@CrossOrigin(value = "http://localhost:4200")
public class HubController {
    @Autowired
    private HubService hubService;

    @GetMapping("/module/{moduleId}")
    public ModuleHub getModuleHub(@PathVariable int moduleId){
        return hubService.getSingleModuleHub(moduleId);
    }

    @PostMapping("/insert-sensors")
    public void insertSensors(@RequestBody Map<Object, Object> sensor) {
        hubService.insertSensors((List<Sensor>)sensor.get("sensors"), (String)sensor.get("moduleAddress"));
    }

    @PostMapping("/insert-temperatures")
    public void insertTemperatures(@RequestBody List<Temperature> temperatures) {
        hubService.insertTemperatureToHub(temperatures);
    }

    @PostMapping("/insert-humidity")
    public void insertTemperatures(@RequestBody Humidity humidity) {
        hubService.insertHumidityToHub(humidity);
    }


}
