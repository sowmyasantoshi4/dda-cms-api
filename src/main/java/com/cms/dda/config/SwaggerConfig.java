package com.cms.dda.config;

/*
@Configuration
public class SwaggerConfig implements WebMvcConfigurer  {                                    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
          		.addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
          		.addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
    
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and()
                .authorizeRequests().antMatchers("/actuator/**").permitAll()
                .and().authorizeRequests().antMatchers("/swagger-ui/**").permitAll()
                .and().authorizeRequests().antMatchers("/v3/api-docs/**").permitAll();
        return http.build();
}

}
*/