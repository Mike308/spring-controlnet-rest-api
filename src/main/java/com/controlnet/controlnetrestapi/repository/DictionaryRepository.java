package com.controlnet.controlnetrestapi.repository;

import com.controlnet.controlnetrestapi.model.Dictionary;
import org.springframework.data.repository.CrudRepository;

public interface DictionaryRepository extends CrudRepository <Dictionary, Integer> {
}
