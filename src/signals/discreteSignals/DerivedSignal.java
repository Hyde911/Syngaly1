/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.discreteSignals;

import signals.discreteSignals.abstracts.DiscreteSignal;
import java.io.Serializable;
import org.apache.commons.math3.complex.Complex;
import signals.stats.Histogram;
import signals.stats.HistogramCalculator;
import signals.stats.StatsCalculator;

/**
 *
 * @author marr
 */
public class DerivedSignal extends DiscreteSignal implements Serializable {

    public DerivedSignal(Complex[] values, int samplingRate, double startTime, double amplitude) {
        super();
        this.fullName = "sygnał pochodny";
        this.samplingRate = samplingRate;
        this.startTime = startTime;
        this.amplitude = amplitude;
        this.values = values;
        this.duration = values.length * 1.0 / samplingRate;
        calculateStats();
    }

    @Override
    public Histogram getHistogram(int numberOfIntervals) {
        HistogramCalculator hisCalc = new HistogramCalculator(values);
        return hisCalc.getHistogram(numberOfIntervals);
    }

    private void calculateStats() {
        this.stats = StatsCalculator.getStats(values);
    }
}
