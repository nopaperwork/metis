package com.metis.nopaper.work.security.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metis.nopaper.work.security.jwt.JWTService;
import com.metis.nopaper.work.security.requests.LoginRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authenticate")
public class JWTController {
	
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping
    public String getTokenForAuthenticatedUser(@Valid @RequestBody LoginRequest authRequest){
    	
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getIdentity(), authRequest.getPassword()));
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getIdentity());
        }
        else {
            throw new UsernameNotFoundException("Invalid user credentials");
		}
	}
}