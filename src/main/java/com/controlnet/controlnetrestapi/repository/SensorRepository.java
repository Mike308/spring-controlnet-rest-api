package com.controlnet.controlnetrestapi.repository;

import com.controlnet.controlnetrestapi.model.Sensor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends CrudRepository <Sensor, Integer> {
    Sensor getSensorBySensorCode(String code);
    void deleteByModuleId(int moduleId);
    List<Sensor> findAllBySensorCode(String sensorCode);
}
