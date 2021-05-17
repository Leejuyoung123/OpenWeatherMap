package com.weather;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan(basePackages = { "com.weather.mapper" })

public class OpenWeatherMapApplication {
	public static void main(String[] args) {
		SpringApplication.run(OpenWeatherMapApplication.class, args);
		
		
		
	}

}
