package com.controlnet.controlnetrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.controlnet.controlnetrestapi.repository")
@SpringBootApplication
public class ControlnetRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlnetRestApiApplication.class, args);
    }
}
