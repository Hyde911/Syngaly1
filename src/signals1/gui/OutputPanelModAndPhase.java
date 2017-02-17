/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.gui;

import java.awt.BorderLayout;
import org.apache.commons.math3.complex.Complex;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import signals1.discreteSignals.abstracts.DiscreteSignal;

/**
 *
 * @author marr
 */
public class OutputPanelModAndPhase extends OutputPanel {

    public OutputPanelModAndPhase(DiscreteSignal signal) {
        super(signal);
        realTitle = "moduł z liczby zespolonej";
        imgTitle = "faza liczby zespolonej";

        realChart = getScatterPlot(signal.getValuesModAndShift(), true, signal.getStartTime(), signal.getSamplingRate());
        imgChart = getScatterPlot(signal.getValuesModAndShift(), false, signal.getStartTime(), signal.getSamplingRate());
        
        jPanelReal.setLayout(new java.awt.BorderLayout());
        jPanelReal.add(realChart, BorderLayout.CENTER);
        jPanelReal.setVisible(true);
        jPanelReal.validate();

        jPanelImg.setLayout(new java.awt.BorderLayout());
        jPanelImg.add(imgChart, BorderLayout.CENTER);
        jPanelImg.setVisible(true);
        jPanelImg.validate();
    }
    
}
