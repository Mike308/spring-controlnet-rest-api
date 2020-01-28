package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.LightIntensity;
import com.controlnet.controlnetrestapi.model.LightIntensityView;
import com.controlnet.controlnetrestapi.repository.LightIntensityRepository;
import com.controlnet.controlnetrestapi.repository.LightIntensityViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LightIntensityService {
    @Autowired
    private LightIntensityViewRepository lightIntensityViewRepository;

    @Autowired
    private LightIntensityRepository lightIntensityRepository;

    public List<LightIntensityView> getLightIntensityByModuleIdAndDate(String moduleId, String startDate, String endDate){
        return lightIntensityViewRepository.getLightIntensityByModuleIdAndDate(moduleId, startDate, endDate);
    }

    public List<LightIntensityView> getLightIntensityByModuleId(String moduleId, int sensorCnt){
        return lightIntensityViewRepository.getLightIntensityByModuleId(moduleId, sensorCnt);
    }

    public void insertNewLightIntensity(LightIntensity lightIntensity) {
        lightIntensityRepository.save(lightIntensity);
    }

    @Transactional
    public void deleteAllMeasurements(int sensorId) {
        lightIntensityRepository.deleteBySensorId(sensorId);
    }
}
