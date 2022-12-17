package org.pallas.alapozo.controllers;


import java.util.ArrayList;

import org.pallas.alapozo.ViewModel.AlkalmazottView;
import org.pallas.alapozo.ViewModel.ReszlegView;
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
	public Iterable<ReszlegView> getAllReszleg() {
		ComplexResult<Iterable<Reszleg>> result =  _service.getAllReszleg();
		ArrayList<ReszlegView> reszlegek = new ArrayList<ReszlegView>();
		result.Object.forEach( x -> {
			ArrayList<AlkalmazottView> alkalmazottak = new ArrayList<AlkalmazottView>();
			x.getAlkalmazottak().forEach( y->{
				alkalmazottak.add(new AlkalmazottView(y.id, y.alkKod, y.alkNev, y.beosztas, y.fizetes, y.premium, y.belepes, null));
			});
			reszlegek.add(new ReszlegView(x.id, x.reszlegKod, x.reszlegNev, x.reszlegCim, alkalmazottak));
		});
		return reszlegek;
	}
	
	@GetMapping("/getAllTipus")
	public ComplexResult<Iterable<Tipus>> getAllTipus() {
		return _service.getAllTipus();
	}
	
	@GetMapping("/getAllAlkalmazott")
	public Iterable<AlkalmazottView> getAllAlkalmazott() {
		ComplexResult<Iterable<Alkalmazott>> result = _service.getAllAlkalmazott();
		ArrayList<AlkalmazottView> alkalmazottViews = new ArrayList<AlkalmazottView>();
		result.Object.forEach( x -> {
			alkalmazottViews.add(new AlkalmazottView(x.id, x.alkKod, x.alkNev, x.beosztas, x.fizetes, x.premium,x.belepes , 
					new ReszlegView(x.getReszelg().id, x.getReszelg().reszlegKod, x.getReszelg().reszlegNev, x.getReszelg().reszlegCim, null) ));
		});
		return alkalmazottViews;
	}
}
