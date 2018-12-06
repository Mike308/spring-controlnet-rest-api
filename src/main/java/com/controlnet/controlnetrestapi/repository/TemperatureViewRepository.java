package com.controlnet.controlnetrestapi.repository;

import com.controlnet.controlnetrestapi.model.TemperatureView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TemperatureViewRepository extends CrudRepository <TemperatureView, Integer> {

    @Query(value = "select * from v_temperatures where date >= :start and date <= :end and sensor_type = :sensor_type order by date asc", nativeQuery = true)
    Iterable<TemperatureView> findAllByDateAAndDateAndSensorType(@Param("start") String start, @Param("end") String end, @Param("sensor_type") String sensorType);

    @Query(value = "select * from v_temperatures where sensor_type = :sensor_type", nativeQuery = true)
    Iterable<TemperatureView> findAllBySensorType(@Param("sensor_type") String sensorType);

    @Query(value = "select v_temperatures.id,\n" +
            "       name,\n" +
            "       temperature,\n" +
            "       date,\n" +
            "       v_temperatures.sensor_type\n" +
            "  from v_temperatures\n" +
            "  join sensors on sensors.id = v_temperatures.id\n" +
            "where sensors.module_id = :module_id limit 6", nativeQuery = true)
    Iterable<TemperatureView> findByModuleId(@Param("module_id") int module_id);
}
