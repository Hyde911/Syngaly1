/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signal1.generator.abstracts;


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
    
    abstract public double[] generateSignal();
}
