package com.example.quizy.Controller;

import com.example.quizy.Model.Quiz;
import com.example.quizy.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/update/{id}")
    public Quiz setQuestions(@PathVariable Long id)
    {
        return service.setQuestions(id);
    }
}
