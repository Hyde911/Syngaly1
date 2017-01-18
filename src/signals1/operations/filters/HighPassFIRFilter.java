/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.operations.filters;

import signals1.operations.MathFunctions;
import signals1.operations.windows.WindowFunction;

/**
 *
 * @author glabg
 */
public class HighPassFIRFilter extends FIRFilter{
    
    public HighPassFIRFilter(final WindowFunction window, final int order, final double fc, final double fs){
        super(window, order, 0d, fc, fs);
        final double cutoff = highFrqCutoff / samplingRate;
        filter = new double[order + 1];
        final double factor = 2.0 * cutoff;
        final int half = order >> 1;
        for (int i = 0; i < filter.length; i++){
            filter[i] = (i == half ? 1.0 : 0.0) - factor * MathFunctions.SINC(factor * (i - half));
        }
        filter = window.apply(filter);
    }

    @Override
    public double[] getFilter() {
        return filter;
    }
}
