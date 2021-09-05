package com.example.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class QuestionEntity {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer queId;
	
	@Column(name = "vote")
	private Integer vote = 0;
	
	@NotNull
	@Size(min=2,message="question should be gretaer the 2 characters")
	@Column(name = "Question")
	private String que;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "QUESTION_ANSWER", joinColumns ={@JoinColumn( name = "queEntity", referencedColumnName = "queId")}, inverseJoinColumns={@JoinColumn(name = "answerEntity",referencedColumnName = "answerId")} )
	private Set<AnswerEntity> ans;
	
	
	public Integer getVote() {
		return this.vote;
	}

	public void setVote(Integer vote) {
		this.vote = vote;
	}

	public String getQue() {
		return this.que;
	}

	public void setQue(String que) {
		this.que = que;
	}

	public Set<AnswerEntity> getAns() {
		return this.ans;
	}

	public void setAns(Set<AnswerEntity> ans) {
		this.ans = ans;
	}
	
	
}
