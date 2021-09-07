package com.example.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.entity.UserEntity;
import com.example.exception.NotFoundException;
import com.example.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@GetMapping("")
	public String Welcome() {
		return "Welcome to the app";
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> createUser(@RequestBody UserEntity user) {
		
		UserEntity createUser = userService.createUser(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createUser.getUserId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/user")
	public Iterable<UserEntity> getAllUser() {
		return userService. getAllUser();
	}
	
	@GetMapping("/user/{id}")
	public EntityModel<Optional<UserEntity>> getUser(@PathVariable Integer id) {
		Optional<UserEntity> user = userService. getUser(id);
		if (user.isEmpty()) {
			throw new NotFoundException("USER with id"+-id);
		}
		EntityModel<Optional<UserEntity>> model = EntityModel.of(user);
		
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).getAllUser());
		
		model.add(linkToUsers.withRel("all-users"));
		return model;
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteQuestion(@PathVariable Integer id) {
		userService.deleteUser(id);
	}
	
}
