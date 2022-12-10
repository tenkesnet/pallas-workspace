package org.pallas.alapozo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AUTO_CSOP")
public class AutoCsop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(length = 6, nullable = false)
	public String autoCsopNev;
	
	public int kmDij;
	public int napiDij;
}
