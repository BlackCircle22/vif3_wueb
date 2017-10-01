package wueb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/*
 * Klasse zum Handling der Datei skr03.csv
 *
 * @author Martin Lesch 
 *
 * @version 1.0 
 *
*/ 
public class CsvKont {

    private final String csvKontFileName;
    private final File csvKontFile;
    String path = null;
    
    public CsvKont()  {
        try {
            this.path = new File(".").getCanonicalPath();
        } catch (IOException ex) {
               System.out.println("Fehler 001 - Aktuelles Verzeichnis nicht verfuegbar! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
               System.exit(1);
        } 
//!!!!!! Anpassung des Pfades hinsichtlich des namens des Package
// --------->>>>>>>>>>>>>> testcsv durch den Namen des PACKAGE ersetzen (eg. wueb) <<<<<<<<<<<<<<<<--------------------!!!!!!!!!!!!!!!!
        this.path = this.path + "\\src" + "\\wueb\\";
        
//      System.out.println(path);
        this.csvKontFileName = "skr03.csv";
        csvKontFile = new File(path + csvKontFileName);
    }

    /*
    * @return false wenn skr03.csv nicht existiert
    */
    public boolean checkIfExists() {
//      System.out.println("Lese Konten - Pruefung ob vorhanden ...1");
        if (!this.csvKontFile.exists() && !this.csvKontFile.isDirectory()) {
            System.out.println("Datei Konten nicht vorhanden!");
            return false;
        }
        else {
//            System.out.println("Datei Konten existiert!");
            return true;
        }
    }
    /*
    * @return die Anzahl der Zeilen in skr03.csv (inkl. Ueberschrift!)
    */
    private int countLinesInKont() {
//      System.out.println("Anzahl der Datensaetze in Konten zaehlen ...2");
    
        int counter = 0;
        if (this.checkIfExists()){
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(this.path  + csvKontFileName));
            } catch (FileNotFoundException ex) {
                System.out.println("Fehler 002 - Datei nicht gefunden! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
            }
            Scanner scanner = new Scanner(br);
            while(scanner.hasNextLine()){
                scanner.nextLine();
                counter = counter + 1;
//                System.out.println("..." +  counter);
           } 
            scanner.close();
            try {
                br.close();
            } catch (IOException ex) {
                System.out.println("Fehler 003 - Datei nicht gefunden! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
            }
        } else {
            counter = 0;
        }
//        System.out.println("Anzahl Zeilen: " + counter);
        return counter;
    }
    /*
    * @return 2-dimensionales String-Array mit allen Konten in skr03.csv (Konto-Nummer, Bezeichnung, Art)
    */
    public String[][] getAllKont()  {
      System.out.println("Lese Alle Konten in 2-dimensionales String Array");
        int lines = countLinesInKont();
        String[][] kont = new String[lines][3];

        if (this.checkIfExists()){
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(this.path + csvKontFileName));
            } catch (FileNotFoundException ex) {
                System.out.println("Fehler 004 - Datei nicht gefunden! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
            } 
            Scanner scanner = new Scanner(br);
            System.out.println("Lese Konten .....");
            int i = 0;
            
            while(scanner.hasNextLine()){
                String[] kontLineSplit = scanner.nextLine().split(";");
                for (int row=0;row<3;row++){
                    kont[i][row] = kontLineSplit[row];
                }
 //             System.out.println("Kontonr: " + kont[i][0] + " Bezeichnung: " + kont[i][1] );
                i++;
            }
            scanner.close();
            try {
                br.close();
            } catch (IOException ex) {
                System.out.println("Fehler 005 - Datei nicht gefunden! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
            }
        }
        else {
            kont[0][0] = "0000";
            kont[0][1] = "Keine Konten vorhanden!";
            kont[0][2] = "undefiniert";
            System.out.println(kont[0][1]);
        }
        return kont;
    }
    /* zum Testen *****************************************************
     public static void main(String[] args)  {
        // TODO code application logic here
        CsvKont csvKont = new CsvKont();
        String[][] csvKontMain = csvKont.getAllKont();
        System.out.println("Kontonr: " + csvKontMain[223][0] + " Bezeichnung: " + csvKontMain[223][1] );

     } 
     */
}