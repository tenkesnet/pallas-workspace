package org.pallas.alapozo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.pallas.alapozo.ViewModel.AlkalmazottView;
import org.pallas.alapozo.ViewModel.ReszlegView;
import org.pallas.alapozo.abstraction.ComplexResult;
import org.pallas.alapozo.model.Alkalmazott;
import org.pallas.alapozo.model.AutoCsop;
import org.pallas.alapozo.model.Autok;
import org.pallas.alapozo.model.Reszleg;

import org.pallas.alapozo.service.IAutoKolcsonzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudExampleController {
	@Autowired
	private IAutoKolcsonzoService _service;

//	@GetMapping("/getAutoCsopById/{id}")
//	public ComplexResult<AutoCsop> getAutoCsopById(@PathVariable int id) {
//		return _service.getAutoCsopById(id);
//	}

//	@GetMapping("/getAutoCsopById")
//	public ComplexResult<AutoCsop> getAutoCsopById(@RequestParam String id, @RequestParam String name) {
//		String str = "inc";
//		int idvalue = 0;
//		try {
//			idvalue = Integer.parseInt(id);
//			if (name.equals(str)) {
//				idvalue++;
//			}
//			return _service.getAutoCsopById(idvalue);
//		} catch (Exception e) {
//			return new ComplexResult<AutoCsop>(null, "id is'nt integer", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	@GetMapping("/getAllAutoCsop")
	public ComplexResult<Iterable<AutoCsop>> getAllAutoCsop() {
		return _service.getAllAutoCsop();
	}
	
	@GetMapping("/getAllAutok")
	public ComplexResult<Iterable<Autok>> getAllAutok() {
		return _service.getAllAutok();
	}
	
	
//	@GetMapping("/getAllAutok")
//	public Iterable<Autok> getAllAutok() {
//		ComplexResult<Iterable<Autok>> result = _service.getAllAutok();
//
//		return result.Object;
//	}
//	
//	@GetMapping("/getAllRendeles")
//	public ComplexResult<Iterable<Rendeles>> getAllRendeles() {
//		return _service.getAllRendeles();
//	}
	
//	@GetMapping("/getAllRendeles")
//	public Iterable<Rendeles> getAllRendeles() {
//		ComplexResult<Iterable<Rendeles>> result = _service.getAllRendeles();
//
//		return result.Object;
//	}
	
//	@GetMapping("/getAllUgyfelek")
//	public ComplexResult<Iterable<Ugyfelek>> getAllUgyfelek() {
//		return _service.getAllUgyfelek();
//	}
	
//	@GetMapping("/getAllUgyfelek")
//	public Iterable<Ugyfelek> getAllUgyfelek() {
//		ComplexResult<Iterable<Ugyfelek>> result = _service.getAllUgyfelek();
//
//		return result.Object;
//	}
	

	@GetMapping("/getAllReszleg")
	public Iterable<Reszleg> getAllReszleg() {
		ComplexResult<Iterable<Reszleg>> result = _service.getAllReszleg();

		return result.Object;
	}

//	@GetMapping("/getAllTipus")
//	public ComplexResult<Iterable<Tipus>> getAllTipus() {
//		return _service.getAllTipus();
//	}

	@GetMapping("/getAllAlkalmazott")
	public Iterable<Alkalmazott> getAllAlkalmazott() {
		ComplexResult<Iterable<Alkalmazott>> result = _service.getAllAlkalmazott();
		return result.Object;
	}
	
//	@GetMapping("/getAllAlkalmazott")
//	public ComplexResult<Iterable<Alkalmazott>> getAllAlkalamzott() {
//		return _service.getAllAlkalmazott();
//	}

	@GetMapping("/getAlkNev")
	public Iterable<Alkalmazott> getAlkNev(@RequestParam String name) {
		ComplexResult<Iterable<Alkalmazott>> result = _service.getAlkNevContainingFromAlkalmazott(name);
		return result.Object;
	}

	@GetMapping("/getBelepesBetween")
	public Iterable<Alkalmazott> getBelepesBetween(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
		ComplexResult<Iterable<Alkalmazott>> result = _service.getBelepesBetween(start, end);
		return result.Object;
	}

	@GetMapping("/getBelepesBetweenAndFizetesGreaterThan")
	public ComplexResult<Iterable<Alkalmazott>> getBelepesBetweenAndFizetesGreaterThan(@RequestParam String start,
			@RequestParam String end, @RequestParam String fizetes) {
		Date startDate;
		Date endDate;
		int fizetesInt;
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(start);
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end);
			fizetesInt = Integer.parseInt(fizetes)
;		} catch (ParseException e) {
			return new ComplexResult<Iterable<Alkalmazott>>(null,"Date parse error.",HttpStatus.BAD_REQUEST);
		} catch (NumberFormatException e) {
			return new ComplexResult<Iterable<Alkalmazott>>(null,"Fizetes is integer.",HttpStatus.BAD_REQUEST);
		}
		ComplexResult<Iterable<Alkalmazott>> result = _service.getBelepesBetweenAndFizetesGreaterThan(startDate, endDate,
				fizetesInt);
		return result;
	}
	
}
