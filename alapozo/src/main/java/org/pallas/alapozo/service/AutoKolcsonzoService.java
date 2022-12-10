package org.pallas.alapozo.service;

import java.util.NoSuchElementException;

import org.pallas.alapozo.abstraction.ComplexResult;
import org.pallas.alapozo.model.AutoCsop;
import org.pallas.alapozo.model.Reszleg;
import org.pallas.alapozo.repository.AutoCsopRepository;
import org.pallas.alapozo.repository.ReszlegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AutoKolcsonzoService implements IAutoKolcsonzoService {
	@Autowired
	private AutoCsopRepository _autocsopRepo;
	@Autowired
	private ReszlegRepository _reszlegRepo;
	
	@Override
	public ComplexResult<AutoCsop> getAutoCsopById(int id) {
		ComplexResult<AutoCsop> result=new ComplexResult<>();
		try {
			result.Object = _autocsopRepo.findById(id).get();
		} catch (NoSuchElementException e) {
			return new ComplexResult<AutoCsop>(null,"Not found",HttpStatus.NOT_FOUND);
		}  catch(InvalidDataAccessResourceUsageException e) {
			return new ComplexResult<AutoCsop>(null,"Database Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		result.Status=HttpStatus.OK;
		return result;
	}
	
	@Override
	public ComplexResult<Iterable<AutoCsop>> getAllAutoCsop() {
		ComplexResult<Iterable<AutoCsop>> result=new ComplexResult<>();
		try {
			result.Object = _autocsopRepo.findAll();
		} catch (NoSuchElementException e) {
			return new ComplexResult<Iterable<AutoCsop>>(null,"Not found",HttpStatus.NOT_FOUND);
		} catch(InvalidDataAccessResourceUsageException e) {
			return new ComplexResult<Iterable<AutoCsop>>(null,"Database Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		result.Status=HttpStatus.OK;
		return result;
	}
	
	@Override
	public ComplexResult<Iterable<Reszleg>> getAllReszleg() {
		ComplexResult<Iterable<Reszleg>> result=new ComplexResult<>();
		try {
			result.Object = _reszlegRepo.findAll();
		} catch (NoSuchElementException e) {
			return new ComplexResult<Iterable<Reszleg>>(null,"Not found",HttpStatus.NOT_FOUND);
		} catch(InvalidDataAccessResourceUsageException e) {
			return new ComplexResult<Iterable<Reszleg>>(null,e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		result.Status=HttpStatus.OK;
		return result;
	}
}
