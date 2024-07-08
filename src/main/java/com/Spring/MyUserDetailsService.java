package com.Spring;


import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService
{
	@Autowired
	UserRepository usrepo;
	

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				
		
		User us = usrepo.findByUserName(username);
		
		
		return new MyUserInfo(us);
	}

	
	public void saveUser(Request request) {
	if (usrepo.findByUserName(request.getEmail())!=null ) {
			throw new RuntimeException("User already exists");
		}

		User user = new User();
		user.setUserName(request.getEmail());
		user.setUserPass(request.getPassword());

		
		
	    
	    usrepo.save(user);
	    
	}
	
	
}
