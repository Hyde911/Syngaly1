/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.discreteSignals;

import signals1.discreteSignals.abstracts.DiscreteSignal;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;
import signals1.continuousSignals.abstracts.PeriodicSignals;
import signals1.continuousSignals.abstracts.AbstractSignal;
import signals1.stats.Histogram;
import signals1.stats.HistogramCalculator;
import signals1.stats.SignalStats;
import signals1.stats.StatsCalculator;
import signals1.tools.quantisation.NoneQuantizer;
import signals1.tools.quantisation.Quantizer;

/**
 *
 * @author marr
 */
public class PeriodicDiscreteSignal extends DiscreteSignal implements Serializable {

    private double period;
    private final int numberOfWholePeriods;
    private final int samplesPerPeriod;
    private final int numberOfSamples;
    private final Quantizer quantizer;

    public PeriodicDiscreteSignal(PeriodicSignals periodicSignal, int samplingRate, Quantizer quantizer) {
        super();
        this.quantizer = quantizer;
        this.samplingRate = samplingRate;
        this.startTime = periodicSignal.getStartTime();
        this.fullName = periodicSignal.getFullName();
        this.amplitude = periodicSignal.getAmplitude();
        this.duration = periodicSignal.getDuration();
        this.period = periodicSignal.getPeriod();
        numberOfSamples = (int) (samplingRate * periodicSignal.getDuration());
        numberOfWholePeriods = (int) (duration / period);
        samplesPerPeriod = (int) ((numberOfSamples) / (1.0 * duration / period));
        getSamples(periodicSignal);
        calculateStats();
        this.period = periodicSignal.getPeriod();
    }

    @Override
    public double getDuration() {
        return (int) values.length / samplingRate;
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
    public String getFullName() {
        return fullName;
    }

    public double getPeriod() {
        return period;
    }

    @Override
    public double getAmplitude() {
        return amplitude;
    }

    private void calculateStats() {
        if (numberOfWholePeriods > 0) {
            int wholePeriodSamples = samplesPerPeriod * numberOfWholePeriods;
            Complex[] samplesForStats = Arrays.copyOf(values, wholePeriodSamples);
            this.stats = StatsCalculator.getStats(samplesForStats);
        } else {
            this.stats = new SignalStats(0, 0, 0, 0, 0);
        }
    }

    @Override
    public Histogram getHistogram(int numberOfIntervals) {
        int wholePeriodSamples = samplesPerPeriod * numberOfWholePeriods;
        if (wholePeriodSamples < 1) {
            return Histogram.NULLHISTOGRAM;
        }
        Complex[] samplesForStats = Arrays.copyOf(values, wholePeriodSamples);
        HistogramCalculator hisCalc = new HistogramCalculator(samplesForStats);
        return hisCalc.getHistogram(numberOfIntervals);
    }

    private void getSamples(AbstractSignal signal) {
        values = new Complex[numberOfSamples];
        double factor = (1.0 * signal.getNumberOfSamples()) / (1.0 * values.length);
        Complex[] orValues = signal.getSignal();
        for (int i = 0; i < numberOfSamples; i++) {
            values[i] = quantizer.quantizeSample(orValues[(int) (i * factor)], amplitude);
        }
    }
}
