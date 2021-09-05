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
	public void upvote(Integer id) {
		Optional<QuestionEntity> question = queRepo.findById(id);
		QuestionEntity ques =  question.get();
		System.out.println(ques.getVote());
		ques.setVote(ques.getVote()+1);
		queRepo.save(ques);
		
		System.out.println(ques.getVote());
	}

	
}
