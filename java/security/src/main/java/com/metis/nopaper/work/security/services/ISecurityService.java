package com.metis.nopaper.work.security.services;

import java.util.Optional;

import com.metis.nopaper.work.security.enums.EAuthority;
import com.metis.nopaper.work.security.models.Roles;
import com.metis.nopaper.work.security.models.UserAuthorities;
import com.metis.nopaper.work.security.models.UserSignInLog;
import com.metis.nopaper.work.security.models.Users;
import com.metis.nopaper.work.security.requests.LoginRequest;

public interface ISecurityService {

	Users createUsers(Users postRequest);

	Optional<Users> findByUsername(String name);

	Roles saveRoles(Roles postRequest);

	UserAuthorities findByName(EAuthority viewProfile);

	UserAuthorities createUserAuthorities(UserAuthorities postRequest);

	Optional<Users> getUserDetails(LoginRequest loginRequest);

	UserSignInLog createUserSignInLog(UserSignInLog userSignInLog);
	
	void revokeAllUserTokens(Users users);
	
	void saveUserToken(Users users, String accessToken);

}
