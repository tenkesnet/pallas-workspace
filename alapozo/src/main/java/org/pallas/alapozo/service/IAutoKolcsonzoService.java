package org.pallas.alapozo.service;

import org.pallas.alapozo.abstraction.ComplexResult;
import org.pallas.alapozo.model.AutoCsop;
import org.pallas.alapozo.model.Reszleg;

public interface IAutoKolcsonzoService {

	ComplexResult<AutoCsop> getAutoCsopById(int id);
	ComplexResult<Iterable<AutoCsop>> getAllAutoCsop();
	ComplexResult<Iterable<Reszleg>> getAllReszleg();

}