/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.operations;

import org.apache.commons.math3.complex.Complex;
import signals1.discreteSignals.DerivedSignal;
import signals1.discreteSignals.abstracts.DiscreteSignal;

/**
 *
 * @author marr
 */
public class Correlation {
    
        public static DerivedSignal CalculateCorrelation(DiscreteSignal signal1, DiscreteSignal signal2) {
        int numberOfSamples1 = signal1.getValues().length;
        int numberOfSamples2 = signal2.getValues().length;
        int newSize = numberOfSamples1 + numberOfSamples2 - 1;

        Complex[] resValues = new Complex[newSize];

        int i1;
        Complex tmp;
        for (int i = 0; i < newSize; i++) {
            i1 = i;
            tmp = Complex.ZERO;
            for (int j = numberOfSamples2 - 1; j >= 0; j--) {
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
}
