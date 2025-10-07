package com.question.Services.Implements;

import com.question.Entities.Questions;
import com.question.QuesionRepository.questionRepository;
import com.question.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private questionRepository questionRepository;
    public QuestionServiceImpl(questionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    @Override
    public Questions createQuestions(Questions questions) {
        return questionRepository.save(questions);
    }

    @Override
    public List<Questions> get() {
        return questionRepository.findAll();
    }

    @Override
    public Questions getById(Long id) {
        return questionRepository.findById(id).orElseThrow(()->new RuntimeException("Question not found"));
    }

    @Override
    public List<Questions> getQuestionsOfQuiz(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }

    //
}
