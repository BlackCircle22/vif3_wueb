/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wueb;

/**
 *
 * @author aschoenf
 */
public class guiBUCHUNG extends javax.swing.JFrame {

    /** Creates new form guiBUCHUNG */
    public guiBUCHUNG() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        lblTitel = new javax.swing.JLabel();
        lblBuchungsart = new javax.swing.JLabel();
        lblSteuerschluessel = new javax.swing.JLabel();
        lblKonto = new javax.swing.JLabel();
        lblBruttobetrag = new javax.swing.JLabel();
        lblUmsatzsteuer = new javax.swing.JLabel();
        lblNettobetrag = new javax.swing.JLabel();
        lblDatum = new javax.swing.JLabel();
        btnAbbrechen = new javax.swing.JButton();
        btnSpeichern = new javax.swing.JButton();
        dropBuchungsart = new javax.swing.JComboBox();
        dropSteuerschluessel = new javax.swing.JComboBox();
        dropKonto = new javax.swing.JComboBox();
        tfBruttobetrag = new javax.swing.JTextField();
        tfUmsatzsteuer = new javax.swing.JTextField();
        tfNettobetrag = new javax.swing.JTextField();
        tfDatum = new javax.swing.JTextField();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitel.setText("Neue Buchung - WUEB");

        lblBuchungsart.setText("Buchungsart:");

        lblSteuerschluessel.setText("Steuerschluessel:");

        lblKonto.setText("Konto:");

        lblBruttobetrag.setText("Bruttobetrag:");

        lblUmsatzsteuer.setText("Umsatzsteuer:");

        lblNettobetrag.setText("Nettobetrag:");

        lblDatum.setText("Datum:");

        btnAbbrechen.setText("Abbrechen");
        btnAbbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbbrechenActionPerformed(evt);
            }
        });

        btnSpeichern.setText("Speichern");

        dropBuchungsart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dropSteuerschluessel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dropKonto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(lblTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btnAbbrechen)
                        .addGap(18, 18, 18)
                        .addComponent(btnSpeichern))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBuchungsart)
                                .addGap(30, 30, 30)
                                .addComponent(dropBuchungsart, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSteuerschluessel)
                                    .addComponent(lblKonto)
                                    .addComponent(lblDatum))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dropSteuerschluessel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dropKonto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfDatum))))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUmsatzsteuer)
                            .addComponent(lblNettobetrag)
                            .addComponent(lblBruttobetrag))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfBruttobetrag, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfNettobetrag, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                .addComponent(tfUmsatzsteuer)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuchungsart)
                    .addComponent(lblBruttobetrag)
                    .addComponent(dropBuchungsart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBruttobetrag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSteuerschluessel)
                    .addComponent(lblUmsatzsteuer)
                    .addComponent(dropSteuerschluessel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUmsatzsteuer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKonto)
                    .addComponent(lblNettobetrag)
                    .addComponent(dropKonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNettobetrag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDatum)
                    .addComponent(tfDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbbrechen)
                    .addComponent(btnSpeichern))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbbrechenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAbbrechenActionPerformed

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
            java.util.logging.Logger.getLogger(guiBUCHUNG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(guiBUCHUNG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(guiBUCHUNG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(guiBUCHUNG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new guiBUCHUNG().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbbrechen;
    private javax.swing.JButton btnSpeichern;
    private javax.swing.JComboBox dropBuchungsart;
    private javax.swing.JComboBox dropKonto;
    private javax.swing.JComboBox dropSteuerschluessel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JLabel lblBruttobetrag;
    private javax.swing.JLabel lblBuchungsart;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblKonto;
    private javax.swing.JLabel lblNettobetrag;
    private javax.swing.JLabel lblSteuerschluessel;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JLabel lblUmsatzsteuer;
    private javax.swing.JTextField tfBruttobetrag;
    private javax.swing.JTextField tfDatum;
    private javax.swing.JTextField tfNettobetrag;
    private javax.swing.JTextField tfUmsatzsteuer;
    // End of variables declaration//GEN-END:variables

}
