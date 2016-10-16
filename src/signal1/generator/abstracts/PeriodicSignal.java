/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signal1.generator.abstracts;

import signal1.generator.abstracts.Signal;

/**
 *
 * @author marr
 */
public abstract class PeriodicSignal extends Signal{
    protected double period;

    public PeriodicSignal(double[]samples, double amplitude, double timeSpan, double period) {
        super(samples, amplitude, timeSpan);
        this.period = period;
    }

    public double getPeriod() {
        return period;
    }
    
}
