package com.controlnet.controlnetrestapi.component;

import com.controlnet.controlnetrestapi.model.Dictionary;
import com.controlnet.controlnetrestapi.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DictionaryComponent {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    @PostConstruct
    public void fillDictionary() {
        Dictionary temperatureSensor = new Dictionary();
        temperatureSensor.setDescription("DS18B20");
        temperatureSensor.setValue("T");

        Dictionary temperatureModule = new Dictionary();
        temperatureModule.setValue("temp_module");
        temperatureModule.setDescription("Temperature module");

        Dictionary humiditySensor = new Dictionary();
        humiditySensor.setValue("H");
        humiditySensor.setDescription("DHT11");

        Dictionary dht11Module = new Dictionary();
        dht11Module.setValue("dht11_module");
        dht11Module.setDescription("DHT11 Module");

        Dictionary lxSensor = new Dictionary();
        lxSensor.setValue("LX");
        lxSensor.setDescription("BH750");

        Dictionary lxModule = new Dictionary();
        lxModule.setValue("lx_module");
        lxModule.setDescription("Lx Module");

        insertIfNotExists(temperatureModule);
        insertIfNotExists(temperatureSensor);
        insertIfNotExists(humiditySensor);
        insertIfNotExists(humiditySensor);
        insertIfNotExists(lxSensor);
        insertIfNotExists(lxModule);
    }

    private void insertIfNotExists(Dictionary dictionary) {
        if (dictionaryRepository.countByValue(dictionary.getValue()) == 0) {
            dictionaryRepository.save(dictionary);
        }
    }
}
