package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.entity.QuestionEntity;

public interface IQuestionRepository extends CrudRepository<QuestionEntity, Integer> {

}
