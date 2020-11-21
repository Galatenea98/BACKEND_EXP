package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.resource.QuestionResource;
import com.example.demo.resource.SaveQuestionResource;
import com.example.demo.service.QuestionService;
import io.swagger.v3.oas.annotations.Parameter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class QuestionController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions")
    public Page<QuestionResource> getAllQuestions(
            @Parameter(description="Pageable Parameter")
                    Pageable pageable) {
        Page<Question> questionsPage = questionService.getAllQuestions(pageable);
        List<QuestionResource> resources = questionsPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }
    @PostMapping("/questions")
    public QuestionResource createQuestion(@Valid @RequestBody SaveQuestionResource resource)  {
        Question post = convertToEntity(resource);
        return convertToResource(questionService.createQuestion(post));
    }

    private Question convertToEntity(SaveQuestionResource resource) {
        return mapper.map(resource, Question.class);
    }

    private QuestionResource convertToResource(Question entity) {
        return mapper.map(entity, QuestionResource.class);
    }
}

