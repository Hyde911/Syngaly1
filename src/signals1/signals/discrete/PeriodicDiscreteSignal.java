/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.discrete;

import static java.lang.Math.round;
import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;
import signals1.signals.abstracts.PeriodicSignals;
import signals1.signals.abstracts.Signals;
import signals1.signals.abstracts.SineLikeSignals;
import signals1.signals.abstracts.SquareSignals;
import signals1.stats.Histogram;
import signals1.stats.HistogramCalculator;
import signals1.stats.SignalStats;
import signals1.stats.StatsCalculator;

/**
 *
 * @author marr
 */
public class PeriodicDiscreteSignal extends DescreetSignal {

    protected Complex[] values;
    private int samplingRate;
    private double startTime;
    protected SignalStats stats;
    private double period;
    private int numberOfWholePeriods;
    private int samplesPerPeriod;

    public PeriodicDiscreteSignal(PeriodicSignals periodicSignal, int samplingRate) {
        this.samplingRate = samplingRate;
        this.startTime = periodicSignal.getStartTime();
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

    public void calculateStats() {
        int wholePeriodSamples = samplesPerPeriod * numberOfWholePeriods;
        Complex[] samplesForStats = Arrays.copyOf(values, wholePeriodSamples);
        this.stats = StatsCalculator.getStats(samplesForStats);
    }

    public Histogram getHistogram(int numberOfIntervals) {
        int wholePeriodSamples = samplesPerPeriod * numberOfWholePeriods;
        Complex[] samplesForStats = Arrays.copyOf(values, wholePeriodSamples);
        HistogramCalculator hisCalc = new HistogramCalculator(samplesForStats);
        return hisCalc.getHistogram(numberOfIntervals);
    }

    private void getSamples(Signals signal) {
        values = new Complex[(int) (samplingRate * signal.getDuration())];
        double factor =signal.getNumberOfSamples() / (1.0 * values.length);
        for (int i = 0; i < values.length; i++){
            values[i] = signal.getSignal()[(int)(i * factor)];
        }
    }
}
