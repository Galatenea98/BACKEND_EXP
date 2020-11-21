package com.example.demo.service;

import com.example.demo.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface QuestionService {
    Question createQuestion(Question question);
    Question getQuestionById(Long id);
    ResponseEntity<?> deleteQuestion(Long questionId);
    Page<Question> getAllQuestions(Pageable pageable);
}
