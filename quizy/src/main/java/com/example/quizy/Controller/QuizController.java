package com.example.quizy.Controller;

import com.example.quizy.Model.Question;
import com.example.quizy.Model.Quiz;
import com.example.quizy.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService service;

    @PostMapping("/save")
    public Quiz save(@RequestBody Quiz request)
    {
        return service.save(request);
    }
    @GetMapping("get/{id}")
    public Quiz getById(@PathVariable Long id)
    {
        return service.getById(id);

    }
    @GetMapping("/get")
    public List<Quiz> getAll()
    {
        return service.getAll();
    }
    @PutMapping("/update/{id}")
    public Quiz setQuestions(@PathVariable Long id)throws Exception
    {
        return service.setQuestions(id);
    }
}
