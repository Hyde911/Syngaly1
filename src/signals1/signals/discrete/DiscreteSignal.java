/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.discrete;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.math3.complex.Complex;
import signals1.stats.Histogram;
import signals1.stats.SignalStats;

/**
 *
 * @author glabg
 */
public abstract class DiscreteSignal implements Serializable{

    private transient int id;
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
    
    public Complex[] getValuesModAndShift(){
        Complex[] result = new Complex[this.values.length];
        for (int i = 0; i  < result.length; i++){
            result[i] = new Complex (Math.sqrt(values[i].getImaginary() * values[i].getImaginary() + values[i].getReal() * values[i].getReal()),
                                    Math.atan(values[i].getImaginary() / values[i].getReal()));
        }
        return result;
    }

    public abstract Histogram getHistogram(int numberOfIntervals);

    public Histogram getHistogramModAndShift(int numberOfIntervals){
        Histogram hist = getHistogram(numberOfIntervals);
        double []real = hist.getRealHistogram();
        double []img = hist.getImgHistogram();
        double []mod = new double[values.length];
        double []phase = new double[values.length];
        for (int i = 0; i < values.length; i++){
            mod[i] = Math.sqrt(real[i] * real[i] + img[i] * img[i]);
            phase[i] = Math.atan(img[i] / real[i]);
        }
        return new Histogram(mod, phase);
    }
    
    public String getFullName() {
        return fullName;
    }

    public int getId() {
        if (id == 0){
            id = nextId.incrementAndGet();
        }
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
