/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signal1.generator;

import java.util.Random;
import org.apache.commons.math3.complex.Complex;
import signal1.generator.abstracts.Signal;

/**
 *
 * @author marr
 */
public class GaussianNoise extends Signal{

    public GaussianNoise(double[]samples, double amplitude, double timeSpan) {
        super(samples, amplitude, timeSpan);
    }

    @Override
    public Complex[] generateSignal() {
        Random rand = new Random();
        Complex[] result =  new Complex[numberOfSamples];
        for (int i = 0; i < numberOfSamples; i++){
            result[i] = new Complex(rand.nextGaussian(), 0);
        }
        return result;
    }
    
    
}
