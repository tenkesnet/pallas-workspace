package org.pallas.alapozo.service;

import java.util.Date;
import java.util.NoSuchElementException;

import org.pallas.alapozo.abstraction.ComplexResult;
import org.pallas.alapozo.model.Alkalmazott;
import org.pallas.alapozo.model.AutoCsop;
import org.pallas.alapozo.model.Autok;
import org.pallas.alapozo.model.Reszleg;

import org.pallas.alapozo.repository.IAlkalmazottRepository;
import org.pallas.alapozo.repository.IAutoCsopRepository;
import org.pallas.alapozo.repository.IAutokRepository;
import org.pallas.alapozo.repository.IReszlegRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AutoKolcsonzoService implements IAutoKolcsonzoService {
	//@Autowired
	//private IAutoCsopRepository _autocsopRepo;
	@Autowired
	private IReszlegRepository _reszlegRepo;
	//@Autowired
	//private ITipusRepository _tipusRepo;
	@Autowired
	private IAlkalmazottRepository _alkalmazottRepo;
	@Autowired
	private IAutokRepository _autokRepo;
	@Autowired
	private IAutoCsopRepository _autoCsopRepo;
//	@Autowired
//	private IRendelesRepository _rendelesRepo;
//	@Autowired
//	private IUgyfelekRepository _ugyfelekRepo;
	
	
	
	@Override
	public ComplexResult<AutoCsop> getAutoCsopById(int id) {
		ComplexResult<AutoCsop> result=new ComplexResult<>();
		try {
			result.Object = _autoCsopRepo.findById(id).get();
		} catch (NoSuchElementException e) {
			return new ComplexResult<AutoCsop>(null,"Not found",HttpStatus.NOT_FOUND);
		}  catch(InvalidDataAccessResourceUsageException e) {
			return new ComplexResult<AutoCsop>(null,"Database Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		result.Status=HttpStatus.OK;
		return result;
	}
	
//	@Override
//	public ComplexResult<Iterable<AutoCsop>> getAllAutoCsop() {
//		ComplexResult<Iterable<AutoCsop>> result=new ComplexResult<>();
//		try {
//			result.Object = _autocsopRepo.findAll();
//		} catch (NoSuchElementException e) {
//			return new ComplexResult<Iterable<AutoCsop>>(null,"Not found",HttpStatus.NOT_FOUND);
//		} catch(InvalidDataAccessResourceUsageException e) {
//			return new ComplexResult<Iterable<AutoCsop>>(null,"Database Error",HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		result.Status=HttpStatus.OK;
//		return result;
//	}
	
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
	public ComplexResult<Reszleg> getReszlegId(int id) {
		ComplexResult<Reszleg> result=new ComplexResult<>();
		try {
			result.Object = _reszlegRepo.findById(id).get();
		} catch (NoSuchElementException e) {
			return new ComplexResult<Reszleg>(null,"Not found",HttpStatus.NOT_FOUND);
		}  catch(InvalidDataAccessResourceUsageException e) {
			return new ComplexResult<Reszleg>(null,"Database Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		result.Status=HttpStatus.OK;
		return result;
	}
	
	@Override
	public Reszleg saveReszleg(Reszleg reszleg) {
		return _reszlegRepo.save(reszleg);
	}
	
	@Override
	public void deleteReszleg(int id) {
		try {
			_reszlegRepo.deleteById(id);	
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return;
	}
	
	@Override
	public Alkalmazott saveAlkalmazott(Alkalmazott alkalmazott) {
		return _alkalmazottRepo.save(alkalmazott);
	}
	
//	@Override
//	public ComplexResult<Iterable<Tipus>> getAllTipus() {
//		ComplexResult<Iterable<Tipus>> result=new ComplexResult<>();
//		try {
//			result.Object = _tipusRepo.findAll();
//		} catch (NoSuchElementException e) {
//			return new ComplexResult<Iterable<Tipus>>(null,"Not found",HttpStatus.NOT_FOUND);
//		} catch(InvalidDataAccessResourceUsageException e) {
//			return new ComplexResult<Iterable<Tipus>>(null,e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		result.Status=HttpStatus.OK;
//		return result;
//	}
	
	@Override
	public ComplexResult<Iterable<Alkalmazott>> getAllAlkalmazott() {
		ComplexResult<Iterable<Alkalmazott>> result=new ComplexResult<>();
		try {
			result.Object = _alkalmazottRepo.findAll();
		} catch (NoSuchElementException e) {
			return new ComplexResult<Iterable<Alkalmazott>>(null,"Not found",HttpStatus.NOT_FOUND);
		} catch(InvalidDataAccessResourceUsageException e) {
			return new ComplexResult<Iterable<Alkalmazott>>(null,"Database error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		result.Status=HttpStatus.OK;
		return result;
	}
	
	@Override
	public ComplexResult<Iterable<Alkalmazott>> getAlkNevFromAlkalmazott(String name) {
		ComplexResult<Iterable<Alkalmazott>> result=new ComplexResult<>();
		try {
			result.Object = _alkalmazottRepo.findByAlkNev(name);
		} catch (NoSuchElementException e) {
			return new ComplexResult<Iterable<Alkalmazott>>(null,"Not found",HttpStatus.NOT_FOUND);
		} catch(InvalidDataAccessResourceUsageException e) {
			return new ComplexResult<Iterable<Alkalmazott>>(null,e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		result.Status=HttpStatus.OK;
		return result;
	}

	@Override
	public ComplexResult<Iterable<Alkalmazott>> getAlkNevContainingFromAlkalmazott(String name) {
		ComplexResult<Iterable<Alkalmazott>> result=new ComplexResult<>();
		try {
			result.Object = _alkalmazottRepo.findByAlkNevIgnoreCaseContaining(name);
		} catch (NoSuchElementException e) {
			return new ComplexResult<Iterable<Alkalmazott>>(null,"Not found",HttpStatus.NOT_FOUND);
		} catch(InvalidDataAccessResourceUsageException e) {
			return new ComplexResult<Iterable<Alkalmazott>>(null,e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		result.Status=HttpStatus.OK;
		return result;
	}
	
	@Override
	public ComplexResult<Iterable<Alkalmazott>> getBelepesBetween(Date start, Date end) {
		ComplexResult<Iterable<Alkalmazott>> result=new ComplexResult<>();
		try {
			result.Object = _alkalmazottRepo.findByBelepesBetween(start,end);
		} catch (NoSuchElementException e) {
			return new ComplexResult<Iterable<Alkalmazott>>(null,"Not found",HttpStatus.NOT_FOUND);
		} catch(InvalidDataAccessResourceUsageException e) {
			return new ComplexResult<Iterable<Alkalmazott>>(null,e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		result.Status=HttpStatus.OK;
		return result;
	}
	
	@Override
	public ComplexResult<Iterable<Alkalmazott>> getBelepesBetweenAndFizetesGreaterThan(Date start, Date end,int fizetes) {
		ComplexResult<Iterable<Alkalmazott>> result=new ComplexResult<>();
		try {
			result.Object = _alkalmazottRepo.findByBelepesBetweenAndFizetesGreaterThan(start,end,fizetes);
		} catch (NoSuchElementException e) {
			return new ComplexResult<Iterable<Alkalmazott>>(null,"Not found",HttpStatus.NOT_FOUND);
		} catch(InvalidDataAccessResourceUsageException e) {
			return new ComplexResult<Iterable<Alkalmazott>>(null,e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		result.Status=HttpStatus.OK;
		return result;
	}
	
	@Override
	public ComplexResult<Iterable<Autok>> getAllAutok() {
		ComplexResult<Iterable<Autok>> result=new ComplexResult<>();
		try {
			result.Object = _autokRepo.findAll();
		} catch (NoSuchElementException e) {
			return new ComplexResult<Iterable<Autok>>(null,"Not found",HttpStatus.NOT_FOUND);
		} catch(InvalidDataAccessResourceUsageException e) {
			return new ComplexResult<Iterable<Autok>>(null,"Database Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		result.Status=HttpStatus.OK;
		return result;
	}
	
	@Override
	public ComplexResult<Iterable<AutoCsop>> getAllAutoCsop() {
		ComplexResult<Iterable<AutoCsop>> result=new ComplexResult<>();
		try {
			result.Object = _autoCsopRepo.findAll();
		} catch (NoSuchElementException e) {
			return new ComplexResult<Iterable<AutoCsop>>(null,"Not found",HttpStatus.NOT_FOUND);
		} catch(InvalidDataAccessResourceUsageException e) {
			return new ComplexResult<Iterable<AutoCsop>>(null,"Database Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		result.Status=HttpStatus.OK;
		return result;
	}
	
	@Override
	public ComplexResult<Iterable<AutoCsop>> getAllAutoCsopRendszam(String rendszam) {
		ComplexResult<Iterable<AutoCsop>> result=new ComplexResult<>();
		try {
			result.Object = _autoCsopRepo.findByAutokRendszamIgnoreCase(rendszam);
		} catch (NoSuchElementException e) {
			return new ComplexResult<Iterable<AutoCsop>>(null,"Not found",HttpStatus.NOT_FOUND);
		} catch(InvalidDataAccessResourceUsageException e) {
			return new ComplexResult<Iterable<AutoCsop>>(null,"Database Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		result.Status=HttpStatus.OK;
		return result;
	}
	
//	@Override
//	public ComplexResult<Iterable<Rendeles>> getAllRendeles() {
//		ComplexResult<Iterable<Rendeles>> result=new ComplexResult<>();
//		try {
//			result.Object = _rendelesRepo.findAll();
//		} catch (NoSuchElementException e) {
//			return new ComplexResult<Iterable<Rendeles>>(null,"Not found",HttpStatus.NOT_FOUND);
//		} catch(InvalidDataAccessResourceUsageException e) {
//			return new ComplexResult<Iterable<Rendeles>>(null,"Database Error",HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		result.Status=HttpStatus.OK;
//		return result;
//	}
	
//	@Override
//	public ComplexResult<Iterable<Ugyfelek>> getAllUgyfelek() {
//		ComplexResult<Iterable<Ugyfelek>> result=new ComplexResult<>();
//		try {
//			result.Object = _ugyfelekRepo.findAll();
//		} catch (NoSuchElementException e) {
//			return new ComplexResult<Iterable<Ugyfelek>>(null,"Not found",HttpStatus.NOT_FOUND);
//		} catch(InvalidDataAccessResourceUsageException e) {
//			return new ComplexResult<Iterable<Ugyfelek>>(null,"Database Error",HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		result.Status=HttpStatus.OK;
//		return result;
// 	}
	
}
