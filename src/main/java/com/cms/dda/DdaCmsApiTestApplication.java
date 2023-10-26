package com.cms.dda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Courier Management System API",version = "2.0",description = "Courier Management System"))
public class DdaCmsApiTestApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DdaCmsApiTestApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DdaCmsApiTestApplication.class, args);
	}

}
