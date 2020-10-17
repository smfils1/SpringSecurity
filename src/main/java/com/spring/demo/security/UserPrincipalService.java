package com.spring.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.demo.model.User;
import com.spring.demo.repository.UserRepository;

public class UserPrincipalService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		UserPrincipal userPrincipal = new UserPrincipal(user);
		return userPrincipal;
	}
	
	
}
