package com.example.spring_boot_ms.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
