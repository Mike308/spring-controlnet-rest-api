package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.LightIntensityView;
import com.controlnet.controlnetrestapi.repository.LightIntensityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LightIntensityService {
    @Autowired
    private LightIntensityRepository lightIntensityRepository;

    public List<LightIntensityView> getLightIntensityByModuleIdAndDate(String moduleId, String startDate, String endDate){
        return lightIntensityRepository.getLightIntensityByModuleIdAndDate(moduleId, startDate, endDate);
    }

    public List<LightIntensityView> getLightIntensityByModuleId(String moduleId, int sensorCnt){
        return lightIntensityRepository.getLightIntensityByModuleId(moduleId, sensorCnt);
    }
}
