package org.pallas.alapozo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Table(name = "RESZLEG")
public class Reszleg {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int reszlegKod;

	@Column(length = 20, nullable = false)
	private String reszlegNev;

	@Column(length = 15, nullable = false)
	private String reszlegCim;

	@OneToMany(mappedBy = "reszleg")
	@JsonIdentityReference(alwaysAsId = true)
	//@JsonPropertyDescription()
	private List<Alkalmazott> alkalmazottak;
}
