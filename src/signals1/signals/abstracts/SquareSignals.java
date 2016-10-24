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
public abstract class SquareSignals extends PeriodicSignals {

    protected int fillFactor;

    public SquareSignals(double startTime, double amplitude, int duration, double period, int fillFactor) {
        super(startTime, amplitude, duration, period);
        this.fillFactor = fillFactor;
        generateSignal();
    }
}
