/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.discrete;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;
import signals1.stats.Histogram;
import signals1.stats.HistogramCalculator;
import signals1.stats.SignalStats;
import signals1.stats.StatsCalculator;

/**
 *
 * @author glabg
 */
public class Impulse extends DiscreteSignal implements Serializable, ImpulseInterface {

    private static final int ZERO = 0;
    private static final int A = 1;
    private final int samples;
    private final int ns;

    public Impulse(int samplingRate, int duration, int ns) {
        super();
        this.ns = ns;
        this.samplingRate = samplingRate;
        this.duration = duration;
        this.samples = samplingRate * duration;
        this.fullName = "impuls jednostkowy";
        this.values = new Complex[samples];
        Arrays.fill(values, new Complex(ZERO, ZERO));
        values[ns - 1] = new Complex(A, ZERO);
        calculateStats();
    }

    @Override
    public int getSamplingRate() {
        return samplingRate;
    }

    @Override
    public Complex[] getValues() {
        return values;
    }

    @Override
    public double getStartTime() {
        return (1 - ns);
    }

    @Override
    public SignalStats getStats() {
        return stats;
    }

    @Override
    public double getDuration() {
        return (int) values.length / samplingRate;
    }

    @Override
    public Histogram getHistogram(int numberOfIntervals) {
        HistogramCalculator hisCalc = new HistogramCalculator(values);
        return hisCalc.getHistogram(numberOfIntervals);
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public double getAmplitude() {
        return A;
    }

    private void calculateStats() {
        this.stats = StatsCalculator.getStats(values);
    }
}
