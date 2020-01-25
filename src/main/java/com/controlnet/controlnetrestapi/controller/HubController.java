package com.controlnet.controlnetrestapi.controller;

import com.controlnet.controlnetrestapi.model.*;
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
    public void insertTemperatures(@RequestBody TemperatureRequest temperatures) {
        hubService.insertTemperatureToHub(temperatures.getTemperatures(), temperatures.getModuleId());
    }

    @PostMapping("/insert-humidity")
    public void insertHumidity(@RequestBody HumidityRequest humidity) {
        hubService.insertHumidityToHub(humidity.getHumidity(),  humidity.getModuleId());
    }

    @PostMapping("/insert-light-intensity")
    public void insertLightIntensity(@RequestBody LightIntensityRequest lightIntensityRequest) {
        hubService.insertLightIntensityToHub(lightIntensityRequest.getLightIntensity(), lightIntensityRequest.getModuleId());
    }

    @GetMapping("/remove-sensors/{moduleId}")
    public void removeAllSensorsAndMeasurements(@PathVariable int moduleId) {
        hubService.deleteAllSensorsAndMeasurements(moduleId);
    }
}
