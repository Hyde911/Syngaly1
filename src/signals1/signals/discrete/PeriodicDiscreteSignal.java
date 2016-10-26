/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.discrete;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;
import signals1.signals.abstracts.PeriodicSignals;
import signals1.signals.abstracts.Signals;
import signals1.stats.Histogram;
import signals1.stats.HistogramCalculator;
import signals1.stats.SignalStats;
import signals1.stats.StatsCalculator;

/**
 *
 * @author marr
 */
public class PeriodicDiscreteSignal implements DiscreteSignal, Serializable {

    protected Complex[] values;
    private int samplingRate;
    private double startTime;
    protected SignalStats stats;
    private double period;
    private int numberOfWholePeriods;
    private int samplesPerPeriod;
    private String fullName = "";
    private double amplitude;
    private double duration;
    private int numberOfSamples;

    public PeriodicDiscreteSignal(PeriodicSignals periodicSignal, int samplingRate) {
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
    public int getDuration() {
        return (int) values.length / samplingRate;
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
        int wholePeriodSamples = samplesPerPeriod * numberOfWholePeriods;
        Complex[] samplesForStats = Arrays.copyOf(values, wholePeriodSamples);
        this.stats = StatsCalculator.getStats(samplesForStats);
    }

    @Override
    public Histogram getHistogram(int numberOfIntervals) {
        int wholePeriodSamples = samplesPerPeriod * numberOfWholePeriods;
        Complex[] samplesForStats = Arrays.copyOf(values, wholePeriodSamples);
        HistogramCalculator hisCalc = new HistogramCalculator(samplesForStats);
        return hisCalc.getHistogram(numberOfIntervals);
    }

    private void getSamples(Signals signal) {
        values = new Complex[numberOfSamples];
        double factor = signal.getNumberOfSamples() / (1.0 * values.length);
        for (int i = 0; i < values.length; i++) {
            values[i] = signal.getSignal()[(int) (i * factor)];
        }
    }
}
