/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.gui;

import java.awt.BorderLayout;
import org.jfree.chart.ChartPanel;
import org.jfree.data.Range;
import signals1.discreteSignals.abstracts.DiscreteSignal;

/**
 *
 * @author marr
 */
public class OutputPanelAmplitude extends OutputPanel {

    public OutputPanelAmplitude(DiscreteSignal signal) {
        super(signal);
        realTitle = "składowa urojona";
        imgTitle = "składowa rzeczywista";

        realChart = getScatterPlot(signal.getValues(), true, signal.getStartTime(), signal.getSamplingRate());
        imgChart = getScatterPlot(signal.getValues(), false, signal.getStartTime(), signal.getSamplingRate());

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
