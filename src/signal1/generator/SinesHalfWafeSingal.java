/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signal1.generator;

import org.apache.commons.math3.complex.Complex;
import signal1.generator.abstracts.PeriodicSignal;

/**
 *
 * @author marr
 */
public class SinesHalfWafeSingal extends PeriodicSignal {

    public SinesHalfWafeSingal(double[] samples, double amplitude, double timeSpan, double period) {
        super(samples, amplitude, timeSpan, period);
    }

    @Override
    public Complex[] generateSignal() {
        Complex[] result = new Complex[numberOfSamples];
        for (int i = 0; i < numberOfSamples; i++) {
            double radians = Math.toRadians(((2 * Math.PI) / period) * i);
            double res = 0.5 * amplitude * (Math.sin(radians) + Math.abs(Math.sin(radians)));
            result[i] = new Complex(res, 0);
        }
        return result;
    }

}
