/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.abstracts;

import java.io.Serializable;
import org.apache.commons.math3.complex.Complex;
import signals1.stats.HistogramCalculator;
import signals1.stats.SignalStats;


/**
 *
 * @author marr
 */
public abstract class Signals implements Serializable {
    
    protected double amplitude;
    protected int duration;
    protected int numberOfSamples;
    protected Complex[]result;
    protected double startTime;
    protected SignalStats stats;
    protected int[]realHistogram;
    protected int[]imgHistogram;
    
    public Signals(double startTime, int numberOfSamples, double amplitude, int duration){
        this.startTime = startTime; 
        this.amplitude = amplitude;
        this.duration = duration;
        this.numberOfSamples = numberOfSamples;
    }

    public Complex[] getSignal(){
        if (result == null){
            generateSignal();
        }
            return result;
    }
    
    public SignalStats getStats(){
        if (this.stats == null){
            calculateStats();
        }
        return this.stats;
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
