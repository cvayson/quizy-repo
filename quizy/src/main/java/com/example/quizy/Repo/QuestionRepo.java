package com.example.quizy.Repo;

import com.example.quizy.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question,Long> {

}
