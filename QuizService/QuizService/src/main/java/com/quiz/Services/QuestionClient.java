package com.quiz.Services;

import com.quiz.entities.Questions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url="http://localhost:8082",value="Question-Client")
public interface QuestionClient {

    @GetMapping("/questions/quiz/{quizId}")
    List<Questions> getQuestionsOfQuiz(@PathVariable("quizId") Long quizId);

}
