package org.pallas.alapozo.controllers;

import org.pallas.alapozo.ViewModel.AlkalmazottView;
import org.pallas.alapozo.ViewModel.ReszlegView;
import org.pallas.alapozo.mapper.AlkalmazottMapper;
import org.pallas.alapozo.mapper.ReszlegMapper;
import org.pallas.alapozo.model.Alkalmazott;
import org.pallas.alapozo.model.Reszleg;
import org.pallas.alapozo.service.IAutoKolcsonzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/alkalmazott")
public class AlkalmazottController {
	@Autowired
	private IAutoKolcsonzoService _service;
	
	@PostMapping("/")
	public Alkalmazott add(@RequestBody AlkalmazottView request) {
		Alkalmazott alkalmazott = AlkalmazottMapper.INSTANCE.alkalmazottViewToAlkalmazott(request);
		
		return _service.saveAlkalmazott(alkalmazott);
	}
}
