/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.continuousSignals;

import org.apache.commons.math3.complex.Complex;
import signals1.continuousSignals.abstracts.SineLikeSignals;

/**
 *
 * @author marr
 */
public class SineSignal extends SineLikeSignals {

    public SineSignal(double startTime, double amplitude, double duration, double period, double phaseShift) {
        super(startTime, amplitude, duration, period, phaseShift);
        this.fullName = "sin";
    }

    @Override
    protected void generateSignal() {
        this.result = new Complex[numberOfSamples];
        for (int i = 0; i < numberOfSamples; i++) {
            double temp = ((2 * Math.PI) / samplesPerPeriod) * (i);
            this.result[i] = new Complex(Math.sin(temp), 0);
        }
    }
}
