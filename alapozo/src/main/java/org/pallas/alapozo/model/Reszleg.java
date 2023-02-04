package org.pallas.alapozo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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

	//@JsonIdentityReference(alwaysAsId = true)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reszleg")
	//@JoinColumn(name = "ALKALMAZOTT_ID",referencedColumnName="ID")
	private List<Alkalmazott> alkalmazottak = new ArrayList<>();
	
	//@JsonIdentityReference(alwaysAsId = true)
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "reszleg")	
	private List<Autok> autok = new ArrayList<>();

	
	public void setAlkalmazottak(List<Alkalmazott> alkalmazottak) {
		this.alkalmazottak = alkalmazottak;
	}

	public List<Alkalmazott> getAlkalmazottak() {
		return alkalmazottak;
	}

	

}
