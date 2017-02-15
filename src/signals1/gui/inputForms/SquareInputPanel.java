/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.gui.inputForms;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import signals1.continuousSignals.SquareSignal;
import signals1.continuousSignals.SymetricSquareSignal;
import signals1.continuousSignals.TriangleSignal;
import signals1.continuousSignals.abstracts.SquareSignals;

/**
 *
 * @author marr
 */
public class SquareInputPanel extends javax.swing.JPanel implements InputPanel {

    private final Dimension dimension;

    /**
     * Creates new form NewJPanel
     */
    public SquareInputPanel(Dimension dimension) {
        this.dimension = dimension;
        initComponents();
    }

    @Override
    public SquareSignals getSingal() {
        double amplitude = 0;
        double period = 0;
        double duration = 0;
        double startTime = 0;
        int fillFactor = 0;
        try {
            amplitude = Double.parseDouble(jTextAmplitude.getText());
            period = 1.0 / Double.parseDouble(jTextPeriod.getText());
            duration = Double.parseDouble(jTextDuration.getText());
            startTime = Double.parseDouble(jTextStartTime.getText());
            fillFactor = Integer.parseInt(jTextFillFactor.getText());
            if (fillFactor < 1 || fillFactor > 100) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Niepoprawna wartość", "Błąd", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        switch (jComboBox1.getSelectedIndex()) {
            case 1:
                return new SymetricSquareSignal(startTime, amplitude, duration, period, fillFactor);
            case 2:
                return new TriangleSignal(startTime, amplitude, duration, period, fillFactor);
            default:
                return new SquareSignal(startTime, amplitude, duration, period, fillFactor);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextAmplitude = new javax.swing.JTextField();
        jTextPeriod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextDuration = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextStartTime = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFillFactor = new javax.swing.JTextField();

        setPreferredSize(dimension);

        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sygnał prostokątny", "Sygnał prostokątny symetryczny", "Sygnała trójąkny" }));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("Amplituda");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Częstotliwość");

        jTextAmplitude.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextAmplitude.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAmplitude.setText("1");
        jTextAmplitude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAmplitudeActionPerformed(evt);
            }
        });

        jTextPeriod.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextPeriod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextPeriod.setText("10");
        jTextPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPeriodActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("Czas trwania[s]");

        jTextDuration.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextDuration.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextDuration.setText("1");
        jTextDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDurationActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setText("Czas początkowy");

        jTextStartTime.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextStartTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextStartTime.setText("0");
        jTextStartTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextStartTimeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setText("Stopień wypełnienia [%]");

        jTextFillFactor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFillFactor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFillFactor.setText("50");
        jTextFillFactor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFillFactorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextAmplitude, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFillFactor, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 230, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextAmplitude, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextPeriod, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFillFactor, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDuration, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextStartTime, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(107, 107, 107))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextAmplitudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAmplitudeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAmplitudeActionPerformed

    private void jTextPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPeriodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPeriodActionPerformed

    private void jTextDurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDurationActionPerformed

    private void jTextStartTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextStartTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextStartTimeActionPerformed

    private void jTextFillFactorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFillFactorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFillFactorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextAmplitude;
    private javax.swing.JTextField jTextDuration;
    private javax.swing.JTextField jTextFillFactor;
    private javax.swing.JTextField jTextPeriod;
    private javax.swing.JTextField jTextStartTime;
    // End of variables declaration//GEN-END:variables
}
