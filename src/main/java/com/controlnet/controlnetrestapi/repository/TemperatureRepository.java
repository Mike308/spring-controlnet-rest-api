package com.controlnet.controlnetrestapi.repository;

import com.controlnet.controlnetrestapi.model.Temperature;
import org.springframework.data.repository.CrudRepository;

public interface TemperatureRepository extends CrudRepository <Temperature, Integer> {
    Temperature findFirstByOrderByIdDesc();
}
