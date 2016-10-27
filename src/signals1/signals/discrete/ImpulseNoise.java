/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.discrete;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import org.apache.commons.math3.complex.Complex;
import signals1.stats.Histogram;
import signals1.stats.SignalStats;

/**
 *
 * @author glabg
 */
public class ImpulseNoise extends DiscreteSignal implements ImpulseInterface, Serializable {

    private static final int ZERO = 0;
    private final double amplitude;
    protected Complex[] values;
    private final int samplingRate;
    private final int samples;
    private final int duration;
    private final double startTime;
    private final int ns;
    protected SignalStats stats;

    public ImpulseNoise(double amplitude, int samplingRate, int duration, double startTime, int ns, double p) {
        super ();
        this.amplitude = amplitude;
        this.samplingRate = samplingRate;
        this.duration = duration;
        this.startTime = startTime;
        this.ns = ns;
        this.samples = duration * samplingRate;
        this.values = new Complex[samples];
        this.fullName = "szum impulsowy";
        if (p == 0) {
            Arrays.fill(values, new Complex[ZERO]);
        } else {
            Random r = new Random();
            for (int i = 0; i < samples; i++) {
                if (r.nextInt(101) <= p * 100) {
                    values[i] = new Complex(amplitude);
                } else {
                    values[i] = new Complex(ZERO);
                }
            }
        }
    }


    @Override
    public int getSamplingRate() {
        return samplingRate;
    }

    @Override
    public double getStartTime() {
        return startTime;
    }

    @Override
    public SignalStats getStats() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getDuration() {
        return (int) values.length / samplingRate;
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
        return amplitude;
    }
}
