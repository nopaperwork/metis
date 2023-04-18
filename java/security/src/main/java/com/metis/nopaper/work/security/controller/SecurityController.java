package com.metis.nopaper.work.security.controller;

import java.util.HashSet;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metis.nopaper.work.security.dto.RolesDTO;
import com.metis.nopaper.work.security.dto.UserAuthoritiesDTO;
import com.metis.nopaper.work.security.enums.EAuthority;
import com.metis.nopaper.work.security.enums.ERole;
import com.metis.nopaper.work.security.jwt.JWTService;
import com.metis.nopaper.work.security.models.Roles;
import com.metis.nopaper.work.security.models.UserAuthorities;
import com.metis.nopaper.work.security.models.UserSignInLog;
import com.metis.nopaper.work.security.models.Users;
import com.metis.nopaper.work.security.requests.LoginRequest;
import com.metis.nopaper.work.security.requests.SignupRequest;
import com.metis.nopaper.work.security.services.ISecurityService;
import com.metis.nopaper.work.security.utilities.SecureUtility;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("${v1API}")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SecurityController {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ISecurityService securityService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JWTService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityController.class);

	@PostMapping(value = { "userSignUp" }, produces = "application/json")
	public ResponseEntity<String> userSignUp(@Valid @RequestBody SignupRequest signupRequest,
			HttpServletRequest request) {

		ResponseEntity<String> response = null;
		try {

			/*
			 * SETTING username FOR USER DURING REGISTRATION
			 */
			String username = SecureUtility.generateUserCode(signupRequest.getEmail());
			/*
			 * SETTING PASSWORD AND ENCRYPTING FROM STANDARD FORM DATA INPUTS
			 */
			String hashedPassword = passwordEncoder.encode(signupRequest.getPassword());
			/*
			 * SETTING DEFAULT AUTHORITY FOR LEAD REGISTRATION
			 */
			HashSet<UserAuthorities> setDefaultAuthority = new HashSet<>();
			setDefaultAuthority.add(securityService.findByName(EAuthority.VIEW_PROFILE));
			/*
			 * MANAGING HEADER DATA. EXTRACTING IP AND USER AGENT INFORMATION GET USER-AGENT
			 * info from header
			 */
			Map<String, String> headerValue = SecureUtility.getHeaderValue(request);
			/*
			 * GET CLIENT IP ADDRESS
			 */
			String ipAddress = SecureUtility.getClientIpAddress(request);
			/*
			 * PREPARING USER INFORMATION FOR REGISTRATION
			 */
			Users postRequest = new Users();

			postRequest.setEmail(signupRequest.getEmail());
			postRequest.setMobile(signupRequest.getMobile());
			postRequest.setPassword(hashedPassword);
			postRequest.setUsername(username);
			postRequest.setRole(ERole.ROLE_LEAD);
			postRequest.setTimeZone(signupRequest.getTimeZone());
			postRequest.setDeviceCode(signupRequest.getDeviceCode());
			postRequest.setIp(ipAddress);
			postRequest.setUserAuthorities(setDefaultAuthority);
			postRequest.setHeaderValue(headerValue);

			Users savedUser = securityService.createUsers(postRequest);

			if (savedUser.getId() != null) {
				response = ResponseEntity.status(HttpStatus.CREATED)
						.body("Given user details are successfully registered");
			} else {
				response = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
						.body("Given user details already exists. Please try different credentials");
			}
		} catch (Exception ex) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An exception occured due to " + ex.getMessage());
		}
		return response;
	}

	@PostMapping(value = { "userSignIn" }, produces = "application/json")
	public ResponseEntity<String> userSignIn(
			@Valid @RequestBody LoginRequest loginRequest,
			HttpServletRequest request,
			HttpServletResponse response) {

		String accessToken;
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getIdentity(), loginRequest.getPassword()));

		if (authentication.isAuthenticated()) {
			
			accessToken = jwtService.generateToken(authentication.getName());
			
			Users users = (Users) authentication.getPrincipal();
			
			securityService.revokeAllUserTokens(users);
			securityService.saveUserToken(users, accessToken);
		    
			/*
			 * MANAGING HEADER DATA. EXTRACTING IP AND USER AGENT INFORMATION GET USER-AGENT
			 * info from header
			 */
			Map<String, String> headerValue = SecureUtility.getHeaderValue(request);
			/*
			 * GET CLIENT IP ADDRESS
			 */
			String ipAddress = SecureUtility.getClientIpAddress(request);
			/*
			 * LOGGING Successful Authentication
			 */
			UserSignInLog userSignInLog = new UserSignInLog();
			userSignInLog.setDeviceCode(loginRequest.getDeviceCode());
			userSignInLog.setEmail(users.getEmail());
			userSignInLog.setHeaderValue(headerValue);
			userSignInLog.setIp(ipAddress);
			userSignInLog.setMobile(users.getMobile());
			userSignInLog.setRole(users.getRole());
			userSignInLog.setStatus(users.getStatus());
			userSignInLog.setTimeZone(loginRequest.getTimeZone());
			userSignInLog.setUserId(users.getId());
			userSignInLog.setUsername(users.getUsername());
			userSignInLog.setIdentity(loginRequest.getIdentity());
			userSignInLog.setAccessToken(accessToken);

			securityService.createUserSignInLog(userSignInLog);
			
		} else {
			throw new UsernameNotFoundException("Invalid user credentials");
		}

		return new ResponseEntity<>(accessToken, HttpStatus.ACCEPTED);
	}

	@PostMapping(value = { "createUserRole" }, produces = "application/json")
	public ResponseEntity<RolesDTO> createUserRole(@RequestBody @Valid RolesDTO rolesDto) {

		Roles postRequest = mapper.map(rolesDto, Roles.class);
		Roles roles = securityService.saveRoles(postRequest);
		RolesDTO postResponse = mapper.map(roles, RolesDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@PostMapping(value = { "createUserAuthorities" }, produces = "application/json")
	public ResponseEntity<UserAuthoritiesDTO> createUserAuthorities(
			@RequestBody @Valid UserAuthoritiesDTO userAuthoritiesDTO) {

		UserAuthorities postRequest = mapper.map(userAuthoritiesDTO, UserAuthorities.class);
		UserAuthorities userAuthorities = securityService.createUserAuthorities(postRequest);
		UserAuthoritiesDTO postResponse = mapper.map(userAuthorities, UserAuthoritiesDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@PostMapping(value = { "userSignOut" }, produces = "application/json")
	public String userSignOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
}
