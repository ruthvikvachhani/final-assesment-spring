package com.example.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.QuestionEntity;
import com.example.service.IQuestionService;

@RestController
public class QuestionController {

	@Autowired
	IQuestionService queService;

	@PostMapping("/que")
	public QuestionEntity createQuestion(@RequestBody QuestionEntity ques) {
		return queService.createQuestion(ques);
	}

	@GetMapping("/que")
	public Iterable<QuestionEntity> getAllQuestion() {
		return queService.getAllQuestion();
	}

	@GetMapping("/que/{id}")
	public Optional<QuestionEntity> getQuestion(@PathVariable Integer id) {
		return queService.getQuestion(id);
	}

	@DeleteMapping("/que/{id}")
	public void deleteQuestion(@PathVariable Integer id) {
		queService.deleteQuestion(id);
	}

	@PutMapping("/que/increment/{id}")
	public void upvote(@RequestBody QuestionEntity ques ,@PathVariable Integer id) {
		queService.upvote(ques,id);
	}
}
