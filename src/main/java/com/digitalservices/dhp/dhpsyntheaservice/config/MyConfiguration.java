package com.digitalservices.dhp.dhpsyntheaservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfiguration {
    @Value("${origins.url}")
    private String url;
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/synthea/**").allowedOrigins(url)
                        .allowedMethods("GET", "OPTIONS", "POST", "HEAD");
                System.out.println(url);
            }
        };
    }
}