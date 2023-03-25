package org.pallas.alapozo.controllers;

import java.util.List;
import org.pallas.alapozo.model.Question;
import org.pallas.alapozo.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vizsga")
public class VizsgaController {
    
    @Autowired
    private IQuestionRepository question_repo;
    
    @GetMapping
    public List<Question> get(){
        return question_repo.findAll();
    }
}
