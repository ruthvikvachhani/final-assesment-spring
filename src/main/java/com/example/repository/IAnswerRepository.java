package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.AnswerEntity;

public interface IAnswerRepository extends CrudRepository<AnswerEntity, Integer> {

}
