/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.discrete;

import java.io.Serializable;
import org.apache.commons.math3.complex.Complex;
import signals1.signals.abstracts.NoiseSignals;
import signals1.signals.abstracts.Signals;
import signals1.stats.Histogram;
import signals1.stats.HistogramCalculator;
import signals1.stats.SignalStats;
import signals1.stats.StatsCalculator;

/**
 *
 * @author marr
 */
public class NonPeriodicDiscreteSignal implements DiscreteSignal, Serializable {

    protected Complex[] values;
    private int samplingRate;
    private double startTime;
    protected SignalStats stats;
    private String fullName = "";
    private double amplitude;

    public NonPeriodicDiscreteSignal(NoiseSignals noiseSignal, int samplingRate) {
        this.samplingRate = samplingRate;
        this.startTime = noiseSignal.getStartTime();
        this.fullName = noiseSignal.getFullName();
        this.amplitude = noiseSignal.getAmplitude();
        getSamples(noiseSignal);
        calculateStats();
    }

    private void calculateStats() {
        this.stats = StatsCalculator.getStats(values);
    }

    @Override
    public Histogram getHistogram(int numberOfIntervals) {
        HistogramCalculator hisCalc = new HistogramCalculator(values);
        return hisCalc.getHistogram(numberOfIntervals);
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

    private void getSamples(Signals signal) {
        values = new Complex[(int) (samplingRate * signal.getDuration())];
        double factor =signal.getNumberOfSamples() / (1.0 * values.length);
        for (int i = 0; i < values.length; i++){
            values[i] = signal.getSignal()[(int)(i * factor)];
        }
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public double getAmplitude() {
        return amplitude;
    }
}
