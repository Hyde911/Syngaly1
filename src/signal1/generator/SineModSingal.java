/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signal1.generator;

import signal1.generator.abstracts.PeriodicSignal;

/**
 *
 * @author marr
 */
public class SineModSingal extends PeriodicSignal {

    public SineModSingal(double[] samples, double amplitude, double timeSpan, double period) {
        super(samples, amplitude, timeSpan, period);
    }

    @Override
    public double[] generateSignal() {
        double[] result = new double[numberOfSamples];
        for (int i = 0; i < numberOfSamples; i++) {
            double temp = ((2 * Math.PI) / period) * (i);
            result[i] = Math.abs(amplitude * Math.sin(Math.toRadians(temp)));
        }
        return result;
    }

}
