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
public abstract class SineLikeSignals extends Signals{
    protected double period;

    public SineLikeSignals(double startTime, int numberOfSamples, double amplitude, int duration, double period) {
        super(startTime, numberOfSamples, amplitude, duration);
        this.period = period;
    }

    public double getPeriod() {
        return period;
    }
    
}
