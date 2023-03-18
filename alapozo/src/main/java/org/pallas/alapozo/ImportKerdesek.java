package org.pallas.alapozo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern p_kerdesszam = Pattern.compile("^([0-9]*).");
        Pattern p_megoldas = Pattern.compile("^(Megoldás:\\s*)([a-m]*)");
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
                kerdes = m_kerdesszam.group(2);
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
            } else {
                valasz += line;
                vizsgaValasz.setValaszSzam(valasz);
            }
            Matcher m2 = p_megoldas.matcher(line);
            if (m2.find() && !megoldasflag && m2.group(0).length() > 0) {
                megoldasflag = true;
                megoldas = m2.group(1);
                VizsgaKerdes vizsgaKerdes = new VizsgaKerdes(kerdesSzam, kerdes);
                for (VizsgaValasz v : vizsgavalaszok) {
                    vizsgaKerdes.getValaszok().add(v);
                }
                vizsgaKerdes.setMegoldas(megoldas);
                vizsgakerdesek.add(vizsgaKerdes);
                vizsgavalaszok = new ArrayList<>();
                System.out.println(String.join(",", m2.group(2).split("")) + "; groupcount:" + m2.groupCount());
            }
        }
    }

    public static void main(String[] args) {
        ImportKerdesek importkerdesek = new ImportKerdesek();
        importkerdesek.readFile();
        System.out.println("");
    }
}
