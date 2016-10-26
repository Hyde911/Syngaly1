/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals;

import java.util.Random;
import org.apache.commons.math3.complex.Complex;
import signals1.signals.abstracts.NoiseSignals;

/**
 *
 * @author marr
 */
public class UniformNoise extends NoiseSignals {

    public UniformNoise(double startTime, double amplitude, double duration) {
        super(startTime, amplitude, duration);
        this.fullName = "szum jednorodny";
    }

    @Override
    protected void generateSignal() {
        this.result = new Complex[numberOfSamples];
        Random rand = new Random();
        this.result = new Complex[numberOfSamples];
        for (int i = 0; i < numberOfSamples; i++) {
            this.result[i] = new Complex(rand.nextDouble() * amplitude, 0);
        }
    }

}
