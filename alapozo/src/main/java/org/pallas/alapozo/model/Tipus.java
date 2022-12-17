package org.pallas.alapozo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPUSOK")
public class Tipus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(length = 6, nullable = false)
    public String  tipusNev ;

    @Column(length = 6, nullable = false)
    public String  leiras ;
    public int SzervizKm;
    
    @OneToOne
    @JoinColumn(name = "AUTO_CSOP_id")
    public AutoCsop autoCsop;

 

}