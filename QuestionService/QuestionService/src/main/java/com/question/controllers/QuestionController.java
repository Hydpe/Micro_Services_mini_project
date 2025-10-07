package com.question.controllers;

import com.question.Entities.Questions;
import com.question.Services.QuestionService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Questions createQuestion(@RequestBody Questions questions){
        return questionService.createQuestions(questions);
    }
    @GetMapping
    public List<Questions> getAll(){
        return questionService.get();
    }

    @GetMapping("/{Qid}")
    public Questions getById(@PathVariable Long Qid){
        return questionService.getById(Qid);
    }

    //get Questionz of required quiz

    @GetMapping("/quiz/{quizId}")
    public List<Questions> getByQuiz(@PathVariable Long quizId){
            return questionService.getQuestionsOfQuiz(quizId);
    }

}
