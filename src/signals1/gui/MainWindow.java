/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.DecimalFormat;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import signals1.gui.inputForms.NoiseInputPanel;
import signals1.gui.inputForms.SineInputPanel;
import signals1.gui.inputForms.SquareInputPanel;
import signals1.signals.abstracts.NoiseSignals;
import signals1.signals.abstracts.PeriodicSignals;
import signals1.signals.abstracts.Signals;
import signals1.signals.discrete.DescreetSignal;
import signals1.signals.discrete.NonPeriodicDiscreteSignal;
import signals1.signals.discrete.PeriodicDiscreteSignal;
import signals1.stats.HistogramCalculator;
import signals1.tools.SignalContainer;

/**
 *
 * @author marr
 */
public class MainWindow extends javax.swing.JFrame {

    private Dimension inputFormDimension = new Dimension(400, 320);
    private SineInputPanel sineInputPanel;
    private NoiseInputPanel noiseInputPanel;
    private SquareInputPanel squareInputPanel;
    private SignalContainer signalContainer = SignalContainer.getInstance();
    private DecimalFormat df = new DecimalFormat("0.####");

    /**
     * Creates new form NewJFrame
     */
    public MainWindow() {
        
        initLookAndFeel();
        initComponents();
        initInputForms();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelNoiseSignals = new javax.swing.JPanel();
        jPanelSineSignals = new javax.swing.JPanel();
        jPanelSquareSignals = new javax.swing.JPanel();
        jPanelDiscreteSignals = new javax.swing.JPanel();
        jButtonGenerateSignal = new javax.swing.JButton();
        jSliderHistNo = new javax.swing.JSlider();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(420, 320));

        jPanelNoiseSignals.setPreferredSize(inputFormDimension);

        javax.swing.GroupLayout jPanelNoiseSignalsLayout = new javax.swing.GroupLayout(jPanelNoiseSignals);
        jPanelNoiseSignals.setLayout(jPanelNoiseSignalsLayout);
        jPanelNoiseSignalsLayout.setHorizontalGroup(
            jPanelNoiseSignalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );
        jPanelNoiseSignalsLayout.setVerticalGroup(
            jPanelNoiseSignalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Szumy", jPanelNoiseSignals);

        jPanelSineSignals.setPreferredSize(inputFormDimension);

        javax.swing.GroupLayout jPanelSineSignalsLayout = new javax.swing.GroupLayout(jPanelSineSignals);
        jPanelSineSignals.setLayout(jPanelSineSignalsLayout);
        jPanelSineSignalsLayout.setHorizontalGroup(
            jPanelSineSignalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );
        jPanelSineSignalsLayout.setVerticalGroup(
            jPanelSineSignalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sygnały sinusoidalne", jPanelSineSignals);

        jPanelSquareSignals.setPreferredSize(inputFormDimension);

        javax.swing.GroupLayout jPanelSquareSignalsLayout = new javax.swing.GroupLayout(jPanelSquareSignals);
        jPanelSquareSignals.setLayout(jPanelSquareSignalsLayout);
        jPanelSquareSignalsLayout.setHorizontalGroup(
            jPanelSquareSignalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );
        jPanelSquareSignalsLayout.setVerticalGroup(
            jPanelSquareSignalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sygnały prostokątne", jPanelSquareSignals);

        jPanelDiscreteSignals.setPreferredSize(inputFormDimension);

        javax.swing.GroupLayout jPanelDiscreteSignalsLayout = new javax.swing.GroupLayout(jPanelDiscreteSignals);
        jPanelDiscreteSignals.setLayout(jPanelDiscreteSignalsLayout);
        jPanelDiscreteSignalsLayout.setHorizontalGroup(
            jPanelDiscreteSignalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );
        jPanelDiscreteSignalsLayout.setVerticalGroup(
            jPanelDiscreteSignalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sygnały dyskretne", jPanelDiscreteSignals);

        jButtonGenerateSignal.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jButtonGenerateSignal.setText("Generuj Sygnał");
        jButtonGenerateSignal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateSignalActionPerformed(evt);
            }
        });

        jSliderHistNo.setMajorTickSpacing(5);
        jSliderHistNo.setMaximum(20);
        jSliderHistNo.setMinimum(5);
        jSliderHistNo.setMinorTickSpacing(5);
        jSliderHistNo.setPaintLabels(true);

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel7.setText("liczba przedziałów histogramu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSliderHistNo, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jButtonGenerateSignal, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jSliderHistNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonGenerateSignal, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGenerateSignalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateSignalActionPerformed
        DescreetSignal disSignal;
        Signals signal;
        switch (jTabbedPane1.getSelectedIndex()) {
            case 1:
                signal = sineInputPanel.getSingal();
                disSignal = new PeriodicDiscreteSignal((PeriodicSignals)signal, 128);
                break;
            case 2:
                signal = squareInputPanel.getSingal();
                disSignal = new PeriodicDiscreteSignal((PeriodicSignals)signal, 128);
                break;
            default:
                signal = noiseInputPanel.getSingal();
                disSignal = new NonPeriodicDiscreteSignal((NoiseSignals)signal, 128);
        }
        signalContainer.put(signal.getID(), signal);
        int intervals = jSliderHistNo.getValue();
       
        
        AmplitudePanel ampPanel = new AmplitudePanel(disSignal);
//        HistogramPanel hisPanel = new HistogramPanel(disSignal.getHistogram(intervals).getRealHistogram(), intervals, disSignal.getHistogram(intervals).getImgHistogram(), intervals);
        OutputWindow w = new OutputWindow(signal, ampPanel);
        w.setVisible(true);

    }//GEN-LAST:event_jButtonGenerateSignalActionPerformed

    private void initInputForms() {
        sineInputPanel = new SineInputPanel(inputFormDimension);
        noiseInputPanel = new NoiseInputPanel(inputFormDimension);
        squareInputPanel = new SquareInputPanel(inputFormDimension);

        jPanelSineSignals.setLayout(new java.awt.BorderLayout());
        jPanelSineSignals.add(sineInputPanel, BorderLayout.CENTER);
        jPanelNoiseSignals.setLayout(new java.awt.BorderLayout());
        jPanelNoiseSignals.add(noiseInputPanel, BorderLayout.CENTER);
        jPanelSquareSignals.setLayout(new java.awt.BorderLayout());
        jPanelSquareSignals.add(squareInputPanel, BorderLayout.CENTER);

        jPanelSineSignals.validate();
        jPanelNoiseSignals.validate();
        jPanelSquareSignals.validate();

    }

    private static void initLookAndFeel() {
        String lookAndFeel = null;
        lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException e) {
        } catch (Exception e) {
            //TODO :)
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGenerateSignal;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanelDiscreteSignals;
    private javax.swing.JPanel jPanelNoiseSignals;
    private javax.swing.JPanel jPanelSineSignals;
    private javax.swing.JPanel jPanelSquareSignals;
    private javax.swing.JSlider jSliderHistNo;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

}
