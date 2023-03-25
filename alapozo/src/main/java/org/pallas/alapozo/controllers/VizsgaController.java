package org.pallas.alapozo.controllers;

import java.util.List;
import org.pallas.alapozo.model.Question;
import org.pallas.alapozo.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vizsga")
public class VizsgaController {
    
    @Autowired
    private IQuestionRepository question_repo;
    
    List<Question> questions;
    
    @GetMapping
    public List<Question> get(){
        if(questions==null){
            questions = question_repo.findAll();
        }
        return questions;
    }
    
    @GetMapping("/{questionId}")
    public Question getQuestion(@PathVariable int questionId){
        return question_repo.findById(questionId).get();
    }
}
