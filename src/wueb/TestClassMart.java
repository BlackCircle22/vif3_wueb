
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Computer
 */
public class TestClassMart {
       public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        WUEB wueb = new WUEB();
        
    }
 
}


class TextFeldDemo implements ActionListener {
 
  JTextField meinTextFeld;
  JLabel meinText;
 
  TextFeldDemo() {
 
    // Erstellt einen JFrame top-level Container.
    JFrame meineEbene = new JFrame("Ein Textfeld Beispiel");
 
    // Die Anordnung der Elemente wird festgelegt
    meineEbene.getContentPane().setLayout(new FlowLayout());
 
    // Fenstergröße
    meineEbene.setSize(240, 90);
 
    // Programm beenden, wenn der User es will
    meineEbene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    // Erstellt ein Textfeld der Breite 10
    meinTextFeld = new JTextField(10);
 
    // Textfeld bei den Listenern registrieren
    meinTextFeld.addActionListener(this);
 
    // Die Komponente der content pane hinzufügen.
    meineEbene.getContentPane().add(meinTextFeld);
 
    // Erstellt einen leeren Label
    meinText = new JLabel("");
 
    // Die Komponente der content pane hinzufügen..
    meineEbene.getContentPane().add(meinText);
 
     // Das Fenster sichtbar machen
    meineEbene.setVisible(true);
  }
 
  // Was soll passieren, wenn eine Schaltflaeche gedrueckt wird?
  public void actionPerformed(ActionEvent ereignis) {
 
    // Den Text auslesen und ausgeben
    meinText.setText("Aktueller Inhalt: " + meinTextFeld.getText());
  }
 
  public static void main(String args[]) {
 
    // Das Programm starten
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new TextFeldDemo();
      }
    });
 
  }
}