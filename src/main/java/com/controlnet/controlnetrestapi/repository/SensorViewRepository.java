package com.controlnet.controlnetrestapi.repository;

import com.controlnet.controlnetrestapi.model.SensorView;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SensorViewRepository extends CrudRepository <SensorView, Integer> {
    List<SensorView> getAllById(int id);
    SensorView getAllBySensorId(int sensorId);
}
