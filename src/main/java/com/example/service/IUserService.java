package com.example.service;

import java.util.Optional;

import com.example.entity.UserEntity;

public interface IUserService {

	UserEntity createUser(UserEntity user);
	
	Iterable<UserEntity> getAllUser();
	
	Optional<UserEntity> getUser(Integer id);
	
	void deleteUser(Integer id);
}
