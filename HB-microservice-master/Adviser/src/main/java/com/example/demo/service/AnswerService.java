package com.example.demo.service;

import com.example.demo.model.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface AnswerService {
    Answer createAnswer(Answer answer);
    Answer getAnswerById(Long id);
    ResponseEntity<?> deleteAnswer(Long answerId);
    Page<Answer> getAllAnswers(Pageable pageable);
    Page<Answer> getAnswerByQuestionId(Long questionId,Pageable pageable);
}
