package com.example.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.entity.AnswerEntity;
import com.example.exception.NotFoundException;
import com.example.service.IAnswerService;

@RestController
public class AnswerController {
	
	@Autowired
	IAnswerService ansService;
	
	@PostMapping("/ans")
	public ResponseEntity<Object> createAnswer(@RequestBody AnswerEntity ans) {
		AnswerEntity createAnswer= ansService.createAnswer(ans);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createAnswer.getAnswerId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/ans")
	public Iterable<AnswerEntity> getAllAnswer() {
		return ansService. getAllAnswer();
	}
	
	@GetMapping("/ans/{id}")
	public Optional<AnswerEntity> getAnswer(@PathVariable Integer id) {
		Optional<AnswerEntity> answer = ansService. getAnswer(id);
		if (answer.isEmpty()) {
			throw new NotFoundException("ANSWER with id"+-id);
		}
		return answer;
	}
	
	@DeleteMapping("/ans/{id}")
	public void deleteAnswer(@PathVariable Integer id) {
		ansService.deleteAnswer(id);
	}
	
}
