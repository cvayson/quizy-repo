package com.example.quizy.Repo;

import com.example.quizy.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Long> {
    public List<Question> findAllByCategory(String category);
    public List<Question> findAllByCategoryAndDifficulty(String category,String difficulty);
}
