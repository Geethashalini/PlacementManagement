package com.geetha.pms.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

/**
 * Configuration class to customize Jackson's ObjectMapper.
 */
@Configuration
public class JacksonConfig {

    /**
     * Registers a custom ObjectMapper bean to handle Hibernate lazy-loaded entities.
     *
     * @return customized ObjectMapper
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        // Register Hibernate5Module to handle lazy-loading with Hibernate
        objectMapper.registerModule(new Hibernate5Module());
        return objectMapper;
    }
}
