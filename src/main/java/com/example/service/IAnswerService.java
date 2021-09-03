package com.example.service;

import java.util.Optional;

import com.example.entity.AnswerEntity;

public interface IAnswerService {

	AnswerEntity createAnswer(AnswerEntity answer);
	
	Iterable<AnswerEntity> getAllAnswer();
	
	Optional<AnswerEntity> getAnswer(Integer id);
	
	void deleteAnswer(Integer id);
}
