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
public abstract class SquareSignals extends PeriodicSignals {

    protected int fillFactor;

    public SquareSignals(double startTime, double amplitude, double duration, double period, int fillFactor) {
        super(startTime, amplitude, duration, period);
        this.fillFactor = fillFactor;
    }

    public int getFillFactor() {
        return fillFactor;
    }
    
}
