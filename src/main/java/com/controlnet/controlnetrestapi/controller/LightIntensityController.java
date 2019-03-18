package com.controlnet.controlnetrestapi.controller;

import com.controlnet.controlnetrestapi.model.LightIntensityView;
import com.controlnet.controlnetrestapi.service.LightIntensityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/light-intensity/")
public class LightIntensityController {

    @Autowired
    private LightIntensityService lightIntensityService;

    @GetMapping("/module-id/{moduleId}/start-date/{startDate}/end-date/{endDate}")
    public List<LightIntensityView> getLightIntensityByModuleIdAndDate(@PathVariable String moduleId, @PathVariable String startDate, @PathVariable String endDate){
        return lightIntensityService.getLightIntensityByModuleIdAndDate(moduleId, startDate, endDate);
    }
}


