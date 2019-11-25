package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.Dictionary;
import com.controlnet.controlnetrestapi.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryService {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    public List<Dictionary> getModuleTypes() {
       return dictionaryRepository.getModuleTypes();
    }


}
