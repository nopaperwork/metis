package com.metis.nopaper.work.security.config;

import java.security.SecureRandom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.metis.nopaper.work.security.constant.SecurityConstant;
import com.metis.nopaper.work.security.jwt.JWTAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityApplicationConfig {

	private static final String[] SECURED_URLs = { "/ss/**" };

	private static final String[] UN_SECURED_URLs = { "/security/authenticate" };

    private final JWTAuthenticationFilter authenticationFilter;
    
    private final LogoutHandler logoutHandler;
    
    private final AuthenticationProvider authenticationProvider;
    
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http
//		.csrf().disable()
//		.cors().disable()
//		.authorizeHttpRequests()
//		.requestMatchers(SECURED_URLs).permitAll()
//		.anyRequest().permitAll();

		http
			.csrf().disable()
			.authorizeHttpRequests()
				.requestMatchers(UN_SECURED_URLs)
					.permitAll()
					.anyRequest().permitAll()
//			.and()
//			.authorizeHttpRequests()
//				.requestMatchers(SECURED_URLs)
//					.hasAnyAuthority("VIEW_PROFILE", "VIEW_DASHBOARD", "VIEW_REPORT")
//						.anyRequest().authenticated()
//					.hasAnyRole("ROLE_CLIENT_USER", "ROLE_METIS_ADMIN", "ROLE_MASTER", "ROLE_LEAD", "ROLE_CLIENT_ADMIN")
//						.anyRequest()
//						.authenticated()
			.and()
				.sessionManagement().
					sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authenticationProvider(authenticationProvider)
				.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
			.logout()
		        .logoutUrl("/security/api/v1/logout")
		        .addLogoutHandler(logoutHandler)
		        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
		        .logoutSuccessUrl("http://nopaper.work");

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(BCryptVersion.$2Y, SecurityConstant.BCRYPT_STRENGTH, new SecureRandom());
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
}
