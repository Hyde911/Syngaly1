/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.complex.Complex;
import signals1.signals.abstracts.Signals;

/**
 *
 * @author marr
 */
public class HistogramCalculator {

    private int numberOfClasses;
    private double classWidth;
    private double[] DisData;
    private double[] intervals;

    private double minReal = 0;
    private double minImg = 0;
    private double maxReal = 0;
    private double maxImg = 0;
    private Complex[] values;

    public HistogramCalculator(Complex[] output) {
        values = output;
        DisData = new double[output.length];
        calculateRange();
    }

    public double[] getRealHistogram(int numberOfIntervals, boolean getReal) {
        DisData = new double[DisData.length];
        numberOfClasses = numberOfIntervals;
        intervals = new double[numberOfIntervals];
        prepareIntervals(getReal);
        return DisData;

    }

    private void calculateRange() {
        for (Complex complex : values) {
            if (minReal > complex.getReal()) {
                minReal = complex.getReal();
            }
            if (maxReal < complex.getReal()) {
                maxReal = complex.getReal();
            }
            if (minImg > complex.getImaginary()) {
                minImg = complex.getImaginary();
            }
            if (maxImg < complex.getImaginary()) {
                maxImg = complex.getImaginary();
            }
        }
    }

    private void prepareIntervals(boolean getReal) {
        if (getReal) {
            classWidth = 1.0 * (maxReal - minReal) / numberOfClasses;
            for (int i = 0; i < numberOfClasses; i++) {
                intervals[i] = minReal + (classWidth * (i + 1)) - (classWidth / 2.0);
            }
        } else {
            classWidth = 1.0 * (maxImg - minImg) / numberOfClasses;
            for (int i = 0; i < numberOfClasses; i++) {
                intervals[i] = minImg + (classWidth * (i + 1)) - (classWidth / 2.0);
            }
        }
        chooseIntervals(getReal);
    }

    private void chooseIntervals(boolean getReal) {
        if (getReal) {
            for (int i = 0; i < values.length; i++) {
                for (int j = 0; j < numberOfClasses; j++) {
                    if (values[i].getReal() >= intervals[j] - (classWidth / 2.0)
                            && (values[i].getReal() <= intervals[j] + (classWidth / 2.0))) {
                        DisData[i] = intervals[j];
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < values.length; i++) {
                for (int j = 0; j < numberOfClasses; j++) {
                    if (values[i].getImaginary()>= intervals[j] - (classWidth / 2.0)
                            && (values[i].getImaginary() <= intervals[j] + (classWidth / 2.0))) {
                        DisData[i] = intervals[j];
                        break;
                    }
                }
            }
        }
    }
}
