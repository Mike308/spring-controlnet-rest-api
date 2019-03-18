package com.controlnet.controlnetrestapi.repository;

import com.controlnet.controlnetrestapi.model.SensorSlot;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SensorSlotRepository extends CrudRepository<SensorSlot, Integer> {
    @Modifying
    @Query(nativeQuery = true, value = "update sensor_slots set name = :slot_name where id = :slot_id")
    void setSlotName(@Param("slot_id") int id, @Param("slot_name") String slotName);
}






