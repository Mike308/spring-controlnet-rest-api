package com.controlnet.controlnetrestapi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;


import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemperatureServiceTest {
    @Autowired
    private TemperatureService temperatureService;

       private int getSizeOfIterable(Iterable<?> iterable){
        if (iterable instanceof Collection)
            return ((Collection<?>) iterable).size();
        int i = 0;
        for (Object object : iterable) i++;
        return i;
    }

    @Test
    public void testGetAllTemperaturesBySensorType(){
        int size = getSizeOfIterable(temperatureService.getAllTemperaturesBySensorType("T"));
        assertTrue("FAILED: "+size, size > 0);
    }

    @Test
    public  void testGetAllTemperaturesBySensorTypeAndDate(){
        int size = getSizeOfIterable(temperatureService.getTemperaturesBySensorTypeAndDate("T", "2018-11-18 10:28", "2018-11-18 10:40"));
        assertTrue("FAILED: "+size, size > 0);
    }

    @Test
    public void testGetLastTemperatureByModuleId(){
        int size =getSizeOfIterable(temperatureService.getLastTemperaturesByModuleId(1));
        assertTrue("FAILED: "+size, size > 0);
    }
}
