package org.pallas.alapozo;

import ch.qos.logback.core.CoreConstants;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private Connection c = null;

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
            Matcher m2 = p_megoldas.matcher(line);
            boolean megoldasSor = m2.find();
            if (m_valaszSzam.find()) {
                valaszSzam = m_valaszSzam.group(1);
                valasz = line.replaceFirst("^[a-m]\\)[ ]*", "");
                valaszflag = true;
                vizsgaValasz = new VizsgaValasz();
                vizsgaValasz.setValasz(valasz);
                vizsgaValasz.setValaszSzam(valaszSzam);
                vizsgavalaszok.add(vizsgaValasz);
            } else if (!megoldasflag && !valaszflag) {
                kerdes += System.lineSeparator() + line;
            } else if (valaszflag && !megoldasSor ) {
                valasz += line;
                vizsgaValasz.setValasz(valasz);
            }
            
            if (megoldasSor && !megoldasflag && m2.group(0).length() > 0) {
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
//        System.out.println(vizsgakerdesek.get(110).kerdes);
        System.out.println("");
    }

    public static void peldaStatic(ImportKerdesek ik) {
//        System.out.println(ik.vizsgakerdesek.get(110).kerdes);
    }

    private void saveKerdesek() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/pallas",
                            "pallas", "Oktato123");
            c.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        //Set<VizsgaKerdes> y = vizsgakerdesek.stream().filter(x -> x.kerdesSzam % 4 == 0).collect(Collectors.toSet());
        for (var k : vizsgakerdesek) {
            PreparedStatement stmt_question = c.prepareStatement("insert into question (question_number,question,solution) values(?,?,?)",Statement.RETURN_GENERATED_KEYS);

            stmt_question.setInt(1, k.kerdesSzam);
            stmt_question.setString(2, k.kerdes);
            stmt_question.setString(3, k.megoldas);

            int affectedQuestionRows = stmt_question.executeUpdate();
            int question_id = 0;
            if (affectedQuestionRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt_question.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    question_id = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            for (var a : k.valaszok) {
                PreparedStatement stmt_answare = c.prepareStatement("insert into answare (answare_number,answare,question_id) values(?,?,?)");
                stmt_answare.setString(1,a.valaszSzam);
                stmt_answare.setString(2, a.valasz);
                stmt_answare.setInt(3, question_id);
                int affectedRows = stmt_answare.executeUpdate();
                if (affectedRows ==0 ) {
                    throw new SQLException("Creating user failed, no rows affected.");
                }
            }
            c.commit();
            

            System.out.println(String.format("Kérdésszám:%d ; Megoldás:%s", k.kerdesSzam, k.megoldas));
        }
        c.close();
    }

    public static void main(String[] args) {
        ImportKerdesek importkerdesek = new ImportKerdesek();
        importkerdesek.readFile();
        ImportKerdesek.peldaStatic(importkerdesek);
        System.out.println("");
        try {
            importkerdesek.saveKerdesek();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        

    }
}
