package com.metis.nopaper.work.security.jwt;

import java.io.IOException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.metis.nopaper.work.security.dto.CustomUserDetails;
import com.metis.nopaper.work.security.models.Users;
import com.metis.nopaper.work.security.models.repositories.UsersRepository;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

	private final JWTService jwtService;
	private final UsersRepository usersRepository;
	private final ModelMapper mapper;

	@Override
	protected void doFilterInternal(
			@NonNull HttpServletRequest request, 
			@NonNull HttpServletResponse response, 
			@NonNull FilterChain filterChain)
			throws ServletException, IOException {

		String authHeader = request.getHeader("Authorization");
		String token = null;
		String userName = null;
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7);
			userName = jwtService.extractUsernameFromToken(token);
		}
		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			Optional<Users> optionalUsers = usersRepository.getUserDetails(userName);
			if (optionalUsers.isPresent()) {
				Users users = optionalUsers.get();
				CustomUserDetails customUserDetails = mapper.map(users, CustomUserDetails.class);
				if (Boolean.TRUE.equals(jwtService.validateToken(token, customUserDetails))) {
					var authToken = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			} else {
				throw new UsernameNotFoundException("Invalid user credentials");
			}

		}
		filterChain.doFilter(request, response);
	}
}