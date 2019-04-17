package com.controlnet.controlnetrestapi.repository;

import com.controlnet.controlnetrestapi.model.LightIntensityView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface LightIntensityRepository extends CrudRepository<LightIntensityView, Integer> {
    @Query(nativeQuery = true, value = "select\n" +
            "  v_light_intensity.id,v_light_intensity.sensor_type,v_light_intensity.name,\n" +
            "  v_light_intensity.light_intensity,\n" +
            "  v_light_intensity.date\n" +
            "from v_light_intensity\n" +
            "  join sensors on v_light_intensity.sensor_id = sensors.id\n" +
            "where sensors.module_id = :module_id and date >= :start_date and date <= :end_date" +
            " order by v_light_intensity.date asc")
    List<LightIntensityView> getLightIntensityByModuleIdAndDate(@Param("module_id")String moduleId, @Param("start_date") String startDate, @Param("end_date") String endDate);

    @Query(nativeQuery = true, value = "select\n" +
            "  v_light_intensity.id,v_light_intensity.sensor_type,v_light_intensity.name,v_light_intensity.sensor_id,\n" +
            "  v_light_intensity.light_intensity,\n" +
            "  v_light_intensity.date\n" +
            "from v_light_intensity\n" +
            "  join sensors on v_light_intensity.sensor_id = sensors.id\n" +
            "where sensors.module_id = :module_id limit  :cnt")
    List<LightIntensityView> getLightIntensityByModuleId(@Param("module_id") String moduleId, @Param("cnt") int sensorCnt);
}


