/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.abstracts;

/**
 *
 * @author marr
 */
public abstract class SineLikeSignals extends PeriodicSignals {

    public SineLikeSignals(double startTime, double amplitude, double duration, double period) {
        super(startTime, amplitude, duration, period);
    }

//    @Override
//    protected void calculateStats() {
//        int wholePeriodSamples = samplesPerPeriod * numberOfWholePeriods;
//        Complex[] samplesForStats = Arrays.copyOf(result, wholePeriodSamples);
//        this.stats = StatsCalculator.getStats(samplesForStats);
//    }
}
