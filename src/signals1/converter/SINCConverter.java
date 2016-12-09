/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.converter;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.analysis.function.Sinc;
import org.apache.commons.math3.complex.Complex;
import signals1.discreteSignals.DerivedSignal;
import signals1.discreteSignals.abstracts.DiscreteSignal;

/**
 *
 * @author glabg
 */
public class SINCConverter implements D2AConverter{
    
    private Complex [] values;
    private Complex [] newValues;
    private int originalSamplingRate;
    
    @Override
    public DiscreteSignal convert(DiscreteSignal input, int samplingRate) {
        int aLength = (int) (input.getDuration() * samplingRate);
        values = input.getValues();
        newValues = new Complex[aLength];
        originalSamplingRate = input.getSamplingRate();
        Complex[] aValues = new Complex[0];
        Complex[] dValues = input.getValues();
        
        int factor = aLength / dValues.length;
        /*
        Complex[] temp;
        for (int i = 0; i < dValues.length; i++) {
            if(i+1<dValues.length){
                temp = interpolate(dValues[i].getReal(), dValues[i+1].getReal(), factor);
                aValues = ArrayUtils.addAll(aValues, temp);
            }
        }
        
        return new DerivedSignal(aValues, samplingRate, input.getStartTime(), input.getAmplitude());
        */
        for (int i = 0; i < aLength; i++){
            newValues[i] = interpolate(0, (int)(input.getDuration() * originalSamplingRate), (int)(i * (1.0 * originalSamplingRate/ samplingRate)));
        }
        return new DerivedSignal(newValues, samplingRate, input.getStartTime(), input.getAmplitude());
    }
/*
    public static Complex[] interpolate(double start, double end, int count) {
        Complex[] array = new Complex[count + 1];
        Sinc f = new Sinc(true);
        for (int i = 0; i <= count; ++i) {
            array[i] = new Complex(start + i * f.value((end - start) / count));
        }
        return array;
    }
  */
    
    public Complex interpolate (int start, int end, int count){
        Sinc f = new Sinc(true);
        Complex ret = new Complex(0);
        Complex tmp1;
        double tmp2;
        for (int i = start; i < end; i++){
            tmp1 = values[i];
            tmp1 = tmp1.multiply(new Complex(SINC(count - i)));
            ret = ret.add(tmp1);
        }
        //System.out.println(ret.getReal());
        return ret;
    }
    
    public double SINC (double n){
        if (n == 0){
            return 1;
        }else{
            return Math.sin(Math.PI * n)/ Math.PI;
        }
    }
}
