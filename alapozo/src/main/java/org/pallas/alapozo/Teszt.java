package org.pallas.alapozo;

import java.util.*;

public class Teszt {

    public String welcome;
    public Util util;

    public String a,b;

    public Teszt() {
        welcome = "Szia";
        util = new Util();
        b="Alma";
        a = "Alma";
    }

    public static void main(String[] args) {
        int a = 3;
        Teszt t = new Teszt();
        
        System.out.println("A változó= " + a + ", ");
        Teszt t3 = new Teszt();
        System.out.println("A változó= " + t.hashCode()+" , "+t3.hashCode());
        TesztUtil tutil = new TesztUtil(t3);

        tutil.urit();
        t.print(t3);
        // print(args);
        String[] fiok = new String[]{"fürdő", "nappali", "Világ!"};
        // String[] fiok=null;
        t.print2(fiok);
    }

    public void print(Teszt t3) {
        // public static void print(String t[]) {
        // Teszt teszt = new Teszt();
        // teszt.util = new Util();
        t3.util.print();
        System.out.println(t3.welcome + " world!");
        t3.welcome = "Hello";
    }

    public void print2(String[] t) {
        if (util == null) {
            return;
        }
        if (t == null && t.length >= 3) {
            return;
        }
        util.print();
        System.out.println(this.welcome + " " + t[2]);
    }
}
