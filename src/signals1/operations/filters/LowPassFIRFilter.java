/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.operations.filters;

import signals1.operations.MathFunctions;

/**
 *
 * @author glabg
 */
public class LowPassFIRFilter extends FIRFilter{
    
    public LowPassFIRFilter(final int order, final double fc, final double fs){
        super(order, fc, Double.POSITIVE_INFINITY, fs);
        final double cutoff = lowFrqCutoff / samplingRate;
        filter = new double[order + 1];
        final double factor = 2.0 * cutoff;
        final int half = order >> 1;
        for (int i = 0; i < filter.length; i++){
            filter[i] = factor * MathFunctions.SINC(factor * (i - half));
        }
    }

    @Override
    public double[] getFilter() {
        return filter;
    }
    
}
