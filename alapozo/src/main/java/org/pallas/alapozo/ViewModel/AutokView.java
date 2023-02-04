package org.pallas.alapozo.ViewModel;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class AutokView {
    public int id;
	public String rendszam;
	public Date vasarlasDatuma;
	public float ar;
	public int futottKm;
	public Integer utSzerviz;
	public String allapot;
}
