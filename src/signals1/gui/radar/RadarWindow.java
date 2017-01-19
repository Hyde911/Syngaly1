/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.gui.radar;

import java.awt.BorderLayout;
import signals1.radar.RadarSimulator;
import signals1.tools.RadarParameters;
import signals1.radar.RadarResponse;
import signals1.radar.RadarResponseAnalysis;

/**
 *
 * @author marr
 */
public class RadarWindow extends javax.swing.JFrame {

    private RadarSimulator radarSimulator;
    private RadarResponse response;
    private RadarParameters parameters;
    private RadarResponseAnalysis analysis;

    /**
     * Creates new form RadarWindow
     *
     * @param parameters
     */
    public RadarWindow(RadarParameters parameters) {
        this.parameters = parameters;
        this.radarSimulator = new RadarSimulator(parameters);
        this.response = radarSimulator.generateResponse(parameters.getInitialDistance(), parameters.getVelocity());
        this.analysis = radarSimulator.ProcessRadarResponse(response);
        initComponents();
        addCharts();
    }

    private void addCharts() {
        RadarChartsPanel chartsPanel = new RadarChartsPanel(response, analysis);
        jPanelCharts.setLayout(new java.awt.BorderLayout());
        jPanelCharts.add(chartsPanel, BorderLayout.CENTER);
        jPanelCharts.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCharts = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(500, 0));
        setResizable(false);

        jPanelCharts.setPreferredSize(new java.awt.Dimension(1000, 800));

        javax.swing.GroupLayout jPanelChartsLayout = new javax.swing.GroupLayout(jPanelCharts);
        jPanelCharts.setLayout(jPanelChartsLayout);
        jPanelChartsLayout.setHorizontalGroup(
            jPanelChartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanelChartsLayout.setVerticalGroup(
            jPanelChartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(278, Short.MAX_VALUE)
                .addComponent(jPanelCharts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCharts, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelCharts;
    // End of variables declaration//GEN-END:variables
}
