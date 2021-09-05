package com.example.service;


import java.util.Optional;

import com.example.entity.QuestionEntity;

public interface IQuestionService {

	QuestionEntity createQuestion(QuestionEntity que);
	
	Iterable<QuestionEntity> getAllQuestion();

	Optional<QuestionEntity> getQuestion(Integer id);
	
	void deleteQuestion(Integer id);
	
	void upvote(Integer id);
}
