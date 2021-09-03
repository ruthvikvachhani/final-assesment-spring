package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.UserEntity;
import com.example.repository.IUserRepository;

@Service
public class UserService implements IUserService{
	
	@Autowired
	IUserRepository userRepo;

	@Override
	public UserEntity createUser(UserEntity user) {
		return userRepo.save(user);
	}

	@Override
	public Iterable<UserEntity> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public Optional<UserEntity> getUser(Integer id) {
		return userRepo.findById(id);
	}

	@Override
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);
	}

}
