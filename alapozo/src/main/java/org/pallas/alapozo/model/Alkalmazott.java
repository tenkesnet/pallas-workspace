package org.pallas.alapozo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ALKALMAZOTT")
public class Alkalmazott {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public int alkKod;
	@Column(length = 20, nullable = false)
	public String alkNev;
	@Column(length = 16, nullable = false)
	public String beosztas;
	public Integer fizetes;
	@Column(nullable = true)
	public Integer premium;
	public Date belepes;
	@ManyToOne	
	@JoinColumn(name="RESZLEG_ID")
	public Reszleg reszleg;
}
