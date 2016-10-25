/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.discrete;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;
import signals1.signals.discrete.DescreetSignal;
import signals1.stats.Histogram;
import signals1.stats.SignalStats;

/**
 *
 * @author glabg
 */
public class Impulse implements DescreetSignal, Serializable {

    private static final int ZERO = 0;
    private static final int A = 1;
    protected Complex[] values;
    private int samplingRate;
    private int samples;
    private double startTime;
    
    private int ns;
    protected SignalStats stats;
    
    public Impulse(int samplingRate,  int duration, int ns){
        this.ns = ns;
        this.samplingRate = samplingRate;
        this.samples = samplingRate*duration;
        this.values = new Complex[samples];
        Arrays.fill(values, new Complex(ZERO));
        values[ns+1] = new Complex(A);
    }
    
    @Override
    public Complex[] getValues() {
        return values;
    }

    @Override
    public int getSamplingRate() {
        return samplingRate;
    }

    @Override
    public double getStartTime() {
        return 0-(samples - ns);
    }

    @Override
    public SignalStats getStats() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDuration() {
        return samples;
    }

    @Override
    public Histogram getHistogram(int numberOfIntervals) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
