package com.example.quizy.Model.ModelTta;

import lombok.Data;

@Data
public class QuestionTta {
    private String id;
    private String category;
    private String correctAnswer;
    private String[] incorrectAnswers;
    private String question;
    private String type;
    private String difficulty;

}
