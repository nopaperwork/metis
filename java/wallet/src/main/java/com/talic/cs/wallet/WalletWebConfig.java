package com.talic.cs.wallet;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.talic.cs.wallet.config.CustomInterceptor;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@EnableWebMvc
@Configuration
@OpenAPIDefinition
public class WalletWebConfig implements WebMvcConfigurer {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public OpenAPI baseOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("TALIC - Wallet Project")
						.version("1.0.0")
				.description("Secure Access to Wallet - MicroService for NoPaperWork")
				.license(new License()
						.name("Apache 2.0")
						.url("http://springdoc.org")));
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CustomInterceptor());
	}
	
}