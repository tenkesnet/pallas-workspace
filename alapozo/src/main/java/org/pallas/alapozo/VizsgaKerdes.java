package org.pallas.alapozo;

import java.util.ArrayList;
import java.util.List;

public class VizsgaKerdes {
    public int kerdesszam;
    public String kerdes;
    public List<VizsgaValasz> valaszok = new ArrayList<>();
    
    public VizsgaKerdes(int kerdesszam, String kerdes) {
        this.kerdesszam = kerdesszam;
        this.kerdes = kerdes;
    }
    
}
