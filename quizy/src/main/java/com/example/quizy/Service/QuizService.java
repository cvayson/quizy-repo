package com.example.quizy.Service;

import com.example.quizy.Model.Quiz;
import com.example.quizy.Repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionService questionService;

    public Quiz getById(Long id)
    {
        return quizRepo.findById(id).get();
    }
    public Quiz save(Quiz response)
    {
        return quizRepo.save(response);
    }
    public Quiz setQuestions(Long id)
    {
        Quiz temp=quizRepo.findById(id).get();
        temp.setQuestions(questionService.get());
        return quizRepo.save(temp);

    }

}
