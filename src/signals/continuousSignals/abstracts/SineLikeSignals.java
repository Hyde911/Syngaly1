/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.continuousSignals.abstracts;

/**
 *
 * @author marr
 */
public abstract class SineLikeSignals extends PeriodicSignals {

    protected double phaseShift;

    public SineLikeSignals(double startTime, double amplitude, double duration, double period, double phaseShift) {
        super(startTime, amplitude, duration, period);
        this.phaseShift = phaseShift * Math.PI;
    }
}
