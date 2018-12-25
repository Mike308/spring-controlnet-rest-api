package com.controlnet.controlnetrestapi.repository;

import com.controlnet.controlnetrestapi.model.SensorView;
import org.springframework.data.repository.CrudRepository;

public interface SensorRepository extends CrudRepository <SensorView, Integer> {
    Iterable<SensorView> getAllById(int id);
}