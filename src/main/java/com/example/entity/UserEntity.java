package com.example.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Integer userId;
	
	@NotNull
	private String Name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_QUESTION", joinColumns ={@JoinColumn( name = "UserEntity", referencedColumnName = "userId")}, inverseJoinColumns={@JoinColumn(name = "questionEntity",referencedColumnName = "queId")} )
	private Set<QuestionEntity> question;

	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public Set<QuestionEntity> getQuestion() {
		return this.question;
	}

	public void setQuestion(Set<QuestionEntity> question) {
		this.question = question;
	}
	
	
}