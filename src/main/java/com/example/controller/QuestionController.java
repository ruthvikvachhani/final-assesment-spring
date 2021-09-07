package com.example.controller;


import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.entity.QuestionEntity;
import com.example.exception.NotFoundException;
import com.example.service.IQuestionService;

@RestController
public class QuestionController {

	@Autowired
	IQuestionService queService;

	@PostMapping("/que")
	public ResponseEntity<Object> createQuestion(@RequestBody QuestionEntity ques) {
		QuestionEntity createQuestion = queService.createQuestion(ques);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createQuestion.getQueId()).toUri();
		return ResponseEntity.created(location).build();
	}

	
	
	@GetMapping("/que")
	public Iterable<QuestionEntity> getAllQuestion() {
		return queService.getAllQuestion();
	}

	@GetMapping("/que/{id}")
	public Optional<QuestionEntity> getQuestion(@PathVariable Integer id) {
		Optional<QuestionEntity> question = queService.getQuestion(id);
		if (question.isEmpty()) {
			throw new NotFoundException("QUESTION with id"+-id);
		}
		return question;
	}

	@DeleteMapping("/que/{id}")
	public void deleteQuestion(@PathVariable Integer id) {
		queService.deleteQuestion(id);
	}

	@PutMapping("/que/increment/{id}")
	public void upvote(@PathVariable Integer id) {
		queService.upvote(id);
	}
}
