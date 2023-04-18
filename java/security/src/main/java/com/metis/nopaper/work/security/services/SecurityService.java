package com.metis.nopaper.work.security.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metis.nopaper.work.security.enums.EAuthority;
import com.metis.nopaper.work.security.enums.TokenType;
import com.metis.nopaper.work.security.models.Roles;
import com.metis.nopaper.work.security.models.UserAuthorities;
import com.metis.nopaper.work.security.models.UserSignInLog;
import com.metis.nopaper.work.security.models.UserToken;
import com.metis.nopaper.work.security.models.Users;
import com.metis.nopaper.work.security.models.repositories.AuthorityRepository;
import com.metis.nopaper.work.security.models.repositories.RoleRepository;
import com.metis.nopaper.work.security.models.repositories.UserSignInLogRepository;
import com.metis.nopaper.work.security.models.repositories.UserTokenRepository;
import com.metis.nopaper.work.security.models.repositories.UsersRepository;
import com.metis.nopaper.work.security.requests.LoginRequest;

@Service
public class SecurityService implements ISecurityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityService.class);

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	@Autowired
	private UserSignInLogRepository userSignInLogRepository;
	
	@Autowired
	private UserTokenRepository userTokenRepository;

	public Roles saveRoles(Roles postRequest) {
		return roleRepository.saveAndFlush(postRequest);
	}

	@Override
	public Users createUsers(Users postRequest) {
		return usersRepository.saveAndFlush(postRequest);
	}

	@Override
	public Optional<Users> findByUsername(String name) {
		return usersRepository.findByUsername(name);
	}

	@Override
	public UserAuthorities findByName(EAuthority viewProfile) {
		return authorityRepository.findByName(viewProfile);
	}

	@Override
	public UserAuthorities createUserAuthorities(UserAuthorities postRequest) {
		return authorityRepository.saveAndFlush(postRequest);
	}

	@Override
	public Optional<Users> getUserDetails(LoginRequest loginRequest) {
		return usersRepository.getUserDetails(loginRequest.getIdentity());
	}

	@Override
	public UserSignInLog createUserSignInLog(UserSignInLog userSignInLog) {
		return userSignInLogRepository.saveAndFlush(userSignInLog);
	}
	
	@Override
	public void revokeAllUserTokens(Users users) {
	    var validUserTokens = userTokenRepository.findAllValidTokenByUser(users.getId());
	    if (validUserTokens.isEmpty())
	      return;
	    validUserTokens.forEach(token -> {
	      token.setExpired(true);
	      token.setRevoked(true);
	    });
	    userTokenRepository.saveAll(validUserTokens);
	  }
	
	@Override
	public void saveUserToken(Users users, String accessToken) {
	    var token = UserToken.builder()
	        .users(users)
	        .token(accessToken)
	        .tokenType(TokenType.BEARER)
	        .expired(false)
	        .revoked(false)
	        .build();
	    userTokenRepository.save(token);
	  }

}
