package wueb;
public class Operation {

    public Double umsatzsteuerBerechnen(double bruttoBetrag, double steuerProzent) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double nettoBerechnen(double bruttoBetrag, double steuerProzent) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double summeUeberschuss(double einnahmen, double ausgaben) {
        
        double summeUeberschuss = einnahmen - ausgaben;
        
        return summeUeberschuss;
          
    }

    String summeUeberschuss() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
