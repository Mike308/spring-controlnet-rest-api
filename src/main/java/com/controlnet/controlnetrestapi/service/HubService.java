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

    public void insertTemperatureToHub(List<Temperature> temperatures) {
        temperatures.stream().forEach(temperature -> {
            Sensor sensor = sensorService.getSensorBySensorCode(temperature.getSensorCode());
            temperature.setSensorId(sensor.getId());
            temperatureService.insertTemperature(temperature);
        });
    }

    public void insertHumidityToHub(Humidity humidity) {
        Sensor sensor = sensorService.getSensorBySensorCode(humidity.getSensorCode());
        humidity.setSensorId(sensor.getId());
    }

    public void insertSensors(List<Sensor> sensors, String moduleAddress) {
        sensors.forEach(sensor -> {
            sensor.setModuleId(moduleService.getModuleByAddress(moduleAddress).getId());
            sensorService.addNewSensor(sensor);
        });
    }






}
