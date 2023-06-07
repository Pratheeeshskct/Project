package org.libre.com.controller;

import org.libre.com.dto.LoginDto;
import org.libre.com.payload.LoginMessage;
import org.libre.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	public UserService service;
	
	@PostMapping("/login")
	public LoginMessage Login(@RequestBody LoginDto user) {
		return service.loginUser(user);
	}
}
