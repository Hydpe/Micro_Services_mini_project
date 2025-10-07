package com.quiz.Services.Impement;

import com.quiz.Repository.QuizRepository;
import com.quiz.Services.QuestionClient;
import com.quiz.Services.QuizService;
import com.quiz.entities.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService
{

    @Autowired
    private QuizRepository quizRepository;

    private QuestionClient questionClient;

    public QuizServiceImpl(QuestionClient questionClient, QuizRepository quizRepository) {
        this.questionClient = questionClient;
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
      List<Quiz> quizzes=  quizRepository.findAll();

        List<Quiz> newQuizList= quizzes.stream().map(quiz -> {
          quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
          return quiz;
      }).collect(Collectors.toList());
      return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz= quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz Not Found"));
        quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
        return quiz;
    }
}
