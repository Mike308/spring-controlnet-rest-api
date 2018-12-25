package com.controlnet.controlnetrestapi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HumidityServiceTest {
    @Autowired
    private HumidityService humidityService;

    private int getSizeOfIterable(Iterable<?> iterable){
        if (iterable instanceof Collection)
            return ((Collection<?>) iterable).size();
        int i = 0;
        for (Object object : iterable) i++;
        return i;
    }

    @Test
    public void testGetHumidityBySensorType(){
        int size = getSizeOfIterable(humidityService.getHumidityMeasurementsBySensorType("H"));
        assertTrue("FAILED: "+size, size > 0);
    }

    @Test
    public void testGetHumidityBySensorTypeAndDate(){
        int size = getSizeOfIterable(humidityService.getHumidityMeasurementsBySensorTypeAndDate("H", "2018-11-18 11:15:00", "2018-11-18 12:00:00"));
        assertTrue("FAILED: "+size, size > 0);
    }

    @Test
    public void testGetHumidityBySensorModule(){
        int size = getSizeOfIterable(humidityService.getHumidityMeasurementsByModuleId(5, 1));
        assertTrue("FAILED: "+size, size == 1);
    }
}
