/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.gui;

import java.awt.BorderLayout;
import org.apache.commons.math3.complex.Complex;
import org.jfree.chart.ChartPanel;
import org.jfree.data.Range;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import signals1.discreteSignals.abstracts.DiscreteSignal;
import signals1.tools.exceptions.NotPowerOfTwoException;

/**
 *
 * @author marr
 */
public class OutputPanelFrequency extends OutputPanel {

    private Range originalRange;

    public Range getOriginalRange() {
        return originalRange;
    }

    public OutputPanelFrequency(DiscreteSignal signal) {
        super(signal);
        realTitle = "wykres częstotliwości";
        imgTitle = "wykres przesunięć w fazie";

        try {
            realChart = getScatterPlot(signal.getFourierTransformate(), true, 0, signal.getSamplingRate());
            imgChart = getScatterPlot(signal.getFourierTransformate(), false, 0, signal.getSamplingRate());
        } catch (NotPowerOfTwoException ex) {
            return;
        }
        Range range = realChart.getChart().getXYPlot().getRangeAxis().getRange();
        double highBound = range.getUpperBound();
        realChart.getChart().getXYPlot().getRangeAxis().setRange(-0.05 * highBound, highBound);
        jPanelReal.setLayout(new java.awt.BorderLayout());
        jPanelReal.add(realChart, BorderLayout.CENTER);
        jPanelReal.setVisible(true);
        jPanelReal.validate();

        jPanelImg.setLayout(new java.awt.BorderLayout());
        jPanelImg.add(imgChart, BorderLayout.CENTER);
        jPanelImg.setVisible(true);
        jPanelImg.validate();
        setOriginalRange();
    }

    public void setXScale(Range range) {
        realChart.getChart().getXYPlot().getDomainAxis().setRange(range);
        imgChart.getChart().getXYPlot().getDomainAxis().setRange(range);
    }

    protected final void setOriginalRange() {
        this.originalRange = realChart.getChart().getXYPlot().getDomainAxis().getRange();
    }

    @Override
    protected final XYSeriesCollection createDataset(Complex[] values, boolean isReal, double startTime, String title, int samplingRate) {
        XYSeries series = new XYSeries(title);
        double x;
        double y;
        int halfLength = values.length / 2;
        double lengthFactor = 1.0 * values.length / samplingRate;
        for (int i = 0; i < halfLength; i++) {
            if (isReal) {
                y = Math.sqrt(values[i].getReal() * values[i].getReal() + values[i].getImaginary() * values[i].getImaginary()) / halfLength;
            } else {
                y = Math.abs(values[i].getReal()) < 0.1 ? 0 : Math.atan2(values[i].getImaginary(), values[i].getReal()) * 180 / Math.PI;
            }
            x = i / lengthFactor + (startTime * samplingRate);
            series.add(x, y);
        }
        return new XYSeriesCollection(series);
    }
}
