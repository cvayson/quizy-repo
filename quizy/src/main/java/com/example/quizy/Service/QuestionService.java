package com.example.quizy.Service;

import com.example.quizy.Mapper.AnswerMapper;
import com.example.quizy.Mapper.QuestionMapper;
import com.example.quizy.Model.Answer;
import com.example.quizy.Model.ModelTta.QuestionTta;
import com.example.quizy.Model.Question;
import com.example.quizy.Repo.AnswerRepo;
import com.example.quizy.Repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    RestTemplate template;
    @Autowired
    AnswerService answer;
    @Autowired
    QuestionRepo qRepo;
    @Autowired
    AnswerRepo answerRepo;
    @Autowired
    AnswerService answerService;
    QuestionMapper qMapper=new QuestionMapper();
    AnswerMapper answerMapper=new AnswerMapper();
    public QuestionTta[] getAll()
    {
        return template.getForObject("https://the-trivia-api.com/api/questions?limit=16000",QuestionTta[].class);
    }
    public List<Question> getByCategory(String category)
    {
        return qRepo.findAllByCategory(category);

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
    public List<Question> getByCategoryAndDifficulty(String category,String difficulty)
    {
        return qRepo.findAllByCategoryAndDifficulty(category,difficulty);
    }
    @Transactional
    public void save()
    {
        QuestionTta[] questionsTtas=getAll();
        for (QuestionTta questionTta:questionsTtas) {
            qRepo.save(qMapper.questionTtaToQuestion(questionTta));
            answerRepo.save(answerMapper.questionTtaToAnswer(questionTta));

        }

    }
    public List<Question> get()
    {
        List<Question> temp;
        temp=qRepo.findAll();
        return temp;
    }
    @Transactional
    public void setAnswers()
    {
        List<Question> tempQs=get();
        List<Answer> tempAs=answerService.get();
        for (Question tempQ:tempQs) {
            for (Answer tempA:tempAs) {
                if(tempQ.getQuestionId().equals(tempA.getQuestionId()))
                {

                    qRepo.save(tempQ);
                    answerRepo.save(tempA);
                }
            }
        }

    }

}
