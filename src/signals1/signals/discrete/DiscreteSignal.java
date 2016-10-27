/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.discrete;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.math3.complex.Complex;
import signals1.stats.Histogram;
import signals1.stats.SignalStats;

/**
 *
 * @author glabg
 */
public abstract class DiscreteSignal {

    private final int id;
    protected String fullName = "";
    static AtomicInteger nextId = new AtomicInteger();
    protected double startTime;
    protected double duration;
    protected double amplitude;
    protected int samplingRate;
    protected SignalStats stats;
    protected Complex[] values;

    protected DiscreteSignal() {
        id = nextId.incrementAndGet();
    }

    public Complex[] getValues(){
        return values;
    }

    public abstract Histogram getHistogram(int numberOfIntervals);

    public String getFullName() {
        return fullName;
    }

    public int getId() {
        return id;
    }
    
    public double getStartTime() {
        return startTime;
    }

    public double getDuration() {
        return duration;
    }

    public double getAmplitude() {
        return amplitude;
    }

    public int getSamplingRate() {
        return samplingRate;
    }

    public SignalStats getStats() {
        return stats;
    }
}
