package com.controlnet.controlnetrestapi.repository;

import com.controlnet.controlnetrestapi.model.LightIntensity;
import org.springframework.data.repository.CrudRepository;

public interface LightIntensityRepository extends CrudRepository<LightIntensity, Integer> {
    void deleteBySensorId(int sensorId);
}
