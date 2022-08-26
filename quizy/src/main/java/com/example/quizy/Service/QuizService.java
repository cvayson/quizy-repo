package com.example.quizy.Service;

import com.example.quizy.Model.Question;
import com.example.quizy.Model.Quiz;
import com.example.quizy.Repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        Set<Question> tempQuestions=new HashSet<>
                (questionService.getByCategoryAndDifficulty(response.getCategory(),response.getDifficulty()));
        response.setQuestions(tempQuestions);
        return quizRepo.save(response);
    }
   
    @Transactional
    public Quiz update(Long id)throws Exception
    {
        Quiz tempQuiz=quizRepo.findById(id).get();
        String category=tempQuiz.getCategory();
        String difficulty=tempQuiz.getDifficulty();
        Set<Question> tempQuestions=new HashSet<>(questionService.getByCategoryAndDifficulty(category,difficulty));

        tempQuiz.setQuestions(tempQuestions);
        return quizRepo.save(tempQuiz);


    }

}
