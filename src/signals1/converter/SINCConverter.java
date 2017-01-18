/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.converter;

import org.apache.commons.math3.complex.Complex;
import signals1.discreteSignals.DerivedSignal;
import signals1.discreteSignals.abstracts.DiscreteSignal;
import signals1.operations.MathFunctions;

/**
 *
 * @author glabg
 */
public class SINCConverter implements D2AConverter {

    private Complex[] values;
    private Complex[] newValues;
    private int originalSamplingRate;
    private int newSamplingRate;

    @Override
    public DiscreteSignal convert(DiscreteSignal input, int samplingRate) {
        int aLength = (int) (input.getDuration() * samplingRate);
        values = input.getValues();
        newValues = new Complex[aLength];
        originalSamplingRate = input.getSamplingRate();
        newSamplingRate = samplingRate;

        for (int i = 0; i < newValues.length; i++) {
            newValues[i] = interpolate(30, i);
        }
        return new DerivedSignal(newValues, samplingRate, input.getStartTime(), input.getAmplitude());
    }

    public Complex interpolate(int window, int newSample) {
        Complex ret = Complex.ZERO;
        int start = newSample - (window / 2);
        if (start <= 0) {
            start = 0;
        }
        int end = newSample + (window / 2);
        if (end >= newValues.length) {
            end = newValues.length;
        }
        for (int i = start; i < end; i++) {
            double oldVal = values[(int) (i * (1.0 * originalSamplingRate / newSamplingRate))].getReal();
            double factor = MathFunctions.SINC((newSample - i) * (1.0 * originalSamplingRate / newSamplingRate));
            ret = ret.add(oldVal * factor);
        }
        return ret.multiply((1.0 * originalSamplingRate / newSamplingRate));
    }


}
