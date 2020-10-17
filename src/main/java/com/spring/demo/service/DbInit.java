package com.spring.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.spring.demo.model.User;
import com.spring.demo.repository.UserRepository;

@Service
public class DbInit implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User admin = new User("admin", "admin", "ADMIN", "");
		User customer = new User("customer", "customer", "CUSTOMER", "");
		
		List<User> users = Arrays.asList(admin, customer);
		userRepository.saveAll(users);
		
	}
}
