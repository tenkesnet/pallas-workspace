package org.pallas.alapozo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Table(name = "ALKALMAZOTT")
public class Alkalmazott {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int alkKod;
	@Column(length = 20, nullable = false)
	private String alkNev;
	@Column(length = 16, nullable = false)
	private String beosztas;
	private Integer fizetes;
	@Column(nullable = true)
	private Integer premium;
	private Date belepes;
	@ManyToOne()	
	@JoinColumn(name="RESZLEG_ID")
	@JsonIdentityReference(alwaysAsId = true)
	//@JsonPropertyDescription()
	private Reszleg reszleg;
}
