//package org.pallas.alapozo.model;
//
//import com.fasterxml.jackson.annotation.JsonIdentityReference;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "AUTO_CSOP")
//public class AutoCsop {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	public int autoCsopId;
//	
//	@Column(length = 6, nullable = false)
//	public String autoCsopNev;
//	
//	public int kmDij;
//	public int napiDij;
//	
//	@JsonIdentityReference(alwaysAsId = true)
//	@ManyToOne(fetch=FetchType.EAGER)	
//	@JoinColumn(name="AUTOK_ID",referencedColumnName="AKID")
//	private Autok autok;
//}
