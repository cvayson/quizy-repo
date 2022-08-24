package com.example.quizy.Mapper;

import com.example.quizy.Model.ModelTta.QuestionTta;
import com.example.quizy.Model.Question;
import org.springframework.context.annotation.Bean;


public class QuestionMapper {
    AnswerMapper aMapper=new AnswerMapper();

    public Question questionTtaToQuestion(QuestionTta questionTta) {
        Question question=new Question(questionTta.getId(), questionTta.getCategory(), questionTta.getQuestion(), questionTta.getType(), questionTta.getDifficulty(),aMapper.questionTtaToAnswer(questionTta));
        return question;
    }
}
