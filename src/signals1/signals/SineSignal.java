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
public class SineSignal extends SineLikeSignals{

    public SineSignal(double startTime, int numberOfSamples, double amplitude, int duration, double period) {
        super(startTime, numberOfSamples, amplitude, duration, period);
    }

    @Override
    protected Complex[] generateSignal() {
        this.result = new Complex[numberOfSamples];
        for (int i = 0; i < numberOfSamples; i++){
            double temp = ((2 * Math.PI)/period) * (i);
            this.result[i] = new Complex(amplitude * Math.sin( Math.toRadians(temp)), 0);
        }
        return result;
    }
    
}
