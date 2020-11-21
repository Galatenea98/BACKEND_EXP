package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Answer;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer getAnswerById(Long id) {
        return answerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Answer", "Id", id));
    }

    @Override
    public ResponseEntity<?> deleteAnswer(Long answerId) {
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new ResourceNotFoundException("Answer", "Id", answerId));
        answerRepository.delete(answer);
        return ResponseEntity.ok().build();
    }

    @Override
    public Page<Answer> getAllAnswers(Pageable pageable) {
        return answerRepository.findAll(pageable);
    }

    @Override
    public Page<Answer> getAnswerByQuestionId(Long questionId, Pageable pageable) {
        return answerRepository.findByQuestionId(questionId, pageable);
    }
}
