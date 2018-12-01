package com.controlnet.controlnetrestapi.service;

import com.controlnet.controlnetrestapi.model.Module;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModuleServiceTest {
    @Autowired
    private ModuleService moduleService;

    @Test
    public void testFindAll(){
        int currentSize = getSizeOfIterable(moduleService.getAllModules());
        assertEquals(2, currentSize);
    }

    @Test
    public void testGetModuleByType(){
        Module expectedModule = new Module();
        expectedModule.setId(1);
        expectedModule.setName("Temperature Module");
        expectedModule.setType("temp_module");
        expectedModule.setAddress("0");
        assertEquals(expectedModule.getName(), moduleService.getModuleByType("temp_module").getName());
    }

    @Test
    public void testGetModuleById(){
        assertEquals("temp_module", moduleService.getModuleById(1).getType());
    }

    @Test
    public void testGetModuleByAddress(){
        assertEquals("temp_module", moduleService.getModuleByAddress("0").getType());
    }


    private int getSizeOfIterable(Iterable<?> iterable){
        if (iterable instanceof Collection)
            return ((Collection<?>) iterable).size();
        int i = 0;
        for (Object object : iterable) i++;
        return i;
    }


}
