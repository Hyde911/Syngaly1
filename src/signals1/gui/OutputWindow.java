/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.gui;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import signals1.signals.abstracts.Signals;
import signals1.stats.SignalStats;

/**
 *
 * @author marr
 */
public class OutputWindow extends javax.swing.JFrame {

    private DecimalFormat df = new DecimalFormat("0.####");
    private FileChooserDialog fileChooserDialog;

    /**
     * Creates new form OutputWindow
     */
    public OutputWindow(Signals signal, JPanel aplitudeCharts/*, HistogramPanel hisPanel*/) {
        initComponents();
        fileChooserDialog = new FileChooserDialog(this, true, signal.getID());
        fileChooserDialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        fileChooserDialog.setVisible(false);            
                    }
                });
        
//        showStats(signal.getStats());

        jPanelAmp1.setLayout(new java.awt.BorderLayout());
        jPanelAmp1.add(aplitudeCharts, BorderLayout.CENTER);
        jPanelAmp1.revalidate();
        jPanelHist1.setLayout(new java.awt.BorderLayout());
//        jPanelHist1.add(hisPanel, BorderLayout.CENTER);
//        jPanelHist1.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextMeanValue = new javax.swing.JTextField();
        jTextMeanPower = new javax.swing.JTextField();
        jTextVariance = new javax.swing.JTextField();
        jTextEffPower = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextAbsMeanValue1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelAmp1 = new javax.swing.JPanel();
        jPanelHist1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel3.setText("moc średnia");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel4.setText("wariancja");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel5.setText("moc skuteczna");

        jTextMeanValue.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jTextMeanValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextMeanValue.setText("0");

        jTextMeanPower.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jTextMeanPower.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextMeanPower.setText("0");

        jTextVariance.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jTextVariance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextVariance.setText("0");

        jTextEffPower.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jTextEffPower.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextEffPower.setText("0");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel6.setText("bezwzględna wartość średnia");

        jTextAbsMeanValue1.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jTextAbsMeanValue1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAbsMeanValue1.setText("0");

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel1.setText("wartość średnia");

        jLabel2.setFont(new java.awt.Font("Yu Mincho", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Parametry sygnału");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanelAmp1Layout = new javax.swing.GroupLayout(jPanelAmp1);
        jPanelAmp1.setLayout(jPanelAmp1Layout);
        jPanelAmp1Layout.setHorizontalGroup(
            jPanelAmp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1174, Short.MAX_VALUE)
        );
        jPanelAmp1Layout.setVerticalGroup(
            jPanelAmp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Wykres amplitud", jPanelAmp1);

        javax.swing.GroupLayout jPanelHist1Layout = new javax.swing.GroupLayout(jPanelHist1);
        jPanelHist1.setLayout(jPanelHist1Layout);
        jPanelHist1Layout.setHorizontalGroup(
            jPanelHist1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1174, Short.MAX_VALUE)
        );
        jPanelHist1Layout.setVerticalGroup(
            jPanelHist1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Histogramy", jPanelHist1);

        jButton1.setText("Zapisz Sygnał");
        jButton1.setToolTipText("");
        jButton1.setActionCommand("saveSignal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextMeanValue, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextMeanPower, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextAbsMeanValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jTextEffPower, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jTextVariance, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMeanValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAbsMeanValue1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMeanPower))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextVariance))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextEffPower))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(505, 505, 505))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fileChooserDialog.setAction(evt.getActionCommand());
        fileChooserDialog.setVisible(true); 
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    private void showStats(SignalStats stats) {
        if (stats != null) {
            jTextMeanValue.setText(df.format(stats.getMeanValue()));
            jTextAbsMeanValue1.setText(df.format(stats.getAbsoluteMeanValue()));
            jTextEffPower.setText(df.format(stats.getEffectivePower()));
            jTextVariance.setText(df.format(stats.getVariance()));
            jTextMeanPower.setText(df.format(stats.getAveragePower()));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanelAmp1;
    private javax.swing.JPanel jPanelHist1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextAbsMeanValue1;
    private javax.swing.JTextField jTextEffPower;
    private javax.swing.JTextField jTextMeanPower;
    private javax.swing.JTextField jTextMeanValue;
    private javax.swing.JTextField jTextVariance;
    // End of variables declaration//GEN-END:variables
}
