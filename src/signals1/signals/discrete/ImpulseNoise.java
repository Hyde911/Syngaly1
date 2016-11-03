/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.discrete;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import org.apache.commons.math3.complex.Complex;
import signals1.stats.Histogram;
import signals1.stats.HistogramCalculator;
import signals1.stats.SignalStats;
import signals1.stats.StatsCalculator;

/**
 *
 * @author glabg
 */
public class ImpulseNoise extends DiscreteSignal implements ImpulseInterface, Serializable {

    private static final int ZERO = 0;
    private final int samples;
    private final int ns;

    public ImpulseNoise(double amplitude, int samplingRate, int duration, double startTime, int ns, double p) {
        super();
        this.amplitude = amplitude;
        this.samplingRate = samplingRate;
        this.duration = duration;
        this.startTime = startTime;
        this.ns = ns;
        this.samples = duration * samplingRate;
        this.values = new Complex[samples];
        this.fullName = "szum impulsowy";
        if (p == 0) {
            Arrays.fill(values, new Complex[ZERO]);
        } else {
            Random r = new Random();
            for (int i = 0; i < samples; i++) {
                if (r.nextInt(101) <= p * 100) {
                    values[i] = new Complex(amplitude, ZERO);
                } else {
                    values[i] = new Complex(ZERO, ZERO);
                }
            }
        }
        calculateStats();
    }

    @Override
    public Complex[] getValues() {
        return values;
    }

    @Override
    public int getSamplingRate() {
        return samplingRate;
    }

    @Override
    public double getStartTime() {
        return startTime;
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
        return amplitude;
    }

    private void calculateStats() {
        this.stats = StatsCalculator.getStats(values);
    }
}
