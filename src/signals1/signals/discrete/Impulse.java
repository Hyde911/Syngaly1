/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.discrete;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;
import signals1.stats.Histogram;
import signals1.stats.SignalStats;

/**
 *
 * @author glabg
 */
public class Impulse implements Serializable, DiscreteSignal {

    private static final int ZERO = 0;
    private static final int A = 1;
    protected Complex[] values;
    private final int samplingRate;
    private final int samples;
    private final int duration;
    private double startTime;
    private final int ns;
    protected SignalStats stats;
    private String fullName = "impuls jednostkowy";

    public Impulse(int samplingRate, int duration, int ns) {
        this.ns = ns;
        this.samplingRate = samplingRate;
        this.duration = duration;
        this.samples = samplingRate * duration;
        this.values = new Complex[samples];
        Arrays.fill(values, new Complex(ZERO));
        values[ns - 1] = new Complex(A);
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
        return (1 - ns);
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

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public double getAmplitude() {
        return A;
    }
}
