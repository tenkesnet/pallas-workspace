package org.pallas.alapozo.ViewModel;

import java.util.Date;
import java.util.List;
import org.pallas.alapozo.model.Autok;

import org.pallas.alapozo.model.Reszleg;

public class AlkalmazottView {

    public int id;
    public int alkKod;
    public String alkNev;
    public String beosztas;
    public Integer fizetes;
    public Integer premium;
    public Date belepes;
    public Reszleg reszleg;
    public List<Autok> autok;
}
