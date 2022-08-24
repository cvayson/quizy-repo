package com.example.quizy.Mapper;

import com.example.quizy.Model.Answer;
import com.example.quizy.Model.ModelTta.QuestionTta;

public class AnswerMapper {

    public Answer questionTtaToAnswer(QuestionTta question)
    {
        Answer temp=new Answer();

        temp.setFirstAnswer(question.getIncorrectAnswers()[0]);
        temp.setSecondAnswer(question.getIncorrectAnswers()[1]);
        temp.setThirdAnswer(question.getIncorrectAnswers()[2]);
        temp.setFourthAnswer(question.getCorrectAnswer());
        temp.setQuestionId(question.getId());

        return temp;
    }
}
