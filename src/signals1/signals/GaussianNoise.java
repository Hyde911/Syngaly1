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
public class GaussianNoise extends NoiseSignals {

    public GaussianNoise(double startTime, int numberOfSamples, double amplitude, int duration) {
        super(startTime, numberOfSamples, amplitude, duration);
    }

    @Override
    protected Complex[] generateSignal() {
        Random rand = new Random();
        this.result = new Complex[numberOfSamples];
        for (int i = 0; i < numberOfSamples; i++) {
            this.result[i] = new Complex(rand.nextGaussian() * amplitude, 0);
        }
        return result;
    }

}
