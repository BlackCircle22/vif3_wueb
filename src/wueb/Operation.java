public class Operation {

    public Double umsatzsteuerBerechnen(Double bruttoBetrag, Double steuerProzent) {
        //throw new UnsupportedOperationException("Not supported yet.");
        double e1 = 100 + steuerProzent;
        System.out.println(e1);
        double e2 = bruttoBetrag /e1;
        System.out.println(e2);
        double e3 = e2 * steuerProzent;
        return e3;
    }

    public Double nettoBerechnen(Double bruttoBetrag, Double steuerProzent) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return bruttoBetrag + (bruttoBetrag * (steuerProzent / 100));
    }

    public Double summeUeberschuss(Double einnahme, Double ausgaben) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return einnahme - ausgaben;
    }
}
