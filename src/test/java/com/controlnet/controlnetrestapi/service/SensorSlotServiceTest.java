package com.controlnet.controlnetrestapi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SensorSlotServiceTest {

    @Autowired
    private SensorService sensorService;


    private int getSizeOfIterable(Iterable<?> iterable){
        if (iterable instanceof Collection)
            return ((Collection<?>) iterable).size();
        int i = 0;
        for (Object object : iterable) i++;
        return i;
    }

    @Test
    public void testGetAllSensorByModuleId(){
        int size = getSizeOfIterable(sensorService.getAllSensorByModuleId(1));
        assertTrue("FAILED: "+size, size > 0);
    }

}
