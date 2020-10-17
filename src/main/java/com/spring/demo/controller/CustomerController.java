package com.spring.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@GetMapping
	static public String hello() {
		return "hello customer";
	}
	
	@GetMapping("/vip")
	static public String helloVip() {
		return "hello vip";
	}
}
