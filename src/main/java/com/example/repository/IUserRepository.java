package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.UserEntity;

public interface IUserRepository extends CrudRepository<UserEntity, Integer>{

}
