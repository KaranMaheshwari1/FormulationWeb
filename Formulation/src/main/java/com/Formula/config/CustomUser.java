package com.Formula.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Formula.Entity.UserRequest;

public class CustomUser implements UserDetails {

	private UserRequest userRequest;

	public CustomUser(UserRequest userRequest) {
		super();
		this.userRequest = userRequest;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRequest.getRole());
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return userRequest.getPassword();
	}

	@Override
	public String getUsername() {
		return userRequest.getEmail();
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
