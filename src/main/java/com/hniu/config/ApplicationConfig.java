package com.hniu.config;

import com.hniu.entity.System;
import com.hniu.mapper.SystemMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class ApplicationConfig {


    @Bean
    public System system(SystemMapper sm) {
        try {
            List<System> systems = sm.selectAll();
            System system = systems.get(0);
            return system;
        } catch (Exception e) {
            return new System(1, "图书管理系统", "/img/icon.icon", new Byte("10"), "appid", "appsecret", "HNIUBS");
        }
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8080", "http://127.0.0.1:8020")
                        .allowedMethods("*").allowCredentials(true);
            }
        };
    }
}
