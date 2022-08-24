package com.example.quizy.Controller;

import com.example.quizy.Model.ModelTta.QuestionTta;
import com.example.quizy.Model.Question;
import com.example.quizy.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/question")

public class QuestionController {
    @Autowired
    QuestionService service;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/getAll")
    public QuestionTta[] getAll() {

        return service.getAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/getByCategory/{category}")
    public List<QuestionTta> getByCategory( @PathVariable String category) {
        return service.getByCategory(category);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("getByDifficulty/{difficulty}")
    public List<QuestionTta> getByDifficulty(@PathVariable String difficulty)
    {
        return service.getByDifficulty(difficulty);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/getAll/{difficulty}/{category}")
    public List<QuestionTta>getByDifficultyAndCategory(@PathVariable String difficulty,@PathVariable String category)
    {
        return service.getByDifficultyAndCategory(difficulty,category);
    }
    @PostMapping("/save")
    public void save()
    {
        service.save();
    }
    @GetMapping("/get")
    public List<Question>get()
    {
        return service.get();
    }
    @PutMapping("/update")
    public void setAnswers()
    {
         service.setAnswers();
    }
}
