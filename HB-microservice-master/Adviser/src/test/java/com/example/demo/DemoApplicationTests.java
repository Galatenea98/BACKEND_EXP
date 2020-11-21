package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.model.Answer;
import com.example.demo.repository.QuestionRepository;


@SpringBootTest
class DemoApplicationTests {

    @Test
    void ProbarBot() {
        Page<Answer> Expected = "No";
        Pageable Expected;
        Assertions.assertEquals(Expected,Answer.findByQuestionId(5,Expected));
    }

}
