package com.cms.dda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DdaCmsApiTestApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DdaCmsApiTestApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DdaCmsApiTestApplication.class, args);
	}

}
