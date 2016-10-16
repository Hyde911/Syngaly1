/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signal1.generator.abstracts;

import org.apache.commons.math3.complex.Complex;


/**
 *
 * @author marr
 */
public abstract class Signal {
    
    protected double amplitude;
    protected double timeSpan;
    protected int numberOfSamples;
    
    public Signal(double[]samples, double amplitude, double timeSpan){
        this.amplitude = amplitude;
        this.timeSpan = timeSpan;
        this.numberOfSamples = samples.length;
    }
    
    abstract public Complex[] generateSignal();

    public double getAmplitude() {
        return amplitude;
    }

    public double getTimeSpan() {
        return timeSpan;
    }

    public int getNumberOfSamples() {
        return numberOfSamples;
    }
    
}
