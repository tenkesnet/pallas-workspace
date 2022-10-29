package org.pallas.sbs.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@Value("${welcome.message}")
    private String message;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView method() {
	    return new ModelAndView("redirect:" + "http://kovacshida.hu/");
	}
	
	@GetMapping("/index")
	public String amitmostnemadokmeg(Model model) {
		model.addAttribute("message","Világ");
		return "Kovacshida";
	}
}
