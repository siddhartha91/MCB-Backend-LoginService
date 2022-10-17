package com.mcb.app.controller;

import java.util.HashSet;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcb.app.entities.SignupRequest;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin("http://localhost:4200")
@RestController
@Slf4j
@RequestMapping("mcb/api")
public class ApplicationController {
	
	@GetMapping("/homepage")
	public String homePage() {
		log.info("homme page loaded..");
		return "<h1>Welcome in MCB Home page!</h1> ";
	}
	
	@GetMapping("/user")
	public SignupRequest user() {
		log.info("homme page loaded..");
		SignupRequest s =new SignupRequest();
		s.setUsername("s");
		s.setEmail("s");
		s.setPassword("s");
		HashSet ss = new HashSet<>();
		ss.add("A");
		ss.add("B");
		s.setRole(ss);
		return s;
	}
}
