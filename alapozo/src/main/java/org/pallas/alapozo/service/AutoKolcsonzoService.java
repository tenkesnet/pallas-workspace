package org.pallas.alapozo.service;

import java.util.NoSuchElementException;

import org.pallas.alapozo.abstraction.ComplexResult;
import org.pallas.alapozo.model.Alkalmazott;
import org.pallas.alapozo.model.AutoCsop;
import org.pallas.alapozo.model.Reszleg;
import org.pallas.alapozo.model.Tipus;
import org.pallas.alapozo.repository.IAlkalmazottRepository;
import org.pallas.alapozo.repository.IAutoCsopRepository;
import org.pallas.alapozo.repository.IReszlegRepository;
import org.pallas.alapozo.repository.ITipusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AutoKolcsonzoService implements IAutoKolcsonzoService {
	@Autowired
	private IAutoCsopRepository _autocsopRepo;
	@Autowired
	private IReszlegRepository _reszlegRepo;
	@Autowired
	private ITipusRepository _tipusRepo;
	@Autowired
	private IAlkalmazottRepository _alkalmazottRepo;
	
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
	
	@Override
	public ComplexResult<Iterable<Tipus>> getAllTipus() {
		ComplexResult<Iterable<Tipus>> result=new ComplexResult<>();
		try {
			result.Object = _tipusRepo.findAll();
		} catch (NoSuchElementException e) {
			return new ComplexResult<Iterable<Tipus>>(null,"Not found",HttpStatus.NOT_FOUND);
		} catch(InvalidDataAccessResourceUsageException e) {
			return new ComplexResult<Iterable<Tipus>>(null,e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		result.Status=HttpStatus.OK;
		return result;
	}
	
	@Override
	public ComplexResult<Iterable<Alkalmazott>> getAllAlkalmazott() {
		ComplexResult<Iterable<Alkalmazott>> result=new ComplexResult<>();
		try {
			result.Object = _alkalmazottRepo.findAll();
		} catch (NoSuchElementException e) {
			return new ComplexResult<Iterable<Alkalmazott>>(null,"Not found",HttpStatus.NOT_FOUND);
		} catch(InvalidDataAccessResourceUsageException e) {
			return new ComplexResult<Iterable<Alkalmazott>>(null,e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		result.Status=HttpStatus.OK;
		return result;
	}
}
