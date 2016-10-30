/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import signals1.gui.inputForms.DiscreetSignalsPanel;
import signals1.gui.inputForms.NoiseInputPanel;
import signals1.gui.inputForms.SineInputPanel;
import signals1.gui.inputForms.SquareInputPanel;
import signals1.gui.tables.DiscreteSignalTableModel;
import signals1.gui.tables.VirtualSignalsTableModel;
import signals1.operations.AmplitudeCalculator;
import signals1.signals.abstracts.NoiseSignals;
import signals1.signals.abstracts.PeriodicSignals;
import signals1.signals.abstracts.Signals;
import signals1.signals.discrete.DiscreteSignal;
import signals1.signals.discrete.NonPeriodicDiscreteSignal;
import signals1.signals.discrete.PeriodicDiscreteSignal;
import signals1.tools.DiscretetSignalsContainer;
import signals1.tools.SignalContainer;
import signals1.tools.exceptions.DivideByZeroValueExcpetion;
import signals1.tools.exceptions.NotSameSamplinRateExpcetion;

/**
 *
 * @author marr
 */
public class MainWindow extends javax.swing.JFrame {

    private Dimension inputFormDimension = new Dimension(400, 320);
    private SineInputPanel sineInputPanel;
    private NoiseInputPanel noiseInputPanel;
    private SquareInputPanel squareInputPanel;
    private DiscreetSignalsPanel discreetPanel;
    private SignalContainer signalContainer = SignalContainer.getInstance();
    private DiscretetSignalsContainer disSignalContainer = DiscretetSignalsContainer.getInstance();
    private VirtualSignalsTableModel virtulTableModel = new VirtualSignalsTableModel();
    private DiscreteSignalTableModel discreteTableModel = new DiscreteSignalTableModel();

    /**
     * Creates new form NewJFrame
     */
    public MainWindow() {

        initLookAndFeel();
        initComponents();
        initInputForms();
        setUpVirtualTable();
        setUpDiscreteTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPaneTabs = new javax.swing.JTabbedPane();
        jPanelNoiseSignals = new javax.swing.JPanel();
        jPanelSineSignals = new javax.swing.JPanel();
        jPanelSquareSignals = new javax.swing.JPanel();
        jPanelDiscreteSignals = new javax.swing.JPanel();
        jButtonGenerateSignal = new javax.swing.JButton();
        jSliderHistNo = new javax.swing.JSlider();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVirtual = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jTextSamplingRate = new javax.swing.JTextField();
        jButtonSampling = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDiscrete = new javax.swing.JTable();
        jButtonShowSignal = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonAddSignals = new javax.swing.JButton();
        jButtonSubtractSignals = new javax.swing.JButton();
        jButtonMultiplySignals = new javax.swing.JButton();
        jButtonDvideSignals = new javax.swing.JButton();
        jButtonClearVirtualTable = new javax.swing.JButton();
        jButtonClearDiscreteTable1 = new javax.swing.JButton();
        jCheckBoxOperationOrder = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPaneTabs.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPaneTabs.setPreferredSize(new java.awt.Dimension(420, 320));

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

        jPaneTabs.addTab("Szumy", jPanelNoiseSignals);

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

        jPaneTabs.addTab("Sygnały sinusoidalne", jPanelSineSignals);

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

        jPaneTabs.addTab("Sygnały prostokątne", jPanelSquareSignals);

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

        jPaneTabs.addTab("Sygnały dyskretne", jPanelDiscreteSignals);

        jButtonGenerateSignal.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jButtonGenerateSignal.setText("Generuj Sygnał Pseudociągły");
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
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("liczba przedziałów histogramu");

        jTableVirtual.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTableVirtual.setModel(virtulTableModel);
        jTableVirtual.setDragEnabled(true);
        jTableVirtual.setRowHeight(18);
        jTableVirtual.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableVirtual);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel1.setText("Wygenerowane sygnały pseudociągłe");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setText("Częstotliwośc próbkowania");

        jTextSamplingRate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextSamplingRate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextSamplingRate.setText("300");

        jButtonSampling.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jButtonSampling.setText("Próbkuj sygnał");
        jButtonSampling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSamplingActionPerformed(evt);
            }
        });

        jTableDiscrete.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTableDiscrete.setModel(discreteTableModel);
        jTableDiscrete.setRowHeight(18);
        jTableDiscrete.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(jTableDiscrete);

        jButtonShowSignal.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jButtonShowSignal.setText("Wyświetl sygnał");
        jButtonShowSignal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowSignalActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Próbkowanie Sygnałów");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Operacje na sygnałach");

        jButtonAddSignals.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jButtonAddSignals.setText("+");
        jButtonAddSignals.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonAddSignals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddSignalsActionPerformed(evt);
            }
        });

        jButtonSubtractSignals.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jButtonSubtractSignals.setText("-");
        jButtonSubtractSignals.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonSubtractSignals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubtractSignalsActionPerformed(evt);
            }
        });

        jButtonMultiplySignals.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jButtonMultiplySignals.setText("\u00D7");
        jButtonMultiplySignals.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonMultiplySignals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMultiplySignalsActionPerformed(evt);
            }
        });

        jButtonDvideSignals.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jButtonDvideSignals.setText("\u00F7");
        jButtonDvideSignals.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonDvideSignals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDvideSignalsActionPerformed(evt);
            }
        });

        jButtonClearVirtualTable.setText("Wyczyść");
        jButtonClearVirtualTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearVirtualTableActionPerformed(evt);
            }
        });

        jButtonClearDiscreteTable1.setText("Wyczyść");
        jButtonClearDiscreteTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearDiscreteTable1ActionPerformed(evt);
            }
        });

        jCheckBoxOperationOrder.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxOperationOrder.setText("Odwróć kolejność");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPaneTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(177, 177, 177)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonClearVirtualTable, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jButtonGenerateSignal, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextSamplingRate, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(22, 22, 22)
                                    .addComponent(jButtonSampling, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jButtonShowSignal, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButtonClearDiscreteTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSliderHistNo, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxOperationOrder)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButtonAddSignals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonSubtractSignals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonMultiplySignals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonDvideSignals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPaneTabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGenerateSignal, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jButtonClearVirtualTable)))
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSampling, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextSamplingRate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jSliderHistNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonShowSignal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonClearDiscreteTable1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAddSignals, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSubtractSignals, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonMultiplySignals, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDvideSignals, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxOperationOrder)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGenerateSignalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateSignalActionPerformed
        Signals signal = null;
        switch (jPaneTabs.getSelectedIndex()) {
            case 1:
                signal = sineInputPanel.getSingal();
                break;
            case 2:
                signal = squareInputPanel.getSingal();
                break;
            case 3:
                DiscreteSignal sig = discreetPanel.getSingal();
                disSignalContainer.add(sig);
                discreteTableModel.fireTableDataChanged();
                break;
            default:
                signal = noiseInputPanel.getSingal();
        }
        if (signal != null) {
            signalContainer.add(signal);
            virtulTableModel.fireTableDataChanged();
        }
    }//GEN-LAST:event_jButtonGenerateSignalActionPerformed

    private void jButtonSamplingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSamplingActionPerformed
        int selectedVirtualSignal = jTableVirtual.getSelectedRow();
        if (selectedVirtualSignal < 0) {
            return;
        }
        int sampling = Integer.parseInt(jTextSamplingRate.getText());
        Signals virtualSignal = signalContainer.getById(getIdFromVirtualTable(selectedVirtualSignal));
        if (virtualSignal == null) {
            return;
        }
        if (virtualSignal instanceof PeriodicSignals) {
            disSignalContainer.add(new PeriodicDiscreteSignal((PeriodicSignals) virtualSignal, sampling));
        } else if (virtualSignal instanceof NoiseSignals) {
            disSignalContainer.add(new NonPeriodicDiscreteSignal((NoiseSignals) virtualSignal, sampling));
        }
        discreteTableModel.fireTableDataChanged();
    }//GEN-LAST:event_jButtonSamplingActionPerformed

    private void jButtonShowSignalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowSignalActionPerformed
        int selectedDiscreteSignal = jTableDiscrete.getSelectedRow();
        if (selectedDiscreteSignal < 0) {
            return;
        }

        DiscreteSignal signal = disSignalContainer.getById(getIdFromDiscreteTable(selectedDiscreteSignal));
        if (signal == null) {
            return;
        }
        
        AmplitudePanel amPanel = new AmplitudePanel(signal, false);
        AmplitudePanel modAndShiftPanel = new AmplitudePanel(signal, true);
        HistogramPanel hisPanel = new HistogramPanel(signal.getHistogram(jSliderHistNo.getValue()), jSliderHistNo.getValue());
        HistogramPanel hisModAndShiftPanel = new HistogramPanel(signal.getHistogramModAndShift(jSliderHistNo.getValue()), jSliderHistNo.getValue());
        OutputWindow outputWindow = new OutputWindow(signal, amPanel, hisPanel, modAndShiftPanel, hisModAndShiftPanel);
        outputWindow.setVisible(true);
    }//GEN-LAST:event_jButtonShowSignalActionPerformed

    private void jButtonAddSignalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddSignalsActionPerformed
        DiscreteSignal[] signals = getSignalsForCalculation();
        if (signals != null) {
            try {
                disSignalContainer.add(AmplitudeCalculator.addSignals(signals[0], signals[1]));
                discreteTableModel.fireTableDataChanged();
            } catch (NotSameSamplinRateExpcetion ex) {
                JOptionPane.showMessageDialog(this, "Wybierz sygnały o takiej samej częstotliwości próbkowania", "Błąd", JOptionPane.ERROR_MESSAGE);
            } finally {
                discreteTableModel.fireTableDataChanged();
            }
        }

    }//GEN-LAST:event_jButtonAddSignalsActionPerformed

    private void jButtonSubtractSignalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubtractSignalsActionPerformed
        DiscreteSignal[] signals = getSignalsForCalculation();
        if (signals != null) {
            try {
                disSignalContainer.add(AmplitudeCalculator.subSignals(signals[0], signals[1]));
                discreteTableModel.fireTableDataChanged();
            } catch (NotSameSamplinRateExpcetion ex) {
                JOptionPane.showMessageDialog(this, "Wybierz sygnały o takiej samej częstotliwości próbkowania", "Błąd", JOptionPane.ERROR_MESSAGE);
            } finally {
                discreteTableModel.fireTableDataChanged();
            }
        }
    }//GEN-LAST:event_jButtonSubtractSignalsActionPerformed

    private void jButtonMultiplySignalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMultiplySignalsActionPerformed
        DiscreteSignal[] signals = getSignalsForCalculation();
        if (signals != null) {
            try {
                disSignalContainer.add(AmplitudeCalculator.multiplySignals(signals[0], signals[1]));
                discreteTableModel.fireTableDataChanged();
            } catch (NotSameSamplinRateExpcetion ex) {
                JOptionPane.showMessageDialog(this, "Wybierz sygnały o takiej samej częstotliwości próbkowania", "Błąd", JOptionPane.ERROR_MESSAGE);
            } finally {
                discreteTableModel.fireTableDataChanged();
            }
        }
    }//GEN-LAST:event_jButtonMultiplySignalsActionPerformed

    private void jButtonDvideSignalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDvideSignalsActionPerformed
        DiscreteSignal[] signals = getSignalsForCalculation();
        if (signals != null) {
            try {
                disSignalContainer.add(AmplitudeCalculator.divideSignals(signals[0], signals[1]));
                discreteTableModel.fireTableDataChanged();
            } catch (NotSameSamplinRateExpcetion ex) {
                JOptionPane.showMessageDialog(this, "Wybierz sygnały o takiej samej częstotliwości próbkowania", "Błąd", JOptionPane.ERROR_MESSAGE);
            } catch (DivideByZeroValueExcpetion ex) {
                JOptionPane.showMessageDialog(this, "Sygnał w dzielniku posiada próbkę o wartości 0", "Błąd", JOptionPane.ERROR_MESSAGE);
            } finally {
                discreteTableModel.fireTableDataChanged();
            }
        }
    }//GEN-LAST:event_jButtonDvideSignalsActionPerformed

    private void jButtonClearVirtualTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearVirtualTableActionPerformed
        signalContainer.clear();
        virtulTableModel.fireTableDataChanged();
    }//GEN-LAST:event_jButtonClearVirtualTableActionPerformed

    private void jButtonClearDiscreteTable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearDiscreteTable1ActionPerformed
        disSignalContainer.clear();
        discreteTableModel.fireTableDataChanged();
    }//GEN-LAST:event_jButtonClearDiscreteTable1ActionPerformed

    private void initInputForms() {
        sineInputPanel = new SineInputPanel(inputFormDimension);
        noiseInputPanel = new NoiseInputPanel(inputFormDimension);
        squareInputPanel = new SquareInputPanel(inputFormDimension);
        discreetPanel = new DiscreetSignalsPanel(inputFormDimension);

        jPanelSineSignals.setLayout(new java.awt.BorderLayout());
        jPanelSineSignals.add(sineInputPanel, BorderLayout.CENTER);
        jPanelNoiseSignals.setLayout(new java.awt.BorderLayout());
        jPanelNoiseSignals.add(noiseInputPanel, BorderLayout.CENTER);
        jPanelSquareSignals.setLayout(new java.awt.BorderLayout());
        jPanelSquareSignals.add(squareInputPanel, BorderLayout.CENTER);
        jPanelDiscreteSignals.setLayout(new java.awt.BorderLayout());
        jPanelDiscreteSignals.add(discreetPanel, BorderLayout.CENTER);

        jPanelSineSignals.validate();
        jPanelNoiseSignals.validate();
        jPanelSquareSignals.validate();
        jPanelDiscreteSignals.validate();
    }

    private void setUpVirtualTable() {
        jTableVirtual.getColumnModel().getColumn(0).setPreferredWidth(25);
        jTableVirtual.getColumnModel().getColumn(1).setPreferredWidth(175);
        jTableVirtual.getColumnModel().getColumn(2).setPreferredWidth(115);
        jTableVirtual.getColumnModel().getColumn(3).setPreferredWidth(90);
        jTableVirtual.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTableVirtual.getColumnModel().getColumn(5).setPreferredWidth(60);
        jTableVirtual.getColumnModel().getColumn(5).setPreferredWidth(95);
    }

    private void setUpDiscreteTable() {
        jTableDiscrete.getColumnModel().getColumn(0).setPreferredWidth(25);
        jTableDiscrete.getColumnModel().getColumn(1).setPreferredWidth(175);
        jTableDiscrete.getColumnModel().getColumn(2).setPreferredWidth(115);
        jTableDiscrete.getColumnModel().getColumn(3).setPreferredWidth(90);
        jTableDiscrete.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTableDiscrete.getColumnModel().getColumn(5).setPreferredWidth(60);
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

    private int getIdFromDiscreteTable(int row) {
        return (int) jTableDiscrete.getModel().getValueAt(row, 0);
    }

    private int getIdFromVirtualTable(int row) {
        return (int) jTableVirtual.getModel().getValueAt(row, 0);
    }

    private DiscreteSignal[] getSignalsForCalculation() {
        if (jTableDiscrete.getSelectedRowCount() != 2) {
            return null;
        }
        DiscreteSignal[] signals = new DiscreteSignal[2];
        if (jCheckBoxOperationOrder.isSelected()) {
            signals[0] = disSignalContainer.getById(getIdFromDiscreteTable(jTableDiscrete.getSelectedRows()[0]));
            signals[1] = disSignalContainer.getById(getIdFromDiscreteTable(jTableDiscrete.getSelectedRows()[1]));
        } else {
            signals[1] = disSignalContainer.getById(getIdFromDiscreteTable(jTableDiscrete.getSelectedRows()[0]));
            signals[0] = disSignalContainer.getById(getIdFromDiscreteTable(jTableDiscrete.getSelectedRows()[1]));

        }
        return signals;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddSignals;
    private javax.swing.JButton jButtonClearDiscreteTable1;
    private javax.swing.JButton jButtonClearVirtualTable;
    private javax.swing.JButton jButtonDvideSignals;
    private javax.swing.JButton jButtonGenerateSignal;
    private javax.swing.JButton jButtonMultiplySignals;
    private javax.swing.JButton jButtonSampling;
    private javax.swing.JButton jButtonShowSignal;
    private javax.swing.JButton jButtonSubtractSignals;
    private javax.swing.JCheckBox jCheckBoxOperationOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTabbedPane jPaneTabs;
    private javax.swing.JPanel jPanelDiscreteSignals;
    private javax.swing.JPanel jPanelNoiseSignals;
    private javax.swing.JPanel jPanelSineSignals;
    private javax.swing.JPanel jPanelSquareSignals;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSlider jSliderHistNo;
    private javax.swing.JTable jTableDiscrete;
    private javax.swing.JTable jTableVirtual;
    private javax.swing.JTextField jTextSamplingRate;
    // End of variables declaration//GEN-END:variables

}
