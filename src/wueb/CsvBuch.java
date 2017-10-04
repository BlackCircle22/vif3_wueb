package wueb;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Klasse zum Handling der Datei Buch.csv
 *
 * @author Martin Lesch 
 *
 * @version 1.0 
 *
*/ 
public class CsvBuch {

    private final String csvBuchFileName;
    private final File csvBuchFile;
    private PrintWriter csvBuchPW;
    String path = null;
    
    public CsvBuch() {
    
        try {
            this.path = new File(".").getCanonicalPath();
        } catch (IOException ex) {
               System.out.println("Fehler 101 - Aktuelles Verzeichnis nicht verfuegbar! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
               System.exit(1);
        } 
//!!!!!! Anpassung des Pfades hinsichtlich des namens des Package
// --------->>>>>>>>>>>>>> testcsv durch den Namen des PACKAGE ersetzen (eg. wueb) <<<<<<<<<<<<<<<<--------------------!!!!!!!!!!!!!!!!
        this.path = this.path + "\\src" + "\\wueb\\";
//      System.out.println(path);
        this.csvBuchFileName = "Buch.csv";
        csvBuchFile = new File(this.path + csvBuchFileName);
    }

    /*
    * @return true, wenn buch.csv existiert.
    */
    public Boolean checkIfExists() {
        if (!this.csvBuchFile.exists() && !this.csvBuchFile.isDirectory()) {
            System.out.println("Datei Buchungen nicht vorhanden!");
            return false;
        }
        else {
//            System.out.println("Datei Buchungen existiert! 1");
            return true;
        }
    }

    /*
    * @return true, wenn Buch.csv erfolgreich angelegt wurde.
    */
    public boolean createCsvBuch()  {
        if (this.checkIfExists()) {
            //    System.out.println("Datei Buchungen existiert bereits, Append aktiv! 2");
            //try {
            //    this.csvBuchPW = new PrintWriter(new FileOutputStream(new File(this.path + this.csvBuchFileName), true));
            //    this.csvBuchPW.close();
            //} catch (FileNotFoundException ex) {
            //    System.out.println("Fehler 110 - sollte da sein - aber?! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
            //}
            //this.csvBuchPW.close();
            return false;
        }
        else {
            System.out.println("Datei Buchungen wird erstellt im Verzeichnis: " + this.path);
            try {
                this.csvBuchPW = new PrintWriter(this.path + this.csvBuchFileName);
                this.csvBuchPW.println("Datum;Betrag;Buchungsart;Buchungstext;Steuerschluessel");
                this.csvBuchPW.close();
                return true;
            } catch (FileNotFoundException ex) {
                System.out.println("Fehler 102 - Datei konnte nicht angelegt werden! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
                return false;
            }
        }
    }

    /*
    * Schreibt Buchung in Buch.csv
    */
    public void writeBuchung(String datum , double betrag , Buchungsart buchungsart , String buchungstext , Steuerschluessel steuerschluessel ) {
        try {
            this.csvBuchPW = new PrintWriter(new FileOutputStream(new File(this.path + this.csvBuchFileName), true));
            this.csvBuchPW.write(datum + ";" + betrag + ";" + buchungsart + ";" + buchungstext + ";" + steuerschluessel);
            this.csvBuchPW.println();
            this.csvBuchPW.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fehler 103 - Buchung konnte nicht geschrieben werden! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
        }
    }

    /*
    * @return Nettobetrag aller Einnahmen (== Ausgangsrechnungen).
    */
    public double getEinnahmenSum() {
        double betrag = 0.00;
        int lines = countLines(2);
        Operation op = new Operation();
        String[][] buchEin = this.getEinnahmenDetails();
        
        for (int i=0; i<lines; i++) {
            if (buchEin[i][1] != null){
              betrag = betrag + op.nettoBerechnen(Double.parseDouble(buchEin[i][1]), 19.00);
//            System.out.println("Einnahmen-Betrag addiert: " + buchEin[1]);
            }
        }
        op = null;
        buchEin = null;
        return betrag;
    }

    /*
    * @return Nettobetrag aller Ausgaben (== Eingangsrechnungen).
    */
    public double getAusgabenSum() {
        double betrag = 0.00;
        int lines = countLines(1);
        Operation op = new Operation();
        String[][] buchAus = this.getAusgabenDetails();

        for (int i=0; i<lines; i++) {
            if (buchAus[i][1] != null)
              betrag = betrag + op.nettoBerechnen(Double.parseDouble(buchAus[i][1]), 19.00);
//            System.out.println("Ausgaben-Betrag addiert: " + buchAus[i][1]);
        }
        op = null;
        buchAus = null;
        return betrag;
    }

    /*
    * @return Einnahmen-Details im 2-dim. String-Array
    */
    public String[][] getEinnahmenDetails()  {
        // Buchungsart.Ausgangsrechnung
        int lines = countLines(2);
//        System.out.println("Anzahl Zeilen: " + lines);
        String buchEinZeile = "";
        String[][] buchEin = new String[lines][5];

        if (this.checkIfExists()){
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(this.path + this.csvBuchFileName));
            } catch (FileNotFoundException ex) {
                System.out.println("Fehler 108 - Einnahmen lesen! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
            }
            Scanner scanner = new Scanner(br);
            //scanner.useDelimiter(";");
            System.out.println("Lese Einnahmen ...");
            int i = 0;
            
            while(scanner.hasNextLine()){
                buchEinZeile = scanner.nextLine();
                String[] buchSplit = buchEinZeile.split(";");
  //              System.out.println("Datum: " + buchSplit[0] + " Betrag: " + buchSplit[1] );
                if (buchSplit[2].equals("Ausgangsrechnung")) {
  //                  System.out.println("Ausgangsrechnung erkannt!");
                    for (int row = 0; row < 5; row++) {
                        buchEin[i][row] = buchSplit[row];
                    }
                    i++;
                } else {
                   // buchEin[i] = null;
//                    System.out.println("Keine Ausgangsrechnung!");
                }
            }
            scanner.close();
            try {
                br.close();
            } catch (IOException ex) {
                System.out.println("Fehler 109 - Problem beim schliessen! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
            }
        }
        else {
            buchEin[0][0] = "0";
            buchEin[0][1] = "0";
            buchEin[0][2] = "undefiniert";
            buchEin[0][3] = "Keine Buchung (Ausgangsrechnung) vorhanden!";
            buchEin[0][4] = "undefiniert";
            System.out.println(buchEin[0][3]);
        }
        return buchEin;
    }

   /*
    * @return die Anzahl der Zeilen in buch.csv (ohne Ueberschrift!) WENN wasTun Default,
    *                                                                wenn 1 dann nur ER, 
    *                                                                wenn 2 dann nur AR
    *         
    */
    private int countLines(int wasTun) {
    
        int rueckGabeWert = 0;
        if (this.checkIfExists()){
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(this.path + this.csvBuchFileName));
            } catch (FileNotFoundException ex) {
                System.out.println("Fehler 104 - Zaehlen nicht moeglilch, nicht vorhanden! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
            }
            Scanner scanner = new Scanner(br);
            int anzEingangsrechnungen = 0;
            int anzAusgangsrechnungen = 0;
            while(scanner.hasNextLine()){
                String[] buchSplit = scanner.nextLine().split(";");
                if (buchSplit[2].equals("Eingangsrechnung")) {
                    anzEingangsrechnungen = anzEingangsrechnungen +1;
                } else {
                    anzAusgangsrechnungen = anzAusgangsrechnungen +1;
                }
            }
            scanner.close();
            try {
                br.close();
            } catch (IOException ex) {
                System.out.println("Fehler 105 - Problem beim schliessen! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
            }
            switch (wasTun) {
                case 1: rueckGabeWert = anzEingangsrechnungen;
                        break;
                case 2: rueckGabeWert = anzAusgangsrechnungen;
                        break;
                default: rueckGabeWert =  anzEingangsrechnungen + anzAusgangsrechnungen;
                        break;
            }
           
        }
        else {
            rueckGabeWert = 0;
        }
        return rueckGabeWert;
    }
    
    /*
    * @return alle Eingangsrechnungen im Detail (2-dim String_Array)
    */
    public String[][] getAusgabenDetails()  {
        // Buchungsart.Eingangsrechnung

        int lines = countLines(1);
        String buchAusZeile = "";
        String[][] buchAus = new String[lines][5];

        if (this.checkIfExists()){
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(this.path + this.csvBuchFileName));
            } catch (FileNotFoundException ex) {
                System.out.println("Fehler 106 - Buchungsdatei kann nicht gefunden werden! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
            }
            Scanner scanner = new Scanner(br);
            //scanner.useDelimiter(";");
            System.out.println("Lese Ausgaben ...");
            int i = 0;
            while(scanner.hasNextLine()){
                buchAusZeile = scanner.nextLine();
//                System.out.println(""+buchAusZeile[i]);
                String[] buchSplit = buchAusZeile.split(";");
//              System.out.println("Datum: " + buchSplit[0] + " Betrag: " + buchSplit[1] );
                if (buchSplit[2].equals("Eingangsrechnung")) {
//                    System.out.println("Eingangsrechnung gefunden!");
                    for (int row = 0; row<5; row++){
                        buchAus[i][row] = buchSplit[row];
                    }
                    i++;
                } else {
                    // buchAus[i] = null;
                    //System.out.println("Keine Eingangsrechnung!");
                }
            }
            scanner.close();
            try {
                br.close();
            } catch (IOException ex) {
                System.out.println("Fehler 107 - Problem beim schliessen! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
            }
        }
        else {
            buchAus[0][0] = "0";
            buchAus[0][1] = "0";
            buchAus[0][2] = "undefiniert";
            buchAus[0][3] = "Keine Buchung (Eingangsrechnung) vorhanden!";
            buchAus[0][4] = "undefiniert";
            System.out.println(buchAus[0][3]);
        }
        return buchAus;
    }
    
    /* zum Testen *****************************************************
     public static void main(String[] args)  {
        // TODO code application logic here
        CsvBuch csvBuch = new CsvBuch();

        csvBuch.writeBuchung("12.12.1212", 47.11, Buchungsart.Ausgangsrechnung, "TestBuchung1", Steuerschluessel.Mehrwertsteuer_19);
        csvBuch.writeBuchung("13.12.1212", 147.11, Buchungsart.Ausgangsrechnung, "TestBuchung2", Steuerschluessel.Mehrwertsteuer_19);
        csvBuch.writeBuchung("14.12.1212", 247.11, Buchungsart.Ausgangsrechnung, "TestBuchung3", Steuerschluessel.Mehrwertsteuer_19);
        csvBuch.writeBuchung("15.12.1212", 347.11, Buchungsart.Ausgangsrechnung, "TestBuchung4", Steuerschluessel.Mehrwertsteuer_19);
        csvBuch.writeBuchung("16.12.1212", 447.11, Buchungsart.Ausgangsrechnung, "TestBuchung5", Steuerschluessel.Mehrwertsteuer_19);
        csvBuch.writeBuchung("17.12.1212", 547.11, Buchungsart.Ausgangsrechnung, "TestBuchung6", Steuerschluessel.Mehrwertsteuer_19);
        csvBuch.writeBuchung("18.12.1212", 647.11, Buchungsart.Ausgangsrechnung, "TestBuchung7", Steuerschluessel.Mehrwertsteuer_19);
        csvBuch.writeBuchung("19.12.1212", 747.11, Buchungsart.Ausgangsrechnung, "TestBuchung8", Steuerschluessel.Mehrwertsteuer_19);
        csvBuch.writeBuchung("20.12.1212", -123.11, Buchungsart.Eingangsrechnung, "TestBuchung9", Steuerschluessel.Vorsteuer_19);

        String[][] csvBuchMain = csvBuch.getAusgabenDetails();
        System.out.println("Datum: " + csvBuchMain[1][0] + " Betrag: " + csvBuchMain[1][1] + " " + csvBuchMain[1][3]);
        Double ausgabenSumme = csvBuch.getAusgabenSum();
        System.out.println("Summe Ausgaben: " + ausgabenSumme);
        

     } 
     */

}
