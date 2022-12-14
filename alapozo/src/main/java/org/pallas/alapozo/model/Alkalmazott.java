package org.pallas.alapozo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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
	
	@JsonIdentityReference(alwaysAsId = true)
	@ManyToOne(fetch=FetchType.EAGER)	
	@JoinColumn(name="RESZLEG_ID")
	private Reszleg reszleg;
	
}
