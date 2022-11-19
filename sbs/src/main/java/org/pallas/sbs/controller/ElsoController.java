package org.pallas.sbs.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import  org.springframework.transaction.annotation.Transactional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.pallas.sbs.domain.User;
import org.pallas.sbs.dto.GetImportFromResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ElsoController {

	private GetImportFromResponse _response = new GetImportFromResponse();

	private final Logger logger= LoggerFactory.getLogger(ElsoController.class);

	
	public ElsoController() {
	}
	
	public void display() {
		System.out.println("Elso Controller!");
	}
	
	@GetMapping("/elso")
	public String getelso() {
		return "Get";
	}
	
	@PostMapping("/elso")
	public GetImportFromResponse elsoMethodus() {
		_response = new GetImportFromResponse();
		Resource resource = new ClassPathResource("valami.csv");
		// List<String> csvlist = new ArrayList<String>();
		// String[] HEADERS = { "Name", "MotherName"};
		try {
			// InputStream input = resource.getInputStream();

			File file = resource.getFile();
			// csvlist = Files.readAllLines(file.toPath());
			Reader in = new FileReader(file.toPath().toString());
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().withFirstRecordAsHeader().parse(in);
			for (CSVRecord record : records) {
				User user = new User(record.get("Name"), record.get("MotherName"), record.get("Location"),
						new SimpleDateFormat("yyyy-MM-dd", new Locale("hu", "HU")).parse(record.get("BirthDate")));
				_response.users.add(user);
			}
			// m.addAttribute("lines", csvlist);

		} catch (IOException e) {
			logger.error(e.getMessage());
			_response.isValid = false;
			_response.ErrorMessage = e.getMessage();
		} catch (ParseException e) {
			logger.error(e.getMessage());
			_response.isValid = false;
			_response.ErrorMessage = e.getMessage();
		}
		return _response;

		// return "index";
	}
}
