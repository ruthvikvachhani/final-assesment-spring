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

@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@NotNull
	private String Name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_QUESTION", joinColumns ={@JoinColumn( name = "UserEntity", referencedColumnName = "userId")}, inverseJoinColumns={@JoinColumn(name = "questionEntity",referencedColumnName = "queId")} )
	private Set<QuestionEntity> question;

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