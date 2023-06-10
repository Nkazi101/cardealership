package com.cardealership.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration

@EnableJpaRepositories(basePackages= "com.cardealership.repositories")

@EntityScan(basePackages="com.cardealership.models")

public class ApplicationConfig {
    
}
