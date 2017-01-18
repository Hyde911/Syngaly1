/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.operations.filters;

/**
 *
 * @author glabg
 */
public class BandPassFIRFilter extends FIRFilter {

    public BandPassFIRFilter(int order, double lowFrqCutoff, double highFrqCutoff, double samplingRate) {
        super(order, lowFrqCutoff, highFrqCutoff, samplingRate);
        filter = createBandstop(order, lowFrqCutoff, highFrqCutoff, samplingRate);
        final int half = order >> 1;
        for (int i = 0; i < filter.length; i++) {
            filter[i] = (i == half ? 1.0 : 0.0) - filter[i];
        }
    }

    public double[] createBandstop(final int order, final double fcl, final double fch, final double fs) {
        final double[] low = new LowPassFIRFilter(order, fcl, fs).getFilter();
        final double[] high = new HighPassFIRFilter(order, fch, fs).getFilter();
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
