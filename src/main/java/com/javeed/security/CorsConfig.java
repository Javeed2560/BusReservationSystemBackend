package com.javeed.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	
	@Bean(name= "corsConfigurerBean")
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCrosMapping(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:8080")
						.allowedHeaders("GET","POST","PUT","DELET", "OPTIONS")
						.allowedHeaders("*")
						.allowCredentials(true);
			}
		};
	}

}
