package org.pallas.sbs.controller;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
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
	public ModelAndView iranyit() {
	    return new ModelAndView("redirect:" + "http://kovacshida.hu/");
	}
	
	@GetMapping("/index")
	public String amitmostnemadokmeg(Model model) {
		Resource resource = new ClassPathResource("static/pelda.xsd");
		
		File file;
		List<String> tartalom;
		try {
			InputStream input = resource.getInputStream();
			
			file = resource.getFile();
			tartalom = Files.readAllLines(file.toPath());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("message","Világ");
		return "Kovacshida";
	}
}
