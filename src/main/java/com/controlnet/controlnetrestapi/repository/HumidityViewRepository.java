package com.controlnet.controlnetrestapi.repository;

import com.controlnet.controlnetrestapi.model.HumidityView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface HumidityViewRepository extends CrudRepository <HumidityView, Integer> {
    @Query(value = "select * from v_humidity where sensor_type = :sensor_type order by date asc", nativeQuery = true)
    Iterable<HumidityView> findAllBySensorType(@Param("sensor_type") String sensorType);

    @Query(value = "select * from v_humidity where sensor_type = :sensor_type and date >= :start and date <= :end", nativeQuery = true)
    Iterable<HumidityView> findAllBySensorTypeAndDate(@Param("sensor_type") String sensor_type, @Param("start") String start, @Param("end") String end);

    @Query(value = "select v_humidity.humidity_id,v_humidity.sensor_id, name, humidity, date, v_humidity.sensor_type from v_humidity  \n" +
            "  join sensors on sensors.id = v_humidity.sensor_id\n" +
            "where sensors.module_id = :module_id limit :sensor_cnt", nativeQuery = true)
    Iterable<HumidityView> findByModuleId(@Param("module_id") int moduleId, @Param("sensor_cnt") int sensorCnt);

    @Query(value = "select v_humidity.humidity_id,v_humidity.sensor_id, name, humidity, date, v_humidity.sensor_type from v_humidity  \n" +
            "  join sensors on sensors.id = v_humidity.sensor_id\n" +
            "where sensors.module_id = :module_id and date >= :start and date <= :end", nativeQuery = true)
    Iterable<HumidityView> findByModuleIdAndDate(@Param("module_id") int moduleId, @Param("start") String start, @Param("end") String end);
}
