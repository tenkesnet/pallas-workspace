package org.pallas.alapozo.controllers;


import org.pallas.alapozo.abstraction.ComplexResult;
import org.pallas.alapozo.model.Alkalmazott;
import org.pallas.alapozo.model.AutoCsop;
import org.pallas.alapozo.model.Reszleg;
import org.pallas.alapozo.model.Tipus;
import org.pallas.alapozo.service.IAutoKolcsonzoService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping("/getAutoCsopById")
	public ComplexResult<AutoCsop> getAutoCsopById(@RequestParam String id,@RequestParam String name) {
		String str="inc";
		int idvalue = 0;
		try {
			idvalue=Integer.parseInt(id);			
			if(name.equals(str)) {
				idvalue++;
			}
			return _service.getAutoCsopById(idvalue);
		} catch (Exception e) {
			return new ComplexResult<AutoCsop>(null, "id is'nt integer", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@GetMapping("/getAllAutoCsop")
	public ComplexResult<Iterable<AutoCsop>> getAllAutoCsop() {
		return _service.getAllAutoCsop();
	}
	
	@GetMapping("/getAllReszleg")
	public ComplexResult<Iterable<Reszleg>> getAllReszleg() {
		return _service.getAllReszleg();
	}
	
	@GetMapping("/getAllTipus")
	public ComplexResult<Iterable<Tipus>> getAllTipus() {
		return _service.getAllTipus();
	}
	
	@GetMapping("/getAllAlkalmazott")
	public ComplexResult<Iterable<Alkalmazott>> getAllAlkalmazott() {
		return _service.getAllAlkalmazott();
	}
}
