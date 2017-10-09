package wueb;
/*
 * Klasse WUEB enthaelt die Main und initiert die beiden CSV-Dateien.
 *
 * @author Martin Lesch 
 *
 * @version 1.0 
 *
*/ 
public class Wueb {

    private CsvBuch csvBuch ;
    private CsvKont csvKont ;

    public Wueb() {

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
        Wueb wueb = new Wueb();
        guiLOGIN glog = new guiLOGIN(wueb.csvBuch, wueb.csvKont);
        glog.setVisible(true);
  //      gLogin.dispose();

      }
}
