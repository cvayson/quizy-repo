package com.example.quizy.Service;

import com.example.quizy.Model.Answer;
import com.example.quizy.Model.Question;
import com.example.quizy.Repo.AnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    AnswerRepo repo;

    public Answer save(Answer response)
    {
        return repo.save(response);
    }
    public List<Answer> get()
    {
        return repo.findAll();
    }


}
