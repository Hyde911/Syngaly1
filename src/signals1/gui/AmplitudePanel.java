/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import org.apache.commons.math3.complex.Complex;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import signals1.signals.discrete.ImpulseInterface;
import signals1.signals.discrete.DiscreteSignal;

/**
 *
 * @author marr
 */
public class AmplitudePanel extends javax.swing.JPanel {
    private static final String SKŁADOWA_UROJONA = "składowa urojona";
    private static final String SKŁADOWA_RZECZYWISTA = "składowa rzeczywista";
    private static final String AMPLITUDA = "amplituda";
    private static final String CZAS = "czas";
    private static final int INTERVAL = 10;
    private int chartDimensionX = 1150;
    private int chartDimensionY = 350;

    /**
     * Creates new form AmplitudePanel
     */
    public AmplitudePanel(DiscreteSignal signal) {
        initComponents();
        ChartPanel realChart;
        ChartPanel imgChart;
        
        if(signal instanceof ImpulseInterface){       
            realChart = getScatterPlot(signal.getValues(), true, signal.getStartTime());
            imgChart = getScatterPlot(signal.getValues(), false, signal.getStartTime());
        }else{
            realChart = getChart(signal.getValues(), true, signal.getStartTime());
            imgChart = getChart(signal.getValues(), false, signal.getStartTime());
        }
        
        jPanelReal.setLayout(new java.awt.BorderLayout());
        jPanelReal.add(realChart, BorderLayout.CENTER);
        jPanelReal.setVisible(true);
        jPanelReal.validate();

        jPanelImg.setLayout(new java.awt.BorderLayout());
        jPanelImg.add(imgChart, BorderLayout.CENTER);
        jPanelImg.setVisible(true);
        jPanelImg.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelReal = new javax.swing.JPanel();
        jPanelImg = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1200, 810));

        jPanelReal.setPreferredSize(new java.awt.Dimension(1150, 400));

        javax.swing.GroupLayout jPanelRealLayout = new javax.swing.GroupLayout(jPanelReal);
        jPanelReal.setLayout(jPanelRealLayout);
        jPanelRealLayout.setHorizontalGroup(
            jPanelRealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        jPanelRealLayout.setVerticalGroup(
            jPanelRealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        jPanelImg.setPreferredSize(new java.awt.Dimension(1150, 400));

        javax.swing.GroupLayout jPanelImgLayout = new javax.swing.GroupLayout(jPanelImg);
        jPanelImg.setLayout(jPanelImgLayout);
        jPanelImgLayout.setHorizontalGroup(
            jPanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        jPanelImgLayout.setVerticalGroup(
            jPanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanelReal, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelImg, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private ChartPanel getScatterPlot(Complex[] values, boolean isReal, double startTime){
        String title = SKŁADOWA_RZECZYWISTA;
        if (!isReal) {
            title = SKŁADOWA_UROJONA;
        }
        XYSeries series = new XYSeries(title);
        int i = (int) startTime;
        double x;
        double y;
        for (Complex v : values) {
            if (isReal) {
                y = v.getReal();
            } else {
                y = v.getImaginary();
            }
            x = i;
            series.add(x,y);
            i++;
        }
        JFreeChart chart = ChartFactory.createScatterPlot(title, CZAS, AMPLITUDA, new XYSeriesCollection(series));
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(chartDimensionX, chartDimensionY));
        return chartPanel;
    }
    
    private ChartPanel getChart(Complex[] values, boolean isReal, double offset) {
       String title = SKŁADOWA_RZECZYWISTA;
        if (!isReal) {
            title = SKŁADOWA_UROJONA;
        }
        JFreeChart chart = ChartFactory.createXYLineChart(title, CZAS, AMPLITUDA,
                createDataset(values, isReal, offset, title));
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(chartDimensionX, chartDimensionY));
        return chartPanel;
    }

    private XYSeriesCollection createDataset(Complex[] values, boolean isReal, double offset, String title) {
        XYSeries series = new XYSeries(title);
        int i =0;
        double x;
        double y;
        for (Complex v : values) {
            if (isReal) {
                y = v.getReal();
            } else {
                y = v.getImaginary();
            }
            x = i+offset;
            series.add(x,y);
            i++;
        }
        return new XYSeriesCollection(series);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelImg;
    private javax.swing.JPanel jPanelReal;
    private javax.swing.JPanel jPanelReal1;
    // End of variables declaration//GEN-END:variables
}
