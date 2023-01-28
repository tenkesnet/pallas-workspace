package org.pallas.alapozo.service;

import java.util.Date;

import org.pallas.alapozo.abstraction.ComplexResult;
import org.pallas.alapozo.model.Alkalmazott;
import org.pallas.alapozo.model.Autok;
import org.pallas.alapozo.model.Reszleg;


public interface IAutoKolcsonzoService {

//	ComplexResult<AutoCsop> getAutoCsopById(int id);
//	ComplexResult<Iterable<AutoCsop>> getAllAutoCsop();
	ComplexResult<Iterable<Reszleg>> getAllReszleg();
//	ComplexResult<Iterable<Tipus>> getAllTipus();
	ComplexResult<Iterable<Autok>> getAllAutok();
//	ComplexResult<Iterable<Rendeles>> getAllRendeles();
//	ComplexResult<Iterable<Ugyfelek>> getAllUgyfelek();
	ComplexResult<Iterable<Alkalmazott>> getAllAlkalmazott();
	ComplexResult<Iterable<Alkalmazott>> getAlkNevFromAlkalmazott(String name);
	ComplexResult<Iterable<Alkalmazott>> getAlkNevContainingFromAlkalmazott(String name);
	ComplexResult<Iterable<Alkalmazott>> getBelepesBetween(Date start, Date end);
	ComplexResult<Iterable<Alkalmazott>> getBelepesBetweenAndFizetesGreaterThan(Date start, Date end, int fizetes);
}