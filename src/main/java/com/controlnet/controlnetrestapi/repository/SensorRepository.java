package com.controlnet.controlnetrestapi.repository;

import com.controlnet.controlnetrestapi.model.Sensor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends CrudRepository <Sensor, Integer> {

}
