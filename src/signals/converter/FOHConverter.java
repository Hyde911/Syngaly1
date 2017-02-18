/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.converter;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.complex.Complex;
import signals.discreteSignals.DerivedSignal;
import signals.discreteSignals.abstracts.DiscreteSignal;

/**
 *
 * @author glabg
 */
public class FOHConverter implements D2AConverter {

    @Override
    public DiscreteSignal convert(DiscreteSignal input, int samplingRate) {
        int aLength = (int) (input.getDuration() * samplingRate);
        Complex[] aValues = new Complex[0];
        Complex[] dValues = input.getValues();
        int factor = aLength / dValues.length;
        Complex[] temp;
        for (int i = 0; i < dValues.length; i++) {
            if (i + 1 < dValues.length) {
                temp = interpolate(dValues[i].getReal(), dValues[i + 1].getReal(), factor);
                aValues = ArrayUtils.addAll(aValues, temp);
            }
        }

        return new DerivedSignal(aValues, samplingRate, input.getStartTime(), input.getAmplitude());
    }

    public static Complex[] interpolate(double start, double end, int count) {
        if (count < 2) {
            throw new IllegalArgumentException("interpolate: illegal count!");
        }
        Complex[] array = new Complex[count + 1];
        for (int i = 0; i <= count; ++i) {
            array[i] = new Complex(start + i * (end - start) / count);
        }
        return array;
    }

}
