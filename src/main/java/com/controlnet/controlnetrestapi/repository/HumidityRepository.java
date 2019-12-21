package com.controlnet.controlnetrestapi.repository;

import com.controlnet.controlnetrestapi.model.Humidity;
import org.springframework.data.repository.CrudRepository;

public interface HumidityRepository extends CrudRepository <Humidity, Integer> {
    void deleteBySensorId(int sensorId);
}
