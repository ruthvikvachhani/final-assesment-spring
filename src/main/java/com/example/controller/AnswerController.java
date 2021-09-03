package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.AnswerEntity;
import com.example.service.IAnswerService;

@RestController
public class AnswerController {
	
	@Autowired
	IAnswerService ansService;
	
	@PostMapping("/ans")
	public AnswerEntity createUser(@RequestBody AnswerEntity ans) {
		return ansService.createAnswer(ans);
	}

	@GetMapping("/ans")
	public Iterable<AnswerEntity> getAllAnswer() {
		return ansService. getAllAnswer();
	}
	
	@GetMapping("/user/{id}")
	public Optional<AnswerEntity> getAnswer(@PathVariable Integer id) {
		return ansService. getAnswer(id);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteAnswer(@PathVariable Integer id) {
		ansService.deleteAnswer(id);
	}
	
}
