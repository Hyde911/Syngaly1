/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.operations.filters;

import signals1.operations.windows.WindowFunction;

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
            filter[i] = (i == half ? 1.0 : 0.0) - filter[i];
        }
    }

    public double[] createBandstop() {
        final double[] low = new LowPassFIRFilter(window, order, lowFrqCutoff, samplingRate).getFilter();
        final double[] high = new HighPassFIRFilter(window, order, highFrqCutoff, samplingRate).getFilter();
        for (int i = 0; i < low.length; i++) {
            low[i] += high[i];
        }
        return low;
    }

    @Override
    public double[] getFilter() {
        return filter;
    }

}
