package wueb;
/*
 * Klasse WUEB enthaelt die Main und initiert die beiden CSV-Dateien.
 *
 * @author Martin Lesch 
 *
 * @version 1.0 
 *
*/ 
public class WUEB {

    private CsvBuch csvBuch ;
    private CsvKont csvKont ;

    public WUEB() {

        this.csvKont = new CsvKont();
        if (!this.csvKont.checkIfExists()){
            System.out.println("Konten müssen zwingend vorhanden sein, Programmabbruch!");
            // --> Applikation schließen ===
            System.exit(0);
        }
        this.csvBuch = new CsvBuch();
        if (!this.csvBuch.checkIfExists()) {
            this.csvBuch.createCsvBuch();
        }
    }

    public static void main(String[] args) {
        WUEB wueb = new WUEB();
        guiLOGIN gLogin = new guiLOGIN(CsvBuch wueb.csvBuch, CsvKont wueb.csvKont);
  //      gLogin.dispose();

      }
}
