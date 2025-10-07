package com.question.QuesionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.question.Entities.Questions;

import java.util.List;

public interface questionRepository extends JpaRepository<Questions,Long> {
    List<Questions> findByQuizId(Long quizId);
}
