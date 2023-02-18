package org.pallas.alapozo.ViewModel;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.pallas.alapozo.model.Autok;

import org.pallas.alapozo.model.Reszleg;

@Getter @Setter
public class AlkalmazottView {

    private int id;
    private int alkKod;
    private String alkNev;
    private String beosztas;
    private Integer fizetes;
    private Integer premium;
    private Date belepes;
    private Reszleg reszleg;
    private List<Autok> autok;
}
