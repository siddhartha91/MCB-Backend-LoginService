package com.mcb.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcb.app.entities.LoginResponse;
import com.mcb.app.entities.User;
import com.mcb.app.service.UserLoginService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("mcb/auth")
public class LoginController {

	
	@Autowired
	UserLoginService userLoginService;
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody User user) {
		LoginResponse user2 = userLoginService.userLogin(user);
		return user2;
	}
	
}
