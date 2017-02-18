/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import signals.stats.Histogram;

/**
 *
 * @author marr
 */
public class HistogramPanel extends javax.swing.JPanel {

    /**
     * Creates new form HistogramPane
     */
    public HistogramPanel(Histogram histogram, int intervals) {
        initComponents();

        if (histogram.getImgHistogram().length == 1) {
            return;
        }
        JFreeChart realHistogram = buildHistogram("składowa rzeczywista", "", "", histogram.getRealHistogram(), intervals, HistogramType.FREQUENCY);
        ChartPanel realChartPanel = new ChartPanel(realHistogram);
        realChartPanel.setPreferredSize(new Dimension(570, 680));
        jPanelHisReal.setLayout(new java.awt.BorderLayout());
        jPanelHisReal.add(realChartPanel, BorderLayout.CENTER);
        jPanelHisReal.setVisible(true);
        jPanelHisReal.validate();

        JFreeChart imgHistogram = buildHistogram("składowa urojona", "", "", histogram.getImgHistogram(), intervals, HistogramType.FREQUENCY);
        ChartPanel imgChartPanel = new ChartPanel(imgHistogram);
        imgChartPanel.setPreferredSize(new Dimension(570, 680));
        jPanelHisImg.setLayout(new java.awt.BorderLayout());
        jPanelHisImg.add(imgChartPanel, BorderLayout.CENTER);
        jPanelHisImg.setVisible(true);
        jPanelHisImg.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHisImg = new javax.swing.JPanel();
        jPanelHisReal = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanelHisImgLayout = new javax.swing.GroupLayout(jPanelHisImg);
        jPanelHisImg.setLayout(jPanelHisImgLayout);
        jPanelHisImgLayout.setHorizontalGroup(
            jPanelHisImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        jPanelHisImgLayout.setVerticalGroup(
            jPanelHisImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 682, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelHisRealLayout = new javax.swing.GroupLayout(jPanelHisReal);
        jPanelHisReal.setLayout(jPanelHisRealLayout);
        jPanelHisRealLayout.setHorizontalGroup(
            jPanelHisRealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );
        jPanelHisRealLayout.setVerticalGroup(
            jPanelHisRealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 682, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelHisReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanelHisImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelHisReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelHisImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
        private JFreeChart buildHistogram(final String title, final String xAxisLabel, final String yAxisLabel, final double[] numbers, final int div, final HistogramType type) {
        HistogramDataset dataset = new HistogramDataset();
        dataset.setType(type);
        dataset.addSeries(xAxisLabel, numbers, div);
        JFreeChart histogram = ChartFactory.createHistogram(
                title,
                xAxisLabel,
                yAxisLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        return histogram;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelHisImg;
    private javax.swing.JPanel jPanelHisReal;
    // End of variables declaration//GEN-END:variables
}