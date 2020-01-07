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

    public void insertTemperatureToHub(List<Temperature> temperatures, int moduleId) {
        temperatures.forEach(temperature -> {
            if (sensorService.getSensorsBySensorCode(temperature.getSensorCode()).size() > 0) {
                Sensor sensor = sensorService.getSensorBySensorCode(temperature.getSensorCode());
                temperature.setSensorId(sensor.getId());
                temperatureService.insertTemperature(temperature);
            }else {
                SensorSlot sensorSlot = new SensorSlot();
                sensorSlot.setName(temperature.getSensorCode());
                sensorService.addSensorSlot(sensorSlot);
                sensorSlot = sensorService.getLastAddedSensorSlot();
                Sensor sensor = new Sensor();
                sensor.setModuleId(moduleId);
                sensor.setSensorCode(temperature.getSensorCode());
                sensor.setSensorSlot(sensorSlot.getId());
                Module module = moduleService.getModuleById(moduleId);
                if (module.getType().equals("temp_module")) {
                    sensor.setSensorType("T");
                }else if (module.getType().equals("dht11_module")) {
                    sensor.setSensorType("H");
                }
                sensorService.addNewSensor(sensor);
                sensor = sensorService.getSensorBySensorCode(temperature.getSensorCode());
                temperature.setSensorId(sensor.getId());
                temperatureService.insertTemperature(temperature);
            }
        });
    }

    public void insertHumidityToHub(Humidity humidity, int moduleId) {
        if (sensorService.getSensorsBySensorCode(humidity.getSensorCode()).size() > 0) {
            Sensor sensor = sensorService.getSensorBySensorCode(humidity.getSensorCode());
            humidity.setSensorId(sensor.getId());
            humidityService.insertHumidity(humidity);
        }else {
            SensorSlot sensorSlot = new SensorSlot();
            sensorSlot.setName(humidity.getSensorCode());
            sensorService.addSensorSlot(sensorSlot);
            sensorSlot = sensorService.getLastAddedSensorSlot();
            Sensor sensor = new Sensor();
            sensor.setModuleId(moduleId);
            sensor.setSensorCode(humidity.getSensorCode());
            sensor.setSensorSlot(sensorSlot.getId());
            Module module = moduleService.getModuleById(moduleId);
            if (module.getType().equals("temp_module")) {
                sensor.setSensorType("T");
            }else if (module.getType().equals("dht11_module")) {
                sensor.setSensorType("H");
            }
            sensorService.addNewSensor(sensor);
            sensor = sensorService.getSensorBySensorCode(humidity.getSensorCode());
            humidity.setSensorId(sensor.getId());
            humidityService.insertHumidity(humidity);

        }
    }

    public void insertSensors(List<Sensor> sensors, String moduleAddress) {
        sensors.forEach(sensor -> {
            sensor.setModuleId(moduleService.getModuleByAddress(moduleAddress).getId());
            sensorService.addNewSensor(sensor);
        });
    }
    private void deleteAllMeasurements(int moduleId) {
        sensorService.getAllSensorByModuleId(moduleId).forEach(sensorView -> {
            temperatureService.deleteTemperature(sensorView.getSensorId());
            humidityService.deleteHumidity(sensorView.getSensorId());
        });
    }

    private void deleteAllSensors(int moduleId) {
        sensorService.deleteSensors(moduleId);
    }

    public void deleteAllSensorsAndMeasurements(int moduleId) {
        deleteAllMeasurements(moduleId);
        deleteAllSensors(moduleId);
    }
}
