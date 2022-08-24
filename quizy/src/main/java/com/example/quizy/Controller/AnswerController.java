package com.example.quizy.Controller;

import com.example.quizy.Model.Answer;
import com.example.quizy.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    AnswerService service;

    @GetMapping("/get")
    public List<Answer> get()
    {
        return service.get();
    }
}
