package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HubService {
    @Autowired
    private TemperatureService temperatureService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private SensorService sensorService;
    @Autowired
    private HumidityService humidityService;
    @Autowired
    private LightIntensityService lightIntensityService;

    public ModuleHub getSingleModuleHub(int moduleId){
        int sensorCnt = sensorService.getSensorCount(moduleId);
        Iterable<TemperatureView> temperatures = temperatureService.getLastTemperaturesByModuleId(moduleId, sensorCnt);
        Iterable<HumidityView> humidityMeasurement = humidityService.getHumidityMeasurementsByModuleId(moduleId, sensorCnt);
        List<LightIntensityView> lightIntensityMeasurements = lightIntensityService.getLightIntensityByModuleId(Integer.toString(moduleId), sensorCnt);
        Module module = moduleService.getModuleById(moduleId);
        ModuleHub moduleHub = new ModuleHub(module, temperatures, humidityMeasurement, lightIntensityMeasurements);
        return moduleHub;
    }

}
