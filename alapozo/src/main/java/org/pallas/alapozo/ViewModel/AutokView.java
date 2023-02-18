package org.pallas.alapozo.ViewModel;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AutokView {

    private int id;
    private String rendszam;
    private Date vasarlasDatuma;
    private float ar;
    private int futottKm;
    private Integer utSzerviz;
    private String allapot;
}
