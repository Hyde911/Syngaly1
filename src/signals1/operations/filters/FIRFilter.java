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
public abstract class FIRFilter {
    
    protected WindowFunction window;
    protected double[] filter = null;
    protected int order;
    protected double lowFrqCutoff;
    protected double highFrqCutoff;
    protected double samplingRate;

    public FIRFilter(final WindowFunction window, final int order, final double lowFrqCutoff, final double highFrqCutoff, final double samplingRate) {
        this.window = window;
        this.order = order;
        this.lowFrqCutoff = lowFrqCutoff;
        this.highFrqCutoff = highFrqCutoff;
        this.samplingRate = samplingRate;
    }
    
    public abstract double[] getFilter();
    
}
