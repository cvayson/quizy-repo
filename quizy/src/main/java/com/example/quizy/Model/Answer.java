package com.example.quizy.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="answer")
@Data
public class Answer {
    @Id
    @GeneratedValue
    private Long id;
    private String questionId;
    private String firstAnswer;
    private String secondAnswer;
    private String thirdAnswer;
    private String correctAnswer;

}
