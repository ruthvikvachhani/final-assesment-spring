package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.QuestionEntity;
import com.example.repository.IQuestionRepository;

@Service
public class QuestionService implements IQuestionService{

	@Autowired
	IQuestionRepository queRepo;
	
	@Override
	public QuestionEntity createQuestion(QuestionEntity que) {
		return queRepo.save(que);
	}

	@Override
	public Iterable<QuestionEntity> getAllQuestion() {
		return queRepo.findAll();
	}

	@Override
	public Optional<QuestionEntity> getQuestion(Integer queId) {
		return queRepo.findById(queId);
	}

	@Override
	public void deleteQuestion(Integer queId) {
		queRepo.deleteById(queId);
	}

	@Override
	public void upvote(QuestionEntity ques, Integer id) {
		Optional<QuestionEntity> question = queRepo.findById(id);
		int vote=  question.get().getVote();
		question.get().setVote(vote+1);
		
	}

	
}
