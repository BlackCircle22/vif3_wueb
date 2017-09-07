
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
    private final String csvKontenFileName;
    private final File csvKontenFile;
    private PrintWriter csvBuchPW;
    
    public Csv(String csvBuch, String csvKonten) throws FileNotFoundException {
        this.csvBuchFileName = csvBuch;
        csvBuchFile = new File(csvBuchFileName);
        this.csvKontenFileName = csvKonten;
        csvKontenFile = new File(csvKontenFileName);
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

    public int naechsteBuchungLesen(int letzteZeile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void neueBuchungSchreiben(String datum , double betrag , Buchungsart buchungsart , String buchungstext , Steuerschluessel steuerschluessel ) throws FileNotFoundException {
        this.csvBuchPW = new PrintWriter(new FileOutputStream(new File(this.csvBuchFileName), true));
        this.csvBuchPW.write(datum + ";" + betrag + ";" + buchungsart + ";" + buchungstext + ";" + steuerschluessel);
        this.csvBuchPW.println();
        this.csvBuchPW.close();
    }

    public double summeEinnahmen() throws IOException {
        double betrag = 0.00;
        String[] buchEin = this.lesenCsvEinnamen_ktonr_dat_text_betrag_steuer();
        //Anzahl Zeilen muss noch bestimmt werden (i<9)
        for (int i=0;i<9;i++) {
            String [] buchSplit = buchEin[i].split(";");
            if (buchEin[i] != null)
              betrag = betrag + Double.parseDouble(buchSplit[1]);
              System.out.println("Einnahmen-Betrag addiert: " + buchSplit[1]);
        }
        return betrag;
    }

    public double summeAusgaben() throws IOException {
        double betrag = 0.00;
        String[] buchEin = this.lesenCsvAusgaben_ktonr_dat_text_betrag_steuer();
        //Anzahl Zeilen muss noch bestimmt werden (i<9)
        for (int i=0;i<9;i++) {
            String [] buchSplit = buchEin[i].split(";");
            if (buchEin[i] != null)
              betrag = betrag + Double.parseDouble(buchSplit[1]);
              System.out.println("Ausgaben-Betrag addiert: " + buchSplit[1]);
        }
        return betrag;
    }

    public String getBuchungstext(int zeilenNummer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getKontonummer(int zeilenNummer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public double getBruttoBetrag(int zeilenNummer) {
        throw new UnsupportedOperationException("Not supported yet.");
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

    public String[] lesenCsvKonten_ktonr_bez() throws FileNotFoundException, IOException {
 
        String[] konten = new String[1196];

        if (this.pruefenVorhandenCsvKonten()){
            BufferedReader br = new BufferedReader(new FileReader(csvKontenFileName));
            Scanner scanner = new Scanner(br);
            //scanner.useDelimiter(";");
            System.out.println("Lese Konten ...");
            int i = 0;
            while(scanner.hasNextLine()){
                konten[i] = scanner.nextLine();
//                System.out.println("Lese Konten ...2");
//                System.out.println(konten[i]);
                i++;
            }
            scanner.close();
            br.close();
        }
        else {
            konten[0] = "0000; Keine Koten vorhanden!; undefiniert";
            System.out.println(konten[0]);
        }
        return konten;
    }

    public String[] lesenCsvEinnamen_ktonr_dat_text_betrag_steuer() throws FileNotFoundException, IOException {
        // Buchungsart.Ausgangsrechnung

        String[] buchEin = new String[99];
        // --> muss noch Abfrage/Prüfung wieviel Zeilen rein

        if (this.pruefenVorhandenCsvBuch()){
            BufferedReader br = new BufferedReader(new FileReader(csvBuchFileName));
            Scanner scanner = new Scanner(br);
            //scanner.useDelimiter(";");
            System.out.println("Lese Einnahmen ...");
            int i = 0;
            while(scanner.hasNextLine()){
                buchEin[i] = scanner.nextLine();
                String[] buchSplit = buchEin[i].split(";");
                System.out.println("Datum: " + buchSplit[0] + " Betrag: " + buchSplit[1] );
                if (buchSplit[2].equals("Ausgangsrechnung")) {
                    System.out.println("Ausgangsrechnung!");
                    i++;
                } else {
                    buchEin[i] = null;
                }
            }
            scanner.close();
            br.close();
        }
        else {
            buchEin[0] = "0;0;undefiniert;Keine Buchung vorhanden!;undefiniert";
            System.out.println(buchEin[0]);
        }
        return buchEin;
    }

    public String[] lesenCsvAusgaben_ktonr_dat_text_betrag_steuer() throws FileNotFoundException, IOException {
        // Buchungsart.Eingangsrechnung

        String[] buchAus = new String[99];
        // --> muss noch Abfrage/Prüfung wieviel Zeilen rein

        if (this.pruefenVorhandenCsvBuch()){
            BufferedReader br = new BufferedReader(new FileReader(csvBuchFileName));
            Scanner scanner = new Scanner(br);
            //scanner.useDelimiter(";");
            System.out.println("Lese Einnahmen ...");
            int i = 0;
            while(scanner.hasNextLine()){
                buchAus[i] = scanner.nextLine();
                String[] buchSplit = buchAus[i].split(";");
                System.out.println("Datum: " + buchSplit[0] + " Betrag: " + buchSplit[1] );
                if (buchSplit[2].equals("Eingangsrechnung")) {
                    System.out.println("Eingangsrechnung!");
                    i++;
                } else {
                    buchAus[i] = null;
                }
            }
            scanner.close();
            br.close();
        }
        else {
            buchAus[0] = "0;0;undefiniert;Keine Buchung vorhanden!;undefiniert";
            System.out.println(buchAus[0]);
        }
        return buchAus;
    }
}
