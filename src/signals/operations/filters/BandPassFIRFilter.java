/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.operations.filters;

import org.apache.commons.math3.complex.Complex;
import signals.operations.windows.WindowFunction;

/**
 *
 * @author glabg
 */
public class BandPassFIRFilter extends FIRFilter {

    public BandPassFIRFilter(final WindowFunction window, final int order, final double lowFrqCutoff, final double highFrqCutoff, final double samplingRate) {
        super(window, order, lowFrqCutoff, highFrqCutoff, samplingRate);
        filter = createBandstop();
        final int half = order >> 1;
        for (int i = 0; i < filter.length; i++) {
            filter[i] = new Complex((i == half ? 1.0 : 0.0) - filter[i].getReal());
        }
    }

    public final Complex[] createBandstop() {
        final Complex[] low = new LowPassFIRFilter(window, order, lowFrqCutoff, samplingRate).getFilter();
        final Complex[] high = new HighPassFIRFilter(window, order, highFrqCutoff, samplingRate).getFilter();
        for (int i = 0; i < low.length; i++) {
            low[i] = new Complex(low[i].getReal() + high[i].getReal());
        }
        return low;
    }

    @Override
    public Complex[] getFilter() {
        return filter;
    }

}
