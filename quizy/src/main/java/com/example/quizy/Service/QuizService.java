package com.example.quizy.Service;

import com.example.quizy.Model.Question;
import com.example.quizy.Model.Quiz;
import com.example.quizy.Repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public List<Quiz> getAll()
    {
        return quizRepo.findAll();
    }
    @Transactional
    public Quiz save(Quiz response)
    {
        Quiz temp=new Quiz();
        temp.setCategory(response.getCategory());
        temp.setDifficulty(response.getDifficulty());


        return quizRepo.save(response);
    }
    @Transactional
    public Quiz setQuestions(Long id)
    {
        Quiz quiz=quizRepo.findById(id).get();
        String category=quiz.getCategory();
        String difficulty=quiz.getDifficulty();
        List<Question> tempQuestions=new ArrayList<>(questionService.getByCategoryAndDifficulty(category,difficulty));
        quiz.setQuestions(tempQuestions);
        return quizRepo.save(quiz);

    }

}
