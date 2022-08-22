package com.example.quizy.Controller;

import com.example.quizy.Model.ModelTta.QuestionTta;
import com.example.quizy.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService service;

    @GetMapping("/getAll")
    public QuestionTta[] getAll() {

        return service.getAll();
    }

    @GetMapping("/getAll/{category}")
    public List<QuestionTta> getByCategory( @PathVariable String category) {
        return service.getByCategory(category);
    }
}
