package org.pallas.alapozo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESZLEG")
public class Reszleg {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	public int reszlegKod;

	@Column(length = 20, nullable = false)
	public String reszlegNev;

	@Column(length = 15, nullable = false)
	public String reszlegCim;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "reszleg")
	private List<Alkalmazott> alkalmazottak = new ArrayList<>();

	
	public void setAlkalmazottak(List<Alkalmazott> alkalmazottak) {
		this.alkalmazottak = alkalmazottak;
	}

	public List<Alkalmazott> getAlkalmazottak() {
		return alkalmazottak;
	}

	

}
