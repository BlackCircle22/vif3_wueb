package wueb;

//Test
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Csv {

    private final String csvBuchFileName;
    private final File csvBuchFile;
    private final File csvLoginFile;
    private final String csvKontenFileName;
    private final File csvKontenFile;
    private final String csvLoginFileName;
    private PrintWriter csvBuchPW;
    private PrintWriter csvLoginPW;
    
    public Csv(String csvBuch, String csvKonten, String csvLogin) throws FileNotFoundException {
        this.csvBuchFileName = csvBuch;
        csvBuchFile = new File(csvBuchFileName);
        this.csvKontenFileName = csvKonten;
        csvKontenFile = new File(csvKontenFileName);
        this.csvLoginFileName = csvLogin;
        csvLoginFile = new File(csvLoginFileName);
    }
      
    public Boolean pruefenVorhandenCsvLogin()throws FileNotFoundException {
        if (!this.csvLoginFile.exists() && !this.csvLoginFile.isDirectory()) {
            System.out.println("Datei Login nicht vorhanden! 1");
            return false;
        }
        else {
            System.out.println("Datei Login existiert! 1");
            return true;
        }
    }
    public String lesenCsvLogin() throws FileNotFoundException, IOException {
 
        String login = "";

        if (this.pruefenVorhandenCsvLogin()){
            BufferedReader br = new BufferedReader(new FileReader(csvLoginFileName));
            Scanner scanner = new Scanner(br);
            //scanner.useDelimiter(";");
//            System.out.println("Lese Login ...");
            while(scanner.hasNextLine()){
                login = scanner.nextLine();
            }
            scanner.close();
            br.close();
        }
        else {
            login = "Kein Login vorhanden; undefiniert";
            System.out.println(login);
        }
        return login;
    }

    public Boolean pruefenVorhandenCsvBuch()throws FileNotFoundException {
        if (!this.csvBuchFile.exists() && !this.csvBuchFile.isDirectory()) {
            System.out.println("Datei Buchungen nicht vorhanden! 1");
            return false;
        }
        else {
            System.out.println("Datei Buchungen existiert! 1");
            return true;
        }
    }
    public boolean buchungenCsvErstellen() throws FileNotFoundException {
        if (this.pruefenVorhandenCsvBuch()) {
            System.out.println("Datei Buchungen existiert bereits, Append aktiv! 2");
            this.csvBuchPW = new PrintWriter(new FileOutputStream(new File(this.csvBuchFileName), true));
            this.csvBuchPW.close();
            return false;
        }
        else {
            System.out.println("Datei Buchungen erstellt! 2");
            this.csvBuchPW = new PrintWriter(this.csvBuchFileName);
            this.csvBuchPW.println("Datum;Betrag;Buchungsart;Buchungstext;Steuerschluessel");
            this.csvBuchPW.close();
            return true;
        }
    }
    public boolean lgoinCsvErstellen() throws FileNotFoundException {
        if (this.pruefenVorhandenCsvLogin()) {
            System.out.println("Datei Login existiert bereits, Append aktiv! 2");
            this.csvLoginPW = new PrintWriter(new FileOutputStream(new File(this.csvLoginFileName), true));
            this.csvLoginPW.close();
            return false;
        }
        else {
            System.out.println("Datei Login erstellt! 2");
            this.csvLoginPW = new PrintWriter(this.csvLoginFileName);
            this.csvLoginPW.println("Benutzername; Passwort");
            this.csvLoginPW.close();
            return true;
        }
    }

    public void neueBuchungSchreiben(String datum , double betrag , Buchungsart buchungsart , String buchungstext , Steuerschluessel steuerschluessel ) throws FileNotFoundException {
        this.csvBuchPW = new PrintWriter(new FileOutputStream(new File(this.csvBuchFileName), true));
        this.csvBuchPW.write(datum + ";" + betrag + ";" + buchungsart + ";" + buchungstext + ";" + steuerschluessel);
        this.csvBuchPW.println();
        this.csvBuchPW.close();
    }
    public void neuesLoginSchreiben(String userName , String password ) throws FileNotFoundException {
        this.csvLoginPW = new PrintWriter(new FileOutputStream(new File(this.csvLoginFileName), true));
        this.csvLoginPW.write(userName + ";" + password);
        this.csvLoginPW.println();
        this.csvLoginPW.close();
    }

    public double summeEinnahmen() throws IOException {
        double betrag = 0.00;
        int anzZeilen = anzahlZeilenCsvBuch(2);
        String[][] buchEin = this.lesenCsvEinnamen_ktonr_dat_text_betrag_steuer();
        for (int i=0;i<anzZeilen;i++) {
            if (buchEin[i][1] != null)
              betrag = betrag + Double.parseDouble(buchEin[i][1]);
        //      System.out.println("Einnahmen-Betrag addiert: " + buchEin[1]);
        }
        return betrag;
    }

    public double summeAusgaben() throws IOException {
        double betrag = 0.00;
        int anzZeilen = anzahlZeilenCsvBuch(1);
        String[][] buchAus = this.lesenCsvAusgaben_ktonr_dat_text_betrag_steuer();
        for (int i=0;i<anzZeilen;i++) {
            if (buchAus[i][1] != null)
              betrag = betrag + Double.parseDouble(buchAus[i][1]);
         //     System.out.println("Ausgaben-Betrag addiert: " + buchAus[i][1]);
        }
        return betrag;
    }

    public boolean pruefenVorhandenCsvKonten() {
        if (!this.csvKontenFile.exists() && !this.csvKontenFile.isDirectory()) {
            System.out.println("Datei Konten nicht vorhanden!");
            return false;
        }
        else {
            System.out.println("Datei Konten existiert!");
            return true;
        }
    }

    public String[][] lesenCsvKonten_ktonr_bez() throws FileNotFoundException, IOException {
//      System.out.println("Lese Konten - Pruefung");
        String[][] konten = new String[1196][3];

        if (this.pruefenVorhandenCsvKonten()){
            BufferedReader br = new BufferedReader(new FileReader(csvKontenFileName));
            Scanner scanner = new Scanner(br);
            //scanner.useDelimiter(";");
            System.out.println("Lese Konten .....");
            int i = 0;
            
            while(scanner.hasNextLine()){
                String[] kontenSplit = scanner.nextLine().split(";");
                for (int row=0;row<3;row++){
                    konten[i][row] = kontenSplit[row];
                }
//              System.out.println("Kontonr: " + konten[i][0] + " Bezeichnung: " + konten[i][1] );
                i++;
            }
            scanner.close();
            br.close();
        }
        else {
            konten[0][0] = "0000";
            konten[0][1] = "Keine Konten vorhanden!";
            konten[0][2] = "undefiniert";
            System.out.println(konten[0][1]);
        }
        return konten;
    }

    public String[][] lesenCsvEinnamen_ktonr_dat_text_betrag_steuer() throws FileNotFoundException, IOException {
        // Buchungsart.Ausgangsrechnung
        int anzZeilen = anzahlZeilenCsvBuch(2);
        String[] buchEinZeile = new String[anzZeilen];
        String[][] buchEin = new String[anzZeilen][5];

        if (this.pruefenVorhandenCsvBuch()){
            BufferedReader br = new BufferedReader(new FileReader(csvBuchFileName));
            Scanner scanner = new Scanner(br);
            //scanner.useDelimiter(";");
            System.out.println("Lese Einnahmen ...");
            int i = 0;
            while(scanner.hasNextLine()){
                buchEinZeile[i] = scanner.nextLine();
                String[] buchSplit = buchEinZeile[i].split(";");
//                System.out.println("Datum: " + buchSplit[0] + " Betrag: " + buchSplit[1] );
                if (buchSplit[2].equals("Ausgangsrechnung")) {
//                    System.out.println("Ausgangsrechnung erkannt!");
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
            br.close();
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
    private int anzahlZeilenCsvBuch(int wasTun) throws FileNotFoundException, IOException {
    
        int rueckGabeWert = 0;
        if (this.pruefenVorhandenCsvBuch()){
            BufferedReader br = new BufferedReader(new FileReader(csvBuchFileName));
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
            br.close();
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

    public String[][] lesenCsvAusgaben_ktonr_dat_text_betrag_steuer() throws FileNotFoundException, IOException {
        // Buchungsart.Eingangsrechnung

        int anzZeilen = anzahlZeilenCsvBuch(1);
        String[] buchAusZeile = new String[anzZeilen];
        String[][] buchAus = new String[anzZeilen][5];
        

        if (this.pruefenVorhandenCsvBuch()){
            BufferedReader br = new BufferedReader(new FileReader(csvBuchFileName));
            Scanner scanner = new Scanner(br);
            //scanner.useDelimiter(";");
            System.out.println("Lese Ausgaben ...");
            int i = 0;
            while(scanner.hasNextLine()){
                buchAusZeile[i] = scanner.nextLine();
//                System.out.println(""+buchAusZeile[i]);
                String[] buchSplit = buchAusZeile[i].split(";");
//              System.out.println("Datum: " + buchSplit[0] + " Betrag: " + buchSplit[1] );
                if (buchSplit[2].equals("Eingangsrechnung")) {
//                    System.out.println("Eingangsrechnung gefunden!");
                    for (int row = 0; row<5; row++){
                        buchAus[i][row] = buchSplit[row];
                    }
                    i++;
                } else {
                    // buchAus[i] = null;
                    //sollte eigentlich nicht passieren
                    System.out.println("Fehler in Logik - Keine Eingangsrechnung!");
                }
            }
            scanner.close();
            br.close();
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
}
