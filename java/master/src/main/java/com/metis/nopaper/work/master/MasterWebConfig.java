package com.metis.nopaper.work.master;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@EnableWebMvc
@Configuration
@OpenAPIDefinition
public class MasterWebConfig implements WebMvcConfigurer {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public OpenAPI baseOpenAPI() {
		return new OpenAPI().info(new Info().title("Master - No Paper Work").version("1.0.0").description("Master Microservice for no-paper-work"));
	}

}
