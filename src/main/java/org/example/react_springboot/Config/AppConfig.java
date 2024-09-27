package org.example.react_springboot.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // ModelMapper
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
