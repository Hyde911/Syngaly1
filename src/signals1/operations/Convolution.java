/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.operations;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.math3.complex.Complex;
import signals1.discreteSignals.DerivedSignal;
import signals1.discreteSignals.abstracts.DiscreteSignal;
import signals1.fourier.FastFourierTransform;
import signals1.fourier.GGFourierTransform;
import signals1.tools.exceptions.NotPowerOfTwoException;

/**
 *
 * @author marr
 */
public class Convolution {

    public static DerivedSignal CalculateConvolutions(DiscreteSignal signal1, DiscreteSignal signal2) {
        int numberOfSamples1 = signal1.getValues().length;
        int numberOfSamples2 = signal2.getValues().length;
        int newSize = numberOfSamples1 + numberOfSamples2 - 1;

        Complex[] resValues = new Complex[newSize];

        int i1;
        Complex tmp;
        for (int i = 0; i < newSize; i++) {
            i1 = i;
            tmp = Complex.ZERO;
            for (int j = 0; j < numberOfSamples2; j++) {
                if (i1 >= 0 && i1 < numberOfSamples1) {
                    tmp = tmp.add(signal1.getValues()[i1].multiply(signal2.getValues()[j]));
                }
                i1--;
                resValues[i] = tmp;
            }
        }
        DerivedSignal result = new DerivedSignal(resValues, signal1.getSamplingRate(), signal1.getStartTime(), signal1.getAmplitude());
        return result;
    }
    
        public static DerivedSignal CalculateConvolutions(Complex[] signal1, Complex[] signal2, int samplingRate, double startTime, double amplitude) {
        int numberOfSamples1 = signal1.length;
        int numberOfSamples2 = signal2.length;
        int newSize = numberOfSamples1 + numberOfSamples2 - 1;

        Complex[] resValues = new Complex[newSize];

        int i1;
        Complex tmp;
        for (int i = 0; i < newSize; i++) {
            i1 = i;
            tmp = Complex.ZERO;
            for (int j = 0; j < numberOfSamples2; j++) {
                if (i1 >= 0 && i1 < numberOfSamples1) {
                    tmp = tmp.add(signal1[i1].multiply(signal2[j]));
                }
                i1--;
                resValues[i] = tmp;
            }
        }
            
        DerivedSignal result = null;
            result = new DerivedSignal(FastFourierTransform.iFft(resValues), samplingRate, startTime, amplitude);

        return result;
    }
    
    
}
