package wueb;

import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class guiWUEB extends JFrame {

    /**
     * Creates new form guiWUEB
     */
    public guiWUEB() {
        initComponents();
        initTableDaten();
                
        tfAusgaben.setText("5000 Mark");
        tfEinnahmen.setText("1 Mark");
        tfUeberschuss.setText("Null Mark");
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitel = new javax.swing.JLabel();
        lblEinnahmen = new javax.swing.JLabel();
        lblAusgaben = new javax.swing.JLabel();
        lblUeberschuss = new javax.swing.JLabel();
        btmNeueBuchung = new javax.swing.JButton();
        tfEinnahmen = new javax.swing.JTextField();
        tfAusgaben = new javax.swing.JTextField();
        tfUeberschuss = new javax.swing.JTextField();
        lblTitel1 = new javax.swing.JLabel();
        regPanel = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtabEinnahmen = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtabAusgaben = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtabKonten = new javax.swing.JTable();

        lblTitel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitel.setText("Neue Buchung - WUEB");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblEinnahmen.setText("Einnahmen:");

        lblAusgaben.setText("Ausgaben:");

        lblUeberschuss.setText("Überschuss:");

        btmNeueBuchung.setText("Neue Buchung");
        btmNeueBuchung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmNeueBuchungActionPerformed(evt);
            }
        });

        tfEinnahmen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEinnahmenActionPerformed(evt);
            }
        });

        lblTitel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitel1.setText("Was über Bilanzen - WUEB");

        jtabEinnahmen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Betrag", "Datum"
            }
        ));
        jScrollPane4.setViewportView(jtabEinnahmen);

        regPanel.addTab("Einnahmen", jScrollPane4);

        jtabAusgaben.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jtabAusgaben);

        regPanel.addTab("Ausgaben", jScrollPane5);

        jtabKonten.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jtabKonten);

        regPanel.addTab("Konten", jScrollPane6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(regPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitel1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEinnahmen, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUeberschuss, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfEinnahmen)
                            .addComponent(tfUeberschuss, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblAusgaben)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfAusgaben)
                            .addComponent(btmNeueBuchung, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfAusgaben, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAusgaben))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfEinnahmen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEinnahmen)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUeberschuss)
                    .addComponent(btmNeueBuchung, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUeberschuss, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(regPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btmNeueBuchungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmNeueBuchungActionPerformed
        new guiBUCHUNG().setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btmNeueBuchungActionPerformed

    private void tfEinnahmenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEinnahmenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEinnahmenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(guiWUEB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(guiWUEB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(guiWUEB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(guiWUEB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new guiWUEB().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmNeueBuchung;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jtabAusgaben;
    private javax.swing.JTable jtabEinnahmen;
    private javax.swing.JTable jtabKonten;
    private javax.swing.JLabel lblAusgaben;
    private javax.swing.JLabel lblEinnahmen;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JLabel lblTitel1;
    private javax.swing.JLabel lblUeberschuss;
    private javax.swing.JTabbedPane regPanel;
    private javax.swing.JTextField tfAusgaben;
    private javax.swing.JTextField tfEinnahmen;
    private javax.swing.JTextField tfUeberschuss;
    // End of variables declaration//GEN-END:variables

    public void initTableDaten() {

        // Bsp. Daten für Registerkarten, muss noch mit csv.java übergeben werden
        String[][] einnahmen = {
            {"1000", "01.01.1970"},
            {"2000", "02.01.1970"},
            {"3000", "03.01.1970"},
            {"4000", "04.01.1970"},
            {"5000", "05.01.1970"},
            {"6000", "06.01.1970"},};

        String[][] ausgaben = {
            {"1100", "01.01.1975"},
            {"2100", "02.01.1975"},
            {"35500", "03.01.1975"},
            {"45600", "04.01.1975"},
            {"520", "05.01.1975"},
            {"600", "06.01.1975"},};

        String[][] konten = {
            {"0001", "Ingangsetzungs- und Erweiterungsaufwand", "Aktivkonto", "Mehrwertsteuer_19", "1050", "900", "19.09.2017"},
            {"0002", "Aufwendungen Waehrungsumstellung Euro", "Passivkonto", "Vorsteuer_19", "1050", "900", "19.09.2017"},
            {"0010", "Konzessionen und gewerbl.Schutzrechte", "Ertragskonto", "Mehrwertsteuer_7", "1050", "900", "19.09.2017"},
            {"0015", "Konzessionen", "Aufwandskonto", "Mehrwertsteuer_7", "1050", "900", "19.09.2017"},};
     
   /*     private Csv csv ;
                this.csv = new Csv("buchungen.csv", "skr03.csv");
        if (!csv.pruefenVorhandenCsvKonten()){
            System.out.println("Konten müssen zwingend vorhanden sein, Programmabbruch!");
            // --> Applikation schließen ===
            System.exit(0);
        }
        if (!csv.pruefenVorhandenCsvBuch()) {
            csv.buchungenCsvErstellen();
        }
        
        String[] konten = new String[1196];
        konten = csv.lesenCsvKonten_ktonr_bez();
        System.out.println("Test konto 1: " + konten[1]);
        String[] kontenSplit = konten[275].split(";");
        System.out.println("Kontonr: " + kontenSplit[0] + " Bezeichnung: " + kontenSplit[1] );*/
        

        jtabEinnahmen.setModel(new javax.swing.table.DefaultTableModel(
                einnahmen,
                new String[]{
                    "Betrag", "Datum"
                }
        ));
        jtabAusgaben.setModel(new javax.swing.table.DefaultTableModel(
                ausgaben,
                new String[]{
                    "Betrag", "Datum"
                }
        ));

        jtabKonten.setModel(new javax.swing.table.DefaultTableModel(
                konten,
                new String[]{
                    "Kontonummer", "Kontobezeichnung", "Kontoart", "Steuerschlüssel", "Brutto", "Netto", "Datum"
                }
        ));
        
        

    }

}
