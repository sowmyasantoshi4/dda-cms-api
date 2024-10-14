package com.cms.dda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Courier Management System API")
                                .description("API documentation for the Courier Management System")
                                .version("v1.0.0"))
                				.components(null);  // This will hide the schema section from the UI;
    }
}
