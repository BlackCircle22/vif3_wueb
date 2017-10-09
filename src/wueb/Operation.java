package wueb;

import java.text.*;

public class Operation {
    DecimalFormat f = new DecimalFormat("#0.00"); 

    public Double umsatzsteuerBerechnen(Double bruttoBetrag, Double steuerProzent) {
        //throw new UnsupportedOperationException("Not supported yet.");
        double e1 = 100 + steuerProzent; 
        System.out.println(e1);
        double e2 = bruttoBetrag /e1; 
        System.out.println(e2);
        double e3 = e2 * steuerProzent; 
	//Rundung beginnt hier
	e3 = e3 * 100;
	e3 = Math.round(e3);
	e3 = e3 / 100;
//        System.out.println("Steuerbetrag1: " + e3);
        return e3;
    }

    public Double nettoBerechnen(Double bruttoBetrag, Double steuerProzent) {
        DecimalFormat f = new DecimalFormat("#0.00"); 
        double e1 = 100 + steuerProzent; 
        System.out.println(e1);
        double e2 = bruttoBetrag /e1; 
        System.out.println(e2);
        double e3 = e2 * steuerProzent; 
	//Rundung beginnt hier
	e3 = e3 * 100;
	e3 = Math.round(e3);
	e3 = e3 / 100;
//        System.out.println("Steuerbetrag2: " + e3);
        double nettoBetrag = bruttoBetrag - e3;
//        System.out.println("Nettobetrag: " + nettoBetrag);
        return nettoBetrag;
    }

    public Double summeUeberschuss(Double einnahme, Double ausgaben) {
        //throw new UnsupportedOperationException("Not supported yet.");
		double s1 = einnahme - ausgaben;
		//Rundung beginnt hier
		s1 = s1 * 100;
		s1 = Math.round(s1);
		s1 = s1 / 100;
        return s1;
    }
}
