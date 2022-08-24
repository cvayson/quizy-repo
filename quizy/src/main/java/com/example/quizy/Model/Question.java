package com.example.quizy.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId;
    private String id;
    private String category;
    private String question;
    private String type;
    private String difficulty;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "question_answer",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id"))
    private Answer answer;

    public Question(String id, String category, String question, String type, String difficulty, Answer answer) {
        this.id=id;
        this.category=category;
        this.question=question;
        this.type=type;
        this.difficulty=difficulty;
        this.answer=answer;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}

