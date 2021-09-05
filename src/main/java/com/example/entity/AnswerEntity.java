package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class AnswerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer answerId;
	
	@NotNull
	@Size(min=2,message="answer should be gretaer the 2 characters")
	private String answer;


	public String getAnswer() {
		return this.answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
