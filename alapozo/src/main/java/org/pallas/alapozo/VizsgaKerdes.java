package org.pallas.alapozo;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VizsgaKerdes {

    public int kerdesSzam;
    public String kerdes;
    public List<VizsgaValasz> valaszok = new ArrayList<>();
    public String megoldas;

    public VizsgaKerdes(int kerdesSzam, String kerdes) {
        this.kerdesSzam = kerdesSzam;
        this.kerdes = kerdes;
    }

}
