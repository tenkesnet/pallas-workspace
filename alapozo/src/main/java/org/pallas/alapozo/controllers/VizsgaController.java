package org.pallas.alapozo.controllers;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.pallas.alapozo.helpers.VizsgaControllerHelper;
import org.pallas.alapozo.model.Question;
import org.pallas.alapozo.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vizsga")
//@Scope("session")
public class VizsgaController {

    @Autowired
    private IQuestionRepository question_repo;
    List<Question> questions;
    Map<Integer, Question> kiadott_kerdesek;

    public VizsgaController() {
        kiadott_kerdesek = new HashMap<>();
    }

    @GetMapping
    public Map<Integer,Question> get() {
        if (questions == null) {
            questions = question_repo.findAll();
        }
        Map<Integer, Question> feladatlap = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            int index = VizsgaControllerHelper.getRandomNumber(1, 85); //1-85
            if (!kiadott_kerdesek.containsKey(index)) {
                feladatlap.put(index, questions.get(index));
                kiadott_kerdesek.put(index, questions.get(index));
                continue;
            }
            i--;
        }
        for (int i = 0; i < 2; i++) {
            int index = VizsgaControllerHelper.getRandomNumber(86, 110); 
            if (!kiadott_kerdesek.containsKey(index)) {
                feladatlap.put(index, questions.get(index));
                kiadott_kerdesek.put(index, questions.get(index));
                continue;
            }
            i--;
        }
        for (int i = 0; i < 2; i++) {
            int index = VizsgaControllerHelper.getRandomNumber(111, 135); 
            if (!kiadott_kerdesek.containsKey(index)) {
                feladatlap.put(index, questions.get(index));
                kiadott_kerdesek.put(index, questions.get(index));
                continue;
            }
            i--;
        }
        for (int i = 0; i < 2; i++) {
            int index = VizsgaControllerHelper.getRandomNumber(136, 160); 
            if (!kiadott_kerdesek.containsKey(index)) {
                feladatlap.put(index, questions.get(index));
                kiadott_kerdesek.put(index, questions.get(index));
                continue;
            }
            i--;
        }
        for (int i = 0; i < 3; i++) {
            int index = VizsgaControllerHelper.getRandomNumber(161, 211); 
            if (!kiadott_kerdesek.containsKey(index)) {
                feladatlap.put(index, questions.get(index));
                kiadott_kerdesek.put(index, questions.get(index));
                continue;
            }
            i--;
        }
        return feladatlap;
    }

    @GetMapping("/{questionId}")
    public Question getQuestion(@PathVariable int questionId) {
        return question_repo.findById(questionId).get();
    }
}
