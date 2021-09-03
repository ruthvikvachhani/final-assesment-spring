package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.AnswerEntity;
import com.example.repository.IAnswerRepository;

@Service
public class AnswerService implements IAnswerService {

	@Autowired
	IAnswerRepository ansRepo;

	@Override
	public AnswerEntity createAnswer(AnswerEntity answer) {
		return ansRepo.save(answer);
	}

	@Override
	public Iterable<AnswerEntity> getAllAnswer() {
		return ansRepo.findAll();
	}

	@Override
	public Optional<AnswerEntity> getAnswer(Integer id) {
		return ansRepo.findById(id);
	}

	@Override
	public void deleteAnswer(Integer id) {
		ansRepo.deleteById(id);

	}

}
