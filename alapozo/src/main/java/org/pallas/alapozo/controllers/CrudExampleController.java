package org.pallas.alapozo.controllers;


import org.pallas.alapozo.abstraction.ComplexResult;
import org.pallas.alapozo.model.AutoCsop;
import org.pallas.alapozo.model.Reszleg;
import org.pallas.alapozo.service.IAutoKolcsonzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CrudExampleController {
	@Autowired
	private IAutoKolcsonzoService _service;

	@GetMapping("/getAutoCsopById/{id}")
	public ComplexResult<AutoCsop> getAutoCsopById(@PathVariable int id) {
		return _service.getAutoCsopById(id);
	}
	
	@GetMapping("/getAllAutoCsop")
	public ComplexResult<Iterable<AutoCsop>> getAllAutoCsop() {
		return _service.getAllAutoCsop();
	}
	
	@GetMapping("/getAllReszleg")
	public ComplexResult<Iterable<Reszleg>> getAllReszleg() {
		return _service.getAllReszleg();
	}
}
