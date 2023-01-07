package org.pallas.alapozo.service;

import org.pallas.alapozo.abstraction.ComplexResult;
import org.pallas.alapozo.model.Alkalmazott;
import org.pallas.alapozo.model.AutoCsop;
import org.pallas.alapozo.model.Reszleg;
import org.pallas.alapozo.model.Tipus;

public interface IAutoKolcsonzoService {

	ComplexResult<AutoCsop> getAutoCsopById(int id);
	ComplexResult<Iterable<AutoCsop>> getAllAutoCsop();
	ComplexResult<Iterable<Reszleg>> getAllReszleg();
	ComplexResult<Iterable<Tipus>> getAllTipus();
	ComplexResult<Iterable<Alkalmazott>> getAllAlkalmazott();
}