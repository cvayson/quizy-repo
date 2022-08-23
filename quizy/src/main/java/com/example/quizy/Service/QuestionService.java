package com.example.quizy.Service;

import com.example.quizy.Model.ModelTta.QuestionTta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    RestTemplate template;

    public QuestionTta[] getAll()
    {
        return template.getForObject("https://the-trivia-api.com/api/questions?limit=16000",QuestionTta[].class);
    }
    public List<QuestionTta> getByCategory(String category)
    {
        QuestionTta[] temps=getAll();
        List<QuestionTta> questions=new ArrayList<>();

        for (int i=0;i<temps.length;i++)
        {
            if(temps[i].getCategory().equals(category)) {
                questions.add(temps[i]);
            }
        }

        return questions;
    }
    public List<QuestionTta> getByDifficulty(String difficulty)
    {
        QuestionTta[] temps=getAll();
        List<QuestionTta> questions=new ArrayList<>();

        for (int i=0;i<temps.length;i++)
        {
            if(temps[i].getDifficulty().equals(difficulty)) {
                questions.add(temps[i]);
            }
        }
        return questions;
    }
    public List<QuestionTta> getByDifficultyAndCategory(String difficulty,String category)
    {
        QuestionTta[] temps=getAll();
        List<QuestionTta> questions=new ArrayList<>();

        for (int i=0;i<temps.length;i++)
        {
            if(temps[i].getDifficulty().equals(difficulty)&&temps[i].getCategory().equals(category)) {
                questions.add(temps[i]);
            }
        }
        return questions;
    }

}
