/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.converter;

import org.apache.commons.math3.complex.Complex;
import signals1.discreteSignals.DerivedSignal;
import signals1.discreteSignals.abstracts.DiscreteSignal;

/**
 *
 * @author glabg
 */
public class ZOHConverter implements D2AConverter {

    @Override
    public DiscreteSignal convert(DiscreteSignal input, int samplingRate) {
        int aLength = (int) (input.getDuration() * samplingRate);
        Complex[] aValues = new Complex[aLength];
        Complex[] dValues = input.getValues();

        int nextValue = aLength / dValues.length;
        int j = 0;
        int valueCounter = 0;
        for (int i = 0; i < aLength; i++) {
            if (valueCounter > nextValue) {
                valueCounter = 0;
                j++;
            }
            valueCounter++;
            aValues[i] = dValues[j];
        }

        return new DerivedSignal(aValues, samplingRate, input.getStartTime(), input.getAmplitude());
    }

}
