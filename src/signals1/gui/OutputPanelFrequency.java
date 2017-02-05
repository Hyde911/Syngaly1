/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.gui;

import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.math3.complex.Complex;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import signals1.discreteSignals.abstracts.DiscreteSignal;
import signals1.tools.exceptions.NotPowerOfTwoException;

/**
 *
 * @author marr
 */
public class OutputPanelFrequency extends OutputPanel {

    public OutputPanelFrequency(DiscreteSignal signal) {
        super(signal);
        realTitle = "wykres częstotliwości";
        imgTitle = "wykres przesunięć w fazie";

        ChartPanel realChart;
        ChartPanel imgChart;

        try {
            realChart = getScatterPlot(signal.getFourierTransformate(), false, signal.getStartTime(), signal.getSamplingRate());
            imgChart = getScatterPlot(signal.getFourierTransformate(), true, signal.getStartTime(), signal.getSamplingRate());
        } catch (NotPowerOfTwoException ex) {
            return;
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

    @Override
    protected final XYSeriesCollection createDataset(Complex[] values, boolean isReal, double startTime, String title, int samplingRate) {
        XYSeries series = new XYSeries(title);
        int i = 0;
        double x;
        double y;
        for (Complex v : values) {
            if (isReal) {
                y = v.getReal();
            } else {
                y = v.getImaginary();
            }
            x = i + (startTime * samplingRate);
            series.add(x, y);
            i++;
        }
        return new XYSeriesCollection(series);
    }
}
