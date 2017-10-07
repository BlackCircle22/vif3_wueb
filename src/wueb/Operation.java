import java.text.*;

DecimalFormat f = new DecimalFormat("#0.00"); 
public class Operation {

    public Double umsatzsteuerBerechnen(Double bruttoBetrag, Double steuerProzent) {
        //throw new UnsupportedOperationException("Not supported yet.");
        double e1 = 100 + steuerProzent;
        //System.out.println(e1);
        double e2 = bruttoBetrag /e1;
        //System.out.println(e2);
        double e3 = e2 * steuerProzent;
		//Rundung beginnt hier
		e3 = e3 * 100;
		e3 = Math.round(e3);
		e3 = e3 / 100;
        return e3;
    }

    public Double nettoBerechnen(Double bruttoBetrag, Double steuerProzent) {
        //throw new UnsupportedOperationException("Not supported yet.");
		double n1 = steuerProzent / 100;
		double n2 = n1 * steuerProzent;
		double n3 = bruttoBetrag + n2;
		//Rundung beginnt hier
		n3 = n3 * 100;
		n3 = Math.round(n3);
		n3 = n3 / 100;
        return n3;
    }

    public Double summeUeberschuss(Double einnahme, Double ausgaben) {
        //throw new UnsupportedOperationException("Not supported yet.");
		s1 = einnahme - ausgaben;
		//Rundung beginnt hier
		s1 = s1 * 100;
		s1 = Math.round(s1);
		s1 = s1 / 100;
        return s1;
    }
}
