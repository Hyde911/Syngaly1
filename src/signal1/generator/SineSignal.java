/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signal1.generator;

import org.apache.commons.math3.complex.Complex;
import signal1.generator.abstracts.PeriodicSignal;
import signal1.generator.abstracts.Signal;
/**
 *
 * @author marr
 */
public class SineSignal extends PeriodicSignal{

    public SineSignal(double[] samples, double amplitude, double timeSpan, double period) {
        super(samples, amplitude, timeSpan, period);
    }

    @Override
    public Complex[] generateSignal() {
        Complex[] result = new Complex[numberOfSamples];
        for (int i = 0; i < numberOfSamples; i++){
            double temp = ((2 * Math.PI)/period) * (i);
            result[i] = new Complex(amplitude * Math.sin( Math.toRadians(temp)), 0);
        }
        return result;
    }
    
}