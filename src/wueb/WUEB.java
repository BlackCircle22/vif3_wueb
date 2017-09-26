package wueb;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WUEB {

    private Csv csv ;
//    private int csvBuchAktZeile;
    private String konten[][];
    private String einnahmen[][];
    private String ausgaben[][];
    private String zeileLogin;
    private String userName;
    private String userPassword;
    private String userPasswordClear;
//    private int regNummer;

    public WUEB() throws FileNotFoundException, IOException {

        this.csv = new Csv("buchungen.csv", "skr03.csv", "login.csv");
        if (!csv.pruefenVorhandenCsvKonten()){
            System.out.println("Konten müssen zwingend vorhanden sein, Programmabbruch!");
            // --> Applikation schließen ===
            System.exit(0);
        }
        if (!csv.pruefenVorhandenCsvBuch()) {
            csv.buchungenCsvErstellen();
        }

        /* Testbuchungen */
        this.csv.neueBuchungSchreiben("12.12.1212", 47.11, Buchungsart.Ausgangsrechnung, "TestBuchung1", Steuerschluessel.Mehrwertsteuer_19);
        this.csv.neueBuchungSchreiben("13.12.1212", 147.11, Buchungsart.Ausgangsrechnung, "TestBuchung2", Steuerschluessel.Mehrwertsteuer_19);
        this.csv.neueBuchungSchreiben("14.12.1212", 247.11, Buchungsart.Ausgangsrechnung, "TestBuchung3", Steuerschluessel.Mehrwertsteuer_19);
        this.csv.neueBuchungSchreiben("15.12.1212", 347.11, Buchungsart.Ausgangsrechnung, "TestBuchung4", Steuerschluessel.Mehrwertsteuer_19);
        this.csv.neueBuchungSchreiben("16.12.1212", 447.11, Buchungsart.Ausgangsrechnung, "TestBuchung5", Steuerschluessel.Mehrwertsteuer_19);
        this.csv.neueBuchungSchreiben("17.12.1212", 547.11, Buchungsart.Ausgangsrechnung, "TestBuchung6", Steuerschluessel.Mehrwertsteuer_19);
        this.csv.neueBuchungSchreiben("18.12.1212", 647.11, Buchungsart.Ausgangsrechnung, "TestBuchung7", Steuerschluessel.Mehrwertsteuer_19);
        this.csv.neueBuchungSchreiben("19.12.1212", 747.11, Buchungsart.Ausgangsrechnung, "TestBuchung8", Steuerschluessel.Mehrwertsteuer_19);
        this.csv.neueBuchungSchreiben("20.12.1212", -123.11, Buchungsart.Eingangsrechnung, "TestBuchung9", Steuerschluessel.Vorsteuer_19);
        /**/
        
        
        Login login = new Login();
        Operation operation = new Operation();
        ReadWriteDES rwDES = new ReadWriteDES();
        
        if (!csv.pruefenVorhandenCsvLogin()) {
            System.out.println("Erster Login, Login wird angelegt");
            csv.lgoinCsvErstellen();
            this.userName = "no";
            this.userPasswordClear = "no";
        } else {
            zeileLogin = csv.lesenCsvLogin();
            String splitLogin [] = zeileLogin.split(";");
            this.userName = splitLogin[0];
            this.userPassword = splitLogin[1];
            this.userPasswordClear = rwDES.entschluesseln(this.userPassword);
        }
        
        // in guiLogin fehlt entsprechender Konstruktur
        // guiLOGIN gLogin = new guiLOGIN(login, this.userName, this.userPasswordClear);
        // boolean loginErfolg = gLogin.setVisible(true);
        if (login.getLoginRichtig()) {
            // --- hier gehts weiter
            this.konten = csv.lesenCsvKonten_ktonr_bez();
            this.ausgaben = csv.lesenCsvAusgaben_ktonr_dat_text_betrag_steuer();
            this.einnahmen = csv.lesenCsvEinnamen_ktonr_dat_text_betrag_steuer();
            double ausgabenBetrag = operation.nettoBerechnen(csv.summeAusgaben(), 19.00);
            double einnamenBetrag = operation.nettoBerechnen(csv.summeEinnahmen(), 19.00);
            double ueberschussBetrag = operation.summeUeberschuss(einnamenBetrag, ausgabenBetrag);
            // guiWUEB gWueb = new guiWUEB(this.konten, this.ausgaben, this.einnahmen, ausgabenBetrag, ausgabenBetrag, ueberschussBetrag);
            // gWueb.setVisible(true)
        }
        
  //      gLogin.dispose();
        
    }
      public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        WUEB wueb = new WUEB();
     }
}
