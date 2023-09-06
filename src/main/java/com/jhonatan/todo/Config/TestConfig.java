package com.jhonatan.todo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jhonatan.todo.service.DbService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DbService service;

    @Bean
    void instaciaDB() {
		this.service.instaciaDB();
	}

}
