package com.dcl.config;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.core.model.Model;

@Configuration
public class AppConfig {
	
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
		
	}

}
