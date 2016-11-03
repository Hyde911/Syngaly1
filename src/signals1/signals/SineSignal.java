/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals;

import org.apache.commons.math3.complex.Complex;
import signals1.signals.abstracts.SineLikeSignals;

/**
 *
 * @author marr
 */
public class SineSignal extends SineLikeSignals {

    public SineSignal(double startTime, double amplitude, double duration, double period) {
        super(startTime, amplitude, duration, period);
        this.fullName = "sin";
    }

    @Override
    protected void generateSignal() {
        this.result = new Complex[numberOfSamples];
        for (int i = 0; i < numberOfSamples; i++) {
            double temp = ((2 * Math.PI) / samplesPerPeriod) * (i);
            this.result[i] = new Complex(amplitude * Math.sin(temp), 0);
        }
    }
}
