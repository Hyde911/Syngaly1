/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.abstracts;

import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;
import signals1.stats.SignalStats;
import signals1.stats.StatsCalculator;

/**
 *
 * @author marr
 */
public abstract class SineLikeSignals extends Signals {

    protected double period;
    protected int numberOfWholePeriods;
    protected int samplesPerPeriod;

    public SineLikeSignals(double startTime, int numberOfSamples, double amplitude, int duration, double period) {
        super(startTime, numberOfSamples, amplitude, duration);
        this.period = period;
        numberOfWholePeriods = (int) (duration / period);
        samplesPerPeriod = (int) ((numberOfSamples) / (numberOfWholePeriods));
    }

    public double getPeriod() {
        return period;
    }

    @Override
    protected void calculateStats() {
        int wholePeriodSamples = samplesPerPeriod * numberOfWholePeriods;
        Complex[] samplesForStats = Arrays.copyOf(result, wholePeriodSamples);
        this.stats = StatsCalculator.getStats(samplesForStats);
    }
}
