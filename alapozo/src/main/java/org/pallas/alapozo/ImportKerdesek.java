package org.pallas.alapozo;

import ch.qos.logback.core.CoreConstants;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ImportKerdesek {

    final String importedFile = "/home/bardo/repo/pallas/backend/example2/alapozo/src/main/resources/java_kerdesek.txt";
    public List<VizsgaKerdes> vizsgakerdesek;

    public void readFile() {
        List<String> text = null;
        try {
            text = Files.readAllLines(Paths.get(importedFile));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        Pattern p_kerdesszam = Pattern.compile("^([0-9]*).(.*)");
        Pattern p_megoldas = Pattern.compile("^Megoldás:\\s*([a-m]*)");
        Pattern p_valaszSzam = Pattern.compile("^([a-m])\\)");
        boolean megoldasflag = true;
        boolean valaszflag = false;
        String valasz = "";
        String kerdes = "";
        String valaszSzam = "";
        String megoldas = "";
        int kerdesSzam = 0;
        vizsgakerdesek = new ArrayList<>();
        List<VizsgaValasz> vizsgavalaszok = new ArrayList<>();
        VizsgaValasz vizsgaValasz = null;
        for (String line : text) {
            Matcher m_kerdesszam = p_kerdesszam.matcher(line);
            if (megoldasflag && m_kerdesszam.find() && m_kerdesszam.group(0).length() > 0) {
                megoldasflag = false;
                kerdesSzam = Integer.parseInt(m_kerdesszam.group(1));
                kerdes = m_kerdesszam.group(2).trim();
                vizsgaValasz = new VizsgaValasz();
                System.out.println(line);
                continue;
            }
            System.out.println(line);
            Matcher m_valaszSzam = p_valaszSzam.matcher(line);
            if (m_valaszSzam.find()) {
                valaszSzam = m_valaszSzam.group(1);
                valasz = line.replaceFirst("^[a-m]\\)[ ]*", "");
                valaszflag = true;
                vizsgaValasz = new VizsgaValasz();
                vizsgaValasz.setValasz(valasz);
                vizsgaValasz.setValaszSzam(valaszSzam);
                vizsgavalaszok.add(vizsgaValasz);
            } else if (!megoldasflag && !valaszflag){
                kerdes += System.lineSeparator()+line;
            } 
            else if (valaszflag){
                valasz += line;
                vizsgaValasz.setValaszSzam(valasz);
            }
            Matcher m2 = p_megoldas.matcher(line);
            if (m2.find() && !megoldasflag && m2.group(0).length() > 0) {
                megoldasflag = true;
                valaszflag = false;
                megoldas = m2.group(1);
                VizsgaKerdes vizsgaKerdes = new VizsgaKerdes(kerdesSzam, kerdes);
                for (VizsgaValasz v : vizsgavalaszok) {
                    vizsgaKerdes.getValaszok().add(v);
                }
                vizsgaKerdes.setMegoldas(megoldas);
                vizsgakerdesek.add(vizsgaKerdes);
                vizsgavalaszok = new ArrayList<>();
                System.out.println(String.join(",", m2.group(1).split("")) + "; groupcount:" + m2.groupCount());
            }
        }
        System.out.println(vizsgakerdesek.get(110).kerdes);
        System.out.println("");
    }
    
    public static void peldaStatic(ImportKerdesek ik){
        System.out.println(ik.vizsgakerdesek.get(110).kerdes);
    }
     
    
    public static void main(String[] args) {
        ImportKerdesek importkerdesek = new ImportKerdesek();
        importkerdesek.readFile();
        ImportKerdesek.peldaStatic(importkerdesek);
        System.out.println("");
        
        Set<VizsgaKerdes> y=importkerdesek.vizsgakerdesek.stream().filter(x->x.kerdesSzam%4==0).collect(Collectors.toSet());
        for( var k: y){
            System.out.println(String.format("Kérdésszám:%d ; Megoldás:%s",k.kerdesSzam,k.megoldas));
        }
    }
}
