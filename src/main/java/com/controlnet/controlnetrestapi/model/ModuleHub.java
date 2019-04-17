package com.controlnet.controlnetrestapi.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ModuleHub {
    private Module module;
    private ArrayList<TemperatureView> temperatures = new ArrayList<>();
    private ArrayList<HumidityView> humidityMeasurements = new ArrayList<>();
    private ArrayList<LightIntensityView> lightIntensityMeasurements = new ArrayList<>();

    public ModuleHub(Module module, Iterable<TemperatureView> temperatures){
        for (TemperatureView temperature : temperatures) {
            this.temperatures.add(temperature);
        }
        this.module = module;
    }

    public ModuleHub(Module module, Iterable<TemperatureView> temperatures, Iterable<HumidityView> humidityMeasurements, List<LightIntensityView> lightIntensityMeasurements){
        for (TemperatureView temperature: temperatures){
            this.temperatures.add(temperature);
        }
        for (HumidityView humidityMeasurement : humidityMeasurements){
            this.humidityMeasurements.add(humidityMeasurement);
        }
        for (LightIntensityView lightIntensityMeasurement : lightIntensityMeasurements){
            this.lightIntensityMeasurements.add(lightIntensityMeasurement);
        }
        this.module = module;
    }


     public ArrayList<TemperatureView> getTemperatures(){
        return temperatures;
    }
     public ArrayList<HumidityView> getHumidityMeasurements() {return humidityMeasurements; }
















}
