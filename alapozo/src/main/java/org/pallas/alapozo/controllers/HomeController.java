package org.pallas.alapozo.controllers;

import java.util.ArrayList;
import java.util.List;
import org.pallas.alapozo.model.Question;
import org.pallas.alapozo.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private IQuestionRepository question_repo;

    @GetMapping("/")
    public String vizsga(Model model) {
        List<Question> questions = new ArrayList<>();
        questions.add(question_repo.findById(50).get());
        questions.add(question_repo.findById(150).get());
        questions.add(question_repo.findById(197).get());
        questions.add(question_repo.findById(205).get());
        
        model.addAttribute("kerdesek", questions);
        return "pages/vizsga";
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    public void favicon() {
        //return "";
    }

}
