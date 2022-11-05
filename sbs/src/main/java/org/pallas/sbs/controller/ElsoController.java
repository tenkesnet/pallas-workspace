package org.pallas.sbs.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.pallas.sbs.domain.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ElsoController {
	
	public ArrayList<User> users = new ArrayList<User>();
	
	
	public void display() {
		System.out.println("Elso Controller!");
	}
	
	@GetMapping("elso")
	public List<User> elsoMethodus() {
		Resource resource = new ClassPathResource("valami.csv");
		//List<String> csvlist = new ArrayList<String>();
		//String[] HEADERS = { "Name", "MotherName"};
		try {
			//InputStream input = resource.getInputStream();
			
			File file = resource.getFile();
			//csvlist = Files.readAllLines(file.toPath());
			Reader in = new FileReader(file.toPath().toString());
		    Iterable<CSVRecord> records = CSVFormat.DEFAULT
		      .withHeader()
		      .withFirstRecordAsHeader()
		      .parse(in);
		    for (CSVRecord record : records) {
		    	User user = new User(record.get("Name"),
		    			record.get("MotherName"),
		    			record.get("Location"),
		    			new SimpleDateFormat("yyyy-MM-dd").parse(record.get("BirthDate")));
		    	users.add(user);
		    }
			//m.addAttribute("lines", csvlist);
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return users;
		
		
		//return "index";
	}
}
