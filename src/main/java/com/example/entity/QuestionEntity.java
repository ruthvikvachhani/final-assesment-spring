package com.example.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class QuestionEntity {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer queId;
	
	@Column(name = "vote")
	private Integer vote;
	
	@NotNull
	@Size(min=2,message="question should be gretaer the 2 characters")
	@Column(name = "Question")
	private String Que;
	
	@ManyToOne
	private UserEntity userId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "questionId")
	private Set<AnswerEntity> ans;
	
	
	public Integer getVote() {
		return this.vote;
	}

	public void setVote(Integer vote) {
		this.vote = vote;
	}

	public String getQue() {
		return this.Que;
	}

	public void setQue(String que) {
		this.Que = que;
	}

	public Set<AnswerEntity> getAns() {
		return this.ans;
	}

	public void setAns(Set<AnswerEntity> ans) {
		this.ans = ans;
	}
	
	
}
