package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.modal.User;
import com.masai.service.AdminService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/register")
	public ResponseEntity<User> createAdminHandler(@Valid @RequestBody User user){
		User use=adminService.createAdmin(user);
		return new ResponseEntity<>(use,HttpStatus.CREATED);
		
	}
	
}
