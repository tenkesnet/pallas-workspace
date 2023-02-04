package org.pallas.alapozo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "AUTOK")
public class Autok {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
	
	@Column(length = 20, nullable = false)
	public String rendszam;
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "autok")
//	@JoinColumn(name = "TIPUS_id")
//	private List<Tipus> tipus = new ArrayList<>();
//	@OneToMany
//    @JoinColumn(name = "TIPUS_id")
//    public Tipus tipus;
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "autok")
//	@JoinColumn(name = "AUTO_CSOP_id")
//	private List<AutoCsop> autoCsop = new ArrayList<>();
	
	public Date vasarlasDatuma;

	public float ar;

	public int futottKm;
	
	@Nullable
	public Integer utSzerviz;
	
	@Column(length = 1, nullable = false)
	public String allapot;
	
	//@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "autok")
	//@JoinColumn(name = "RESZLEG_id")
	//private Reszleg reszleg;
//	@OneToMany
//    @JoinColumn(name = "RESZLEG_id")
//    public Reszleg reszleg;
	
	@JsonIdentityReference(alwaysAsId = true)
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "RESZLEG_ID",referencedColumnName = "ID")
	private Reszleg reszleg ;
//	
	@JsonIdentityReference(alwaysAsId = true)
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ALKALMAZOTT_ID",referencedColumnName = "ID")
    public Alkalmazott alkalmazott;
	
	@JsonIdentityReference(alwaysAsId = true)
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "AUTO_CSOP_ID",referencedColumnName = "ID")
    public AutoCsop autoCsop;
	
//	@JsonIdentityReference(alwaysAsId = true)
//	@ManyToOne(fetch=FetchType.EAGER)	
//	@JoinColumn(name="RENDELES_ID", referencedColumnName="RSID")
//	private Rendeles rendeles;
	
}
