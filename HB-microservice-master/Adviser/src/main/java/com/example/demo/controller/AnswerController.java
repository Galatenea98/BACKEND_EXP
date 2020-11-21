package com.example.demo.controller;

import com.example.demo.model.Answer;
import com.example.demo.resource.AnswerResource;
import com.example.demo.resource.SaveAnswerResource;
import com.example.demo.service.AnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AnswerController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AnswerService answerService;
    
    @GetMapping("question/{questionId}/answer")
    public Page<AnswerResource> getAllAnswersByPostId(
            @PathVariable(name = "questionId") Long questionId,
            Pageable pageable) {
        Page<Answer> answerPage = answerService.getAnswerByQuestionId(questionId,pageable);
        List<AnswerResource> resources = answerPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    private Answer convertToEntity(SaveAnswerResource resource) {
        return mapper.map(resource, Answer.class);
    }

    private AnswerResource convertToResource(Answer entity) {
        return mapper.map(entity, AnswerResource.class);
    }
}
