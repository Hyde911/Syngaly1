/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.abstracts;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.math3.complex.Complex;
import signals1.stats.SignalStats;


/**
 *
 * @author marr
 */
public abstract class Signals implements Serializable {
    
    private final int id;
    private int samplesPerSecond = 1_000_000;
    static AtomicInteger nextId = new AtomicInteger();
    protected double amplitude;
    protected int duration;
    protected int numberOfSamples;
    protected Complex[]result;
    protected double startTime;
    

    private Signals(){
        id = nextId.incrementAndGet();
    }
    
    public int getID(){
        return id;
    }
    
    public Signals(double startTime, double amplitude, int duration){
        this();
        this.startTime = startTime; 
        this.amplitude = amplitude;
        this.duration = duration;
        this.numberOfSamples = this.duration * samplesPerSecond;
        result = new Complex[numberOfSamples];
    }

    public Complex[] getSignal(int samplingRate){
            return null;
    }
    
    public double getAmplitude() {
        return amplitude;
    }

    public double getTimeSpan() {
        return duration;
    }

    public int getNumberOfSamples() {
        return numberOfSamples;
    }
    
    abstract protected void generateSignal();
    
    abstract protected void calculateStats();
    
}
