package com.controlnet.controlnetrestapi.repository;

import com.controlnet.controlnetrestapi.model.Dictionary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DictionaryRepository extends CrudRepository <Dictionary, Integer> {
    int countByValue(String value);
    @Query(value = "select * from dictionary where val like '%_module'", nativeQuery = true)
    List<Dictionary> getModuleTypes();
}
