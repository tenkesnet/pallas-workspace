package org.pallas.alapozo.ViewModel;

import java.util.Date;

import org.pallas.alapozo.model.Reszleg;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class AlkalmazottView {
	public int id;
	public int alkKod;
	public String alkNev;
	public String beosztas;
	public Integer fizetes;
	public Integer premium;
	public Date belepes;
	public ReszlegView reszleg;
	
	public AlkalmazottView(int id, int alkKod, String alkNev, String beosztas, Integer fizetes, Integer premium,
			Date belepes, ReszlegView reszleg) {
		
		this.id = id;
		this.alkKod = alkKod;
		this.alkNev = alkNev;
		this.beosztas = beosztas;
		this.fizetes = fizetes;
		this.premium = premium;
		this.belepes = belepes;
		this.reszleg = reszleg;
	}
	
}
