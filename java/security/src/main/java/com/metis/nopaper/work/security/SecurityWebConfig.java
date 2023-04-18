package com.metis.nopaper.work.security;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.metis.nopaper.work.security.config.CustomInterceptor;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@EnableWebMvc
@Configuration
@OpenAPIDefinition
public class SecurityWebConfig implements WebMvcConfigurer {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public OpenAPI baseOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Secure - No Paper Work")
						.version("1.0.0")
				.description("Secure Authentication and Authorization MicroService for NoPaperWork")
				.license(new License()
						.name("Apache 2.0")
						.url("http://springdoc.org")));

//		.externalDocs(new ExternalDocumentation()
//                .description("noPaperWork Wiki Documentation")
//                .url("https://github.org/docs"));
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CustomInterceptor());
	}
}
