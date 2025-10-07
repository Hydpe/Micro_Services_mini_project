package com.question.Services;

import com.question.Entities.Questions;

import java.util.List;

public interface QuestionService {
    Questions createQuestions(Questions questions);
    List<Questions> get();
    Questions getById(Long id);
    List<Questions> getQuestionsOfQuiz(Long quizId);

}
