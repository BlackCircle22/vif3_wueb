
import java.io.FileNotFoundException;
import java.io.IOException;

public class WUEB {

    private Csv csv ;

    //private Csv csvKonten ;

    private int csvBuchAktZeile;

    private String konten[];

    private String einnahmen[];

    private String ausgaben[];

    private int regNummer;

    public WUEB() throws FileNotFoundException, IOException {
        this.csv = new Csv("buchungen.csv", "skr03.csv");
        if (!csv.pruefenVorhandenCsvKonten()){
            System.out.println("Konten müssen zwingend vorhanden sein, Programmabbruch!");
            // --> Applikation schließen ===
            System.exit(0);
        }
        if (!csv.pruefenVorhandenCsvBuch()) {
            csv.buchungenCsvErstellen();
        }
        konten = new String[1196];
        konten = csv.lesenCsvKonten_ktonr_bez();
        System.out.println("Test konto 1: " + konten[1]);
        String[] kontenSplit = konten[275].split(";");
        System.out.println("Kontonr: " + kontenSplit[0] + " Bezeichnung: " + kontenSplit[1] );
        
        this.csv.neueBuchungSchreiben("12.12.1212", 47.11, Buchungsart.Ausgangsrechnung, "TestBuchung1", Steuerschluessel.Mehrwertsteuer_19);
        this.csv.neueBuchungSchreiben("13.12.1212", 147.11, Buchungsart.Ausgangsrechnung, "TestBuchung2", Steuerschluessel.Mehrwertsteuer_19);
        this.csv.neueBuchungSchreiben("14.12.1212", 247.11, Buchungsart.Ausgangsrechnung, "TestBuchung3", Steuerschluessel.Mehrwertsteuer_19);
        this.csv.neueBuchungSchreiben("15.12.1212", 347.11, Buchungsart.Ausgangsrechnung, "TestBuchung4", Steuerschluessel.Mehrwertsteuer_19);
        this.csv.neueBuchungSchreiben("16.12.1212", 447.11, Buchungsart.Ausgangsrechnung, "TestBuchung5", Steuerschluessel.Mehrwertsteuer_19);
        this.csv.neueBuchungSchreiben("17.12.1212", 547.11, Buchungsart.Ausgangsrechnung, "TestBuchung6", Steuerschluessel.Mehrwertsteuer_19);
        this.csv.neueBuchungSchreiben("18.12.1212", 647.11, Buchungsart.Ausgangsrechnung, "TestBuchung7", Steuerschluessel.Mehrwertsteuer_19);
        this.csv.neueBuchungSchreiben("19.12.1212", 747.11, Buchungsart.Ausgangsrechnung, "TestBuchung8", Steuerschluessel.Mehrwertsteuer_19);
        this.csv.neueBuchungSchreiben("20.12.1212", -123.11, Buchungsart.Eingangsrechnung, "TestBuchung9", Steuerschluessel.Vorsteuer_19);
        
        double betragEin = this.csv.summeEinnahmen();
        System.out.println("Einnahmen Bettrag Summe  " + betragEin);
        
        this.einnahmen = csv.lesenCsvEinnamen_ktonr_dat_text_betrag_steuer();
        System.out.println(this.einnahmen[1]);
        System.out.println("Einnahmen Anzahl Zeilen  " + this.einnahmen.length);
        
    }

    public void guiWUEBinitausWUEB() {
    }

    public void guiNeueBuchungen() {
    }
}
