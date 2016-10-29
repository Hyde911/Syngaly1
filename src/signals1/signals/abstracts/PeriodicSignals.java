/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.abstracts;

import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author marr
 */
public abstract class PeriodicSignals extends Signals {

    protected double period;
    protected int numberOfWholePeriods;
    protected int samplesPerPeriod;
    protected Complex phaseShift;

    public PeriodicSignals(double startTime, double amplitude, double duration, double period) {
        super(startTime, amplitude, duration);
        this.period = period;
        numberOfWholePeriods = (int) (duration / period);
        samplesPerPeriod = (int) ((numberOfSamples) / (1.0 * duration / period));
    }

    public double getPeriod() {
        return period;
    }
}
