package org.pallas.alapozo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        Random rnd = new Random();
        for(int i=0; i<20; i++){
            int q_random = rnd.nextInt(210)+1;
            questions.add(question_repo.findById(q_random).get());
        }
        model.addAttribute("kerdesek", questions);
        return "pages/vizsga";
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    public void favicon() {
        //return "";
    }

}
