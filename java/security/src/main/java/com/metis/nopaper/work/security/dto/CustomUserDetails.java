package com.metis.nopaper.work.security.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.metis.nopaper.work.security.models.UserAuthorities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CustomUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1031347204762123096L;

	@NotBlank
	@Size(min=6, message="Password should have atleast 8 characters")
	private String username;
	
	@Email
	@Pattern(regexp=".+@.+\\..+", message="Wrong email!")
	private String email;
	
	private String mobile;
	
	@NotBlank
	@Size(min=6, message="Password should have atleast 8 characters")
	private String password;
	private String role;
	private Set<UserAuthorities> userAuthorities = new HashSet<>();
	private String deviceCode = "-";
	private String ip = "-";
	private String timeZone = "-";
    private Map<String, String> headerValue;
	
	/*
	 * IMPLEMENTING USER DETAIL SERVICE
	 */
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (UserAuthorities authority : userAuthorities) {
			grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName().name()));
		}
		return grantedAuthorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
