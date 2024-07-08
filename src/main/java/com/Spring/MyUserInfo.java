package com.Spring;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


public class MyUserInfo implements UserDetails
{
	private String username;
	private String password;	
	private List<GrantedAuthority> auth;
	
	
	public MyUserInfo(User us)
	{
		this.username = us.getUserName();
		this.password = us.getUserPass();
			
		auth = us.getUserRoles().stream().map(r->{
		 return new SimpleGrantedAuthority(r.getRole());
		 }).collect(Collectors.toList());
		
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return auth;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
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
