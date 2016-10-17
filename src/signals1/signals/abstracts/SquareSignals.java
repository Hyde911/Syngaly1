/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.abstracts;

import signals1.stats.SignalStats;

/**
 *
 * @author marr
 */
public abstract class SquareSignals extends Signals {

    protected double period;
    protected int numberOfWholePeriods;
    protected int samplesPerPeriod;

    public SquareSignals(double startTime, int numberOfSamples, double amplitude, int duration, double period) {
        super(startTime, numberOfSamples, amplitude, duration);
        this.period = period;
        numberOfWholePeriods = (int) (duration / period);
        samplesPerPeriod = (int) ((numberOfSamples) / (numberOfWholePeriods));
    }

    public double getPeriod() {
        return period;
    }
    
    @Override
        protected SignalStats calculateStats(){
        return null;
    }
}
