package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UserEntity;
import com.example.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@PostMapping("/user")
	public UserEntity createUser(@RequestBody UserEntity user) {
		return userService.createUser(user);
	}

	@GetMapping("/user")
	public Iterable<UserEntity> getAllUser() {
		return userService. getAllUser();
	}
	
	@GetMapping("/user/{id}")
	public Optional<UserEntity> getUser(@PathVariable Integer id) {
		return userService. getUser(id);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteQuestion(@PathVariable Integer id) {
		userService.deleteUser(id);
	}
	
}
