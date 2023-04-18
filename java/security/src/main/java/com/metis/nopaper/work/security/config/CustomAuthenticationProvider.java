package com.metis.nopaper.work.security.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.metis.nopaper.work.security.models.UserAuthorities;
import com.metis.nopaper.work.security.models.Users;
import com.metis.nopaper.work.security.models.repositories.UsersRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UsersRepository usersRepository;

	@Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		Optional<Users> optionalUsers = usersRepository.getUserDetails(authentication.getName());

		if (optionalUsers.isPresent())
		{
			Users users = optionalUsers.get();
			if (passwordEncoder.matches(authentication.getCredentials().toString(), users.getPassword()))
			{
				return new UsernamePasswordAuthenticationToken(users, authentication.getCredentials().toString(), getGrantedAuthorities(optionalUsers.get().getUserAuthorities()));
			} else {
				throw new BadCredentialsException("Invalid username or password");
			}
		} else {
			throw new BadCredentialsException("Invalid username or password");
		}
	}

	private List<GrantedAuthority> getGrantedAuthorities(Set<UserAuthorities> userAuthorities) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (UserAuthorities authority : userAuthorities)
		{
			grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName().name()));
		}
		return grantedAuthorities;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
