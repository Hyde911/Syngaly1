/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.operations.filters;

import org.apache.commons.math3.complex.Complex;
import signals1.operations.MathFunctions;
import signals1.operations.windows.WindowFunction;

/**
 *
 * @author glabg
 */
public class LowPassFIRFilter extends FIRFilter{
    
    public LowPassFIRFilter(final WindowFunction window, final int order, final double fc, final double fs){
        super(window, order, fc, Double.POSITIVE_INFINITY, fs);
        final double cutoff = lowFrqCutoff / samplingRate;
        filter = new Complex[order];
        final double factor = 2.0 * cutoff;
        final int half = order >> 1;
        for (int i = 0; i < filter.length; i++){
            filter[i] = new Complex(factor * MathFunctions.SINC(factor * (i - half)));
        }
        filter = window.apply(filter);
    }

    @Override
    public Complex[] getFilter() {
        return filter;
    }
    
}
