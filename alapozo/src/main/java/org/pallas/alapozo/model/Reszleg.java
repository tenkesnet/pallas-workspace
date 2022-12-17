package org.pallas.alapozo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="RESZLEG")
public class Reszleg {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	public int reszlegKod;
	
	@Column(length = 20, nullable = false)
	public String reszlegNev;
	
	@Column(length = 15, nullable = false)
	public String reszlegCim;
	
	@OneToMany(mappedBy = "reszleg")
	public List<Alkalmazott> alkalmazottak = new ArrayList<>();
	
}
